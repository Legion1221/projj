package chapters.chapter_12;

public class Client {
    private final int id;
    private final int callDuration;

    public Client(int id, int callDuration) {
        this.id = id;
        this.callDuration = callDuration;
    }

    public int getId() {
        return id;
    }

    public int getCallDuration() {
        return callDuration;
    }

    // Симуляция звонка клиента
    public void makeCall() {
        System.out.println("Клиент " + id + " звонит.");
        try {
            Thread.sleep(callDuration);  // Задержка будто бы действительно разговоривают
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Клиент " + id + " завершил звонок.");
    }
}

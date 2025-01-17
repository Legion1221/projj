package chapters.chapter_12;

public class Operator implements Runnable {
    private final Client client;

    public Operator(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Оператор начинает обслуживать клиента " + client.getId());
        client.makeCall();  // Оператор обслуживает клиента
        System.out.println("Оператор завершил обслуживание клиента " + client.getId());
    }
}

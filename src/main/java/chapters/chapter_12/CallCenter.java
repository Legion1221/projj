package chapters.chapter_12;

import java.util.concurrent.*;

public class CallCenter {
    private final ExecutorService operatorPool;
    private final BlockingQueue<Client> queue;

    // Конструктор, принимающий количество операторов и размер очереди клиентов
    public CallCenter(int numOperators, int queueSize) {
        operatorPool = Executors.newFixedThreadPool(numOperators);  // Пул операторов
        queue = new LinkedBlockingQueue<>(queueSize);  // Очередь клиентов
    }

    // Метод для добавления нового клиента в очередь
    public void addClient(Client client) {
        try {
            queue.put(client);  // Добавляем клиента в очередь
            System.out.println("Клиент " + client.getId() + " в очереди.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Метод для обслуживания клиента оператором
    public void startService() {
        while (true) {
            try {
                Client client = queue.take();  // Берём клиента из очереди
                operatorPool.submit(new Operator(client));  // Оператор обслуживает клиента
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Завершение работы call-центра
    public void shutDown() {
        operatorPool.shutdown();
    }
}

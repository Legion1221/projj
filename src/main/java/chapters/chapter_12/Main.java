package chapters.chapter_12;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 17.01.2025
 */

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(3, 10);  // 3 оператора и очередь на 10 клиентов

        // Запускаем обслуживание в отдельном потоке
        new Thread(callCenter::startService).start();

        // Создаём и добавляем клиентов
        for (int i = 1; i <= 15; i++) {
            Client client = new Client(i, (i % 5 + 1) * 1000);  // Клиент с уникальным id и случайной длительностью звонка
            callCenter.addClient(client);

            // Симуляция перезвона клиента
            try {
                Thread.sleep(2000);  // Задержка перед следующим звонком
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

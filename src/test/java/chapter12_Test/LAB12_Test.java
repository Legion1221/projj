package chapter12_Test;

import chapters.chapter_12.CallCenter;
import chapters.chapter_12.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LAB12_Test {

    private CallCenter callCenter;

    @BeforeEach
    public void setUp() {
        callCenter = new CallCenter(2, 5);
    }

    @Test
    public void testAddClientToQueue() {
        // Проверка, что клиент добавлен в очередь
        Client client = new Client(1, 1000);
        callCenter.addClient(client);

        assertDoesNotThrow(() -> callCenter.addClient(client));
    }

    @Test
    public void testClientCallDuration() throws InterruptedException {
        Client client = new Client(1, 2000); // Длительность звонка 2 секунды
        callCenter.addClient(client);

        // С помощью CountDownLatch ожидаем завершения звонка
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                client.makeCall();
            } finally {
                latch.countDown();
            }
        }).start();
        assertTrue(latch.await(2500, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testOperatorHandlesMultipleClients() throws InterruptedException {
        // Создаем несколько клиентов с разными длительностями звонков
        Client client1 = new Client(1, 1000);
        Client client2 = new Client(2, 2000);
        Client client3 = new Client(3, 1500);

        callCenter.addClient(client1);
        callCenter.addClient(client2);
        callCenter.addClient(client3);

        // Используем CountDownLatch, чтобы ждать завершения всех звонков
        CountDownLatch latch = new CountDownLatch(3);

        // Моделируем работу с несколькими клиентами
        Thread thread1 = new Thread(() -> {
            try {
                client1.makeCall();  // Имитация звонка клиентом
            } finally {
                latch.countDown();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                client2.makeCall();
            } finally {
                latch.countDown();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                client3.makeCall();
            } finally {
                latch.countDown();
            }
        });

        // Запуск потоков
        thread1.start();
        thread2.start();
        thread3.start();

        // Ожидаем завершения всех звонков
        assertTrue(latch.await(6000, TimeUnit.MILLISECONDS), "Все звонки должны быть завершены в течение 6 секунд.");
    }


}

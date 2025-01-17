package chapters.chapter_14.LAB14_A;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Адрес сервера
        int serverPort = 6000; // Порт сервера

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Подключено к серверу. Можете отправлять сообщения.");

            // Поток для чтения сообщений от сервера
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Сообщение от сервера: " + message);
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении сообщений: " + e.getMessage());
                }
            });
            readThread.setDaemon(true);
            readThread.start();

            // Отправка сообщений на сервер
            while (true) {
                System.out.print("Введите сообщение (или 'exit' для выхода): ");
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Отключение от сервера...");
                    break;
                }
                writer.write(message);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}

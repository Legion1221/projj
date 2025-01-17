package chapters.chapter_14.LAB14_B;

import java.io.*;
import java.net.*;

public class MessageProcessingServer {
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер обработки сообщений работает на порту " + SERVER_PORT);

            while (true) {
                // Ожидаем подключения клиента
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключился новый клиент: " + clientSocket.getInetAddress());

                // Создаем поток для обработки клиента
                new ClientRequestHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при запуске сервера: " + e.getMessage());
        }
    }

    static class ClientRequestHandler extends Thread {
        private final Socket clientSocket;

        public ClientRequestHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String receivedMessage;
                while ((receivedMessage = inputReader.readLine()) != null) {
                    System.out.println("Получено зашифрованное сообщение от прокси: " + receivedMessage);

                    // Расшифровываем сообщение
                    String originalMessage = decodeMessage(receivedMessage);
                    System.out.println("Расшифрованное сообщение: " + originalMessage);

                    // Формируем ответ и отправляем клиенту
                    String responseMessage = "Сервер подтвердил получение: " + originalMessage;
                    System.out.println("Отправка ответа: " + responseMessage);
                    outputWriter.println(responseMessage);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при общении с клиентом: " + e.getMessage());
            } finally {
                System.out.println("Обработка запроса клиента завершена.");
            }
        }
    }

    // метод расшифровки
    public static String decodeMessage(String encryptedMessage) {
        int shift = 3;
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - shift + 26) % 26 + base);
            }
            decryptedMessage.append(c);
        }

        return decryptedMessage.toString();
    }
}

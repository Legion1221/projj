package chapters.chapter_14.LAB14_B;

import java.io.*;
import java.net.*;

public class TCPProxyServer {
    private static final int PROXY_PORT = 8080;  // Порт прокси-сервера
    private static final String DESTINATION_SERVER_HOST = "localhost";  // Адрес целевого сервера
    private static final int DESTINATION_SERVER_PORT = 9090;  // Порт целевого сервера

    public static void main(String[] args) {
        try (ServerSocket proxyServerSocket = new ServerSocket(PROXY_PORT)) {
            System.out.println("Прокси-сервер TCP слушает на порту " + PROXY_PORT);

            while (true) {
                Socket clientConnection = proxyServerSocket.accept();
                System.out.println("Новый клиент подключился: " + clientConnection.getInetAddress());

                // Запускаем поток для клиента
                new ClientConnectionHandler(clientConnection).start();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при запуске прокси-сервера: " + e.getMessage());
        }
    }

    static class ClientConnectionHandler extends Thread {
        private final Socket clientSocket;

        public ClientConnectionHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter clientOutput = new PrintWriter(clientSocket.getOutputStream(), true);
                 Socket destinationServerSocket = new Socket(DESTINATION_SERVER_HOST, DESTINATION_SERVER_PORT);
                 BufferedReader serverInput = new BufferedReader(new InputStreamReader(destinationServerSocket.getInputStream()));
                 PrintWriter serverOutput = new PrintWriter(destinationServerSocket.getOutputStream(), true)) {

                System.out.println("Обрабатываем сообщения между клиентом и целевым сервером...");

                String clientMessage;
                while ((clientMessage = clientInput.readLine()) != null) {
                    // Модифицируем сообщение перед передачей на сервер
                    String transformedMessage = transformMessage(clientMessage);
                    System.out.println("Перенаправляем сообщение на целевой сервер: " + transformedMessage);
                    serverOutput.println(transformedMessage);

                    // Получаем ответ от сервера и пересылаем его клиенту
                    String serverResponse = serverInput.readLine();
                    if (serverResponse == null) {
                        System.out.println("Соединение с целевым сервером закрыто.");
                        break;
                    }
                    System.out.println("Перенаправляем ответ сервера клиенту: " + serverResponse);
                    clientOutput.println(serverResponse);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при коммуникации: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии сокета клиента: " + e.getMessage());
                }
            }
        }

        String transformMessage(String message) {
            int shift = 3; // Сдвиг на 3 символа
            StringBuilder encryptedMessage = new StringBuilder();

            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base + shift) % 26 + base);
                }
                encryptedMessage.append(c);
            }
            return encryptedMessage.toString();
        }
    }
}

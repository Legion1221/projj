package chapters.chapter_14.LAB14_A;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private static final int PORT = 6000;
    private static final Map<Integer, ClientHandler> clientMap = new ConcurrentHashMap<>();
    private static volatile boolean serverActive = true;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);

            Thread consoleThread = new Thread(ChatServer::handleConsoleInput);
            consoleThread.setDaemon(true);
            consoleThread.start();

            acceptClients(server);
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        } finally {
            stopServer();
        }
    }

    private static void acceptClients(ServerSocket server) throws IOException {
        int clientId = 0;
        while (serverActive) {
            Socket clientSocket = server.accept();
            ClientHandler client = new ClientHandler(clientSocket, clientId++);
            clientMap.put(client.getClientId(), client);
            new Thread(client).start();
            System.out.println("Клиент подключен: " + client.getClientInfo());
        }
    }

    private static void handleConsoleInput() {
        Scanner scanner = new Scanner(System.in);

        while (serverActive) {
            if (clientMap.isEmpty()) {
                System.out.println("Нет активных клиентов.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
                continue;
            }

            System.out.println("Список активных клиентов:");
            clientMap.forEach((id, client) -> System.out.println("ID " + id + ": " + client.getClientInfo()));

            System.out.print("Введите ID клиентов (через запятую), чтобы отправить сообщение, или 'stop' для остановки сервера: ");
            String input = scanner.nextLine();
            if ("stop".equalsIgnoreCase(input)) {
                serverActive = false;
                break;
            }

            List<ClientHandler> selectedClients = parseClientIds(input);
            if (!selectedClients.isEmpty()) {
                System.out.print("Введите сообщение: ");
                String message = scanner.nextLine();
                broadcastMessage(message, selectedClients);
            }
        }
    }

    private static List<ClientHandler> parseClientIds(String input) {
        List<ClientHandler> clients = new ArrayList<>();
        if (input == null || input.trim().isEmpty()) {
            System.out.println("ID клиентов не указаны.");
            return clients;
        }

        try {
            String[] ids = input.split(",");
            for (String idStr : ids) {
                int id = Integer.parseInt(idStr.trim());
                ClientHandler client = clientMap.get(id);
                if (client != null) {
                    clients.add(client);
                } else {
                    System.out.println("Неверный ID клиента: " + id);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Используйте числа, разделенные запятыми.");
        }
        return clients;
    }

    private static void broadcastMessage(String message, List<ClientHandler> clients) {
        if (message.trim().isEmpty()) {
            System.out.println("Невозможно отправить пустое сообщение.");
            return;
        }

        for (ClientHandler client : clients) {
            boolean success = client.sendMessage(message);
            System.out.println("Сообщение клиенту " + client.getClientInfo() + (success ? " отправлено." : " не отправлено."));
        }
    }

    private static void stopServer() {
        serverActive = false;
        clientMap.values().forEach(ClientHandler::disconnect);
        clientMap.clear();
        System.out.println("Сервер остановлен.");
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final BufferedWriter writer;
        private final int clientId;

        ClientHandler(Socket socket, int clientId) throws IOException {
            this.socket = socket;
            this.clientId = clientId;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("От клиента " + getClientInfo() + ": " + message);
                    writer.write("Сообщение получено: " + message);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                System.err.println("Клиент отключен: " + getClientInfo());
            } finally {
                disconnect();
            }
        }

        public boolean sendMessage(String message) {
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
                return true;
            } catch (IOException e) {
                System.err.println("Не удалось отправить сообщение клиенту " + getClientInfo() + ": " + e.getMessage());
                return false;
            }
        }

        public void disconnect() {
            try {
                socket.close();
                clientMap.remove(clientId);
                System.out.println("Клиент удален: " + getClientInfo());
            } catch (IOException ignored) {}
        }

        public String getClientInfo() {
            return socket.getInetAddress() + ":" + socket.getPort();
        }

        public int getClientId() {
            return clientId;
        }
    }
}

package chapters.chapter_14.LAB14_B;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 17.01.2025
 */

import java.io.*;
import java.net.*;

public class ProxyClient {
    private static final String PROXY_SERVER_HOST = "localhost";  // Адрес прокси-сервера
    private static final int PROXY_SERVER_PORT = 8080;            // Порт прокси-сервера

    public static void main(String[] args) {
        try (Socket socket = new Socket(PROXY_SERVER_HOST, PROXY_SERVER_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Успешное подключение к прокси-серверу!");

            // Ввод сообщения от пользователя
            System.out.print("Пожалуйста, введите сообщение для отправки через прокси: ");
            String userMessage = inputReader.readLine();

            // Отправляем сообщение на прокси-сервер
            writer.println(userMessage);
            System.out.println("Сообщение отправлено на прокси-сервер: " + userMessage);

            // Получаем ответ от сервера через прокси
            String serverResponse = reader.readLine();
            if (serverResponse != null) {
                System.out.println("Ответ от сервера: " + serverResponse);
            } else {
                System.out.println("Ответ от сервера не получен.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка связи: " + e.getMessage());
        }
    }
}

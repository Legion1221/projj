package chapters.chapter_9;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 13.01.2025
 */

import java.io.*;
import java.util.*;

public class Process {

    public static void main(String[] args) {
        String fileName = "src/chapters/chapter_9/numbers.txt";  // Путь к файлу

        try {
            // Чтение из файла
            List<String> numbers = readNumbersFromFile(fileName);

            // Преобразование строк в числа и вычисление суммы и среднего
            List<Double> validNumbers = new ArrayList<>();
            for (String number : numbers) {
                try {
                    // Заменяем запятую на точку, если она присутствует
                    number = number.replace(',', '.');
                    validNumbers.add(Double.parseDouble(number.trim()));
                } catch (NumberFormatException e) {
                    // Обработка некорректного числа
                    System.out.println("Некорректное число: " + number);
                }
            }

            // Если список не пустой вычисляем сумму и среднее
            if (!validNumbers.isEmpty()) {
                double sum = validNumbers.stream().mapToDouble(Double::doubleValue).sum();
                double average = sum / validNumbers.size();

                System.out.println("Сумма чисел: " + sum);
                System.out.println("Среднее значение: " + average);
            } else {
                System.out.println("Нет корректных чисел для обработки.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("Ошибка: недостаточно памяти для обработки данных.");
        }
    }

    // Метод для чтения из файла
    public static List<String> readNumbersFromFile(String fileName) throws IOException {
        List<String> numbers = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден: " + fileName);
        }

        // Чтение содержимого
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(line.trim()); // Добавляем строку в список
            }
        }
        return numbers;
    }
}

package chapters.chapter_10.LAB10_C;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 17.01.2025
 */

import java.io.*;
import java.util.*;

public class TextProcessor {
    public static void main(String[] args) {
        String inputFile = "src/chapters/chapter_10/LAB10_C/input.txt";
        String outputFile = "src/chapters/chapter_10/LAB10_C/output.txt";

        // Чтение из файла
        List<String> lines = readFile(inputFile);

        // Увеличиваем буквы
        List<String> processedLines = processText(lines);

        // Запись в файл
        writeFile(outputFile, processedLines);

        System.out.println("Результат записан в файл: " + outputFile);
    }

    // Чтение файла
    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Преобразование текста: замена строчных букв на прописные в словах длинее двух символов
    public static List<String> processText(List<String> lines) {
        List<String> processedLines = new ArrayList<>();

        // Проходим по каждой строке
        for (String line : lines) {
            // Разделяем строку на слова
            String[] words = line.split("\\s+");
            StringBuilder processedLine = new StringBuilder();

            // Перебираем все слова
            for (String word : words) {
                // Если длина слова больше двух символов увеличиваем буквы
                if (word.length() > 2) {
                    processedLine.append(word.toUpperCase()).append(" ");
                } else {
                    // Если слово короче или равно двум символам оставляем его без изменений
                    processedLine.append(word).append(" ");
                }
            }

            // Добавляем обработанную строку в результат
            processedLines.add(processedLine.toString().trim());
        }
        return processedLines;
    }

    // Запись обработанного текста в файл
    public static void writeFile(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

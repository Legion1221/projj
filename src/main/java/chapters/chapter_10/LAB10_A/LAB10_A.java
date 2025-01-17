package chapters.chapter_10.LAB10_A;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 14.01.2025
 */

import java.io.*;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

public class LAB10_A {
    //Метод для поиска слов, где последняя буква одного слова совпадает с первой буквой следующего.
    public static List<String> findMatchingWords(List<String> lines) {
        List<String> matchingWords = new LinkedList<>();

        // Объединяем строки в одну с пробелами между ними
        StringBuilder fullText = new StringBuilder();
        for (String line : lines) {
            fullText.append(line).append(" ");
        }

        // разбиваем объединенную строку на отдельные слова
        String[] words = fullText.toString().trim().split("\\s+");

        // Перебираем и проверяем есть ли совпадение первой буквы следующего с последней буквой текущего
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            // Проверяем совпадение последней буквы первого слова с первой буквой следующего
            if (currentWord.charAt(currentWord.length() - 1) == nextWord.charAt(0)) {
                // Добавляем слова в результат
                matchingWords.add(currentWord + " " + nextWord);  // Соединяем пару слов в одну строку
            }
        }

        // Возвращаем список
        return matchingWords;
    }

    // Чтение из файла
    public static List<String> readFromFile(String filePath) throws IOException {
        List<String> lines = new LinkedList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    // Запись в файл
    public static void writeToFile(List<String> result, String filePath) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (String pair : result) {
                writer.write(pair);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "src/chapters/chapter_10/LAB10_A/input.txt";
        String outputFilePath = "src/chapters/chapter_10/LAB10_A/output.txt";

        try {
            // Чтение строк из файла
            List<String> lines = readFromFile(inputFilePath);

            // Поиск слов
            List<String> result = findMatchingWords(lines);

            // Запись результата в файл
            writeToFile(result, outputFilePath);

            System.out.println("Результат записан в файл: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

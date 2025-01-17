package chapters.chapter_11.LAB11_A;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 17.01.2025
 */

import java.io.*;
import java.util.*;

public class LAB11_A {
    public static void main(String[] args) {
        String inputFile = "src/main/java/chapters/chapter_11/LAB11_A/poem_input.txt";
        String outputFile = "src/main/java/chapters/chapter_11/LAB11_A/poem_output.txt";

        // Чтение стихотворения из файла
        List<String> poem = readPoemFromFile(inputFile);

        // Сортировка строк по длине
        List<String> sortedPoem = sortPoemByLineLength(poem);

        // Запись отсортированного стихотворения в файл
        writePoemToFile(outputFile, sortedPoem);

        System.out.println("Результат записан в файл: " + outputFile);
    }

    // Метод для чтения стихотворения из файла
    public static List<String> readPoemFromFile(String filePath) {
        List<String> poem = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                poem.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return poem;
    }

    // Метод для сортировки стихотворения по длине строк
    public static List<String> sortPoemByLineLength(List<String> poem) {
        List<String> sortedPoem = new ArrayList<>(poem);
        sortedPoem.sort(Comparator.comparingInt(String::length));
        return sortedPoem;
    }

    // Метод для записи отсортированного стихотворения в файл
    public static void writePoemToFile(String filePath, List<String> poem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : poem) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

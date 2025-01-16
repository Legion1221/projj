package chapters.chapter_10.LAB10_A;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LAB10_A {

    public static void main(String[] args) {
        // Проверяем были ли переданы аргументы командной строки
        if (args.length != 2) {
            System.out.println("Использование: java WordMatcher <входной_файл> <выходной_файл>");
            return;
        }

        // Указываем относительные пути к файлам
        String inputFile = "src/chapters/chapter_10/" + args[0];
        String outputFile = "src/chapters/chapter_10/" + args[1];

        try {
            // Чтение текста из файла
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            List<String> result = findMatchingWords(lines);

            // Запись результата в файл
            Files.write(Paths.get(outputFile), result);
            System.out.println("Результат записан в файл: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод находящий слова в которых последняя буква совпадает с первой буквой следующего слова
    private static List<String> findMatchingWords(List<String> lines) {
        List<String> result = new ArrayList<>();

        // Обработка каждой строки текста
        for (String line : lines) {
            String[] words = line.split("\\s+");  // Разбиваем строку на слова

            // Проверка каждого соседнего слова
            for (int i = 0; i < words.length - 1; i++) {
                String currentWord = words[i].trim();
                String nextWord = words[i + 1].trim();

                // Проверка на совпадение слов в которых последняя буква совпадает с первой буквой следующего слова
                if (currentWord.length() > 0 && nextWord.length() > 0) {
                    char lastChar = currentWord.charAt(currentWord.length() - 1);
                    char firstChar = nextWord.charAt(0);

                    if (lastChar == firstChar) {
                        result.add(currentWord + " " + nextWord);  // Добавляем слова в результат
                    }
                }
            }
        }

        return result;
    }
}

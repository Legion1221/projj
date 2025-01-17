package chapters.chapter_8;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 12.01.2025
 */

import java.util.*;

public class LAB8_B {

    // Ищем слова заданой длины
    public static Set<String> findWordsInQuestions(String text, int length) {
        Set<String> result = new HashSet<>();

        // Разбиваем текст на предложения
        String[] sentences = text.split("(?<=[.!?])\\s*");

        // Проходим по каждому предложению
        for (String sentence : sentences) {
            // Если предложение заканчивается на вопросительный знак, это вопрос
            if (sentence.trim().endsWith("?")) {
                // Находим все слова в предложении
                String[] words = sentence.split("\\W+"); // Разделяем по неалфавитным символам

                // Добавляем слова заданной длины в набор
                for (String word : words) {
                    if (word.length() == length) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "Hello, how are you? Is this the right way? What is this thing? Where did you go?";
        int wordLength = 3; // Слова длинной 3

        Set<String> words = findWordsInQuestions(text, wordLength);

        // Выводим уникальные слова
        System.out.println("Найденные слова длины " + wordLength + ": " + words);
    }
}

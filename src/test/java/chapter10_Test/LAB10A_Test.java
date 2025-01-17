package chapter10_Test;

import chapters.chapter_10.LAB10_A.LAB10_A;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordMatcherTest {

    @Test
    void testFindMatchingWords() {
        // Тестовые данные
        List<String> lines = Arrays.asList(
                "apple",
                "elephant",
                "keyboard race egg"
        );

        // Ожидаем
        List<String> expected = Arrays.asList(
                "apple elephant",
                "race egg"
        );

        // Вызов метода
        List<String> result = LAB10_A.findMatchingWords(lines);

        // Проверка
        assertEquals(expected, result, "Список найденных слов не совпадает с ожидаемым");
    }

    @Test
    void testFindMatchingWords_NoMatches() {
        // Без совпадений
        List<String> lines = Arrays.asList(
                "cat",
                "dog",
                "mouse"
        );

        // Ожидаем
        List<String> expected = Arrays.asList();

        // Вызов метода
        List<String> result = LAB10_A.findMatchingWords(lines);

        // Проверка результата
        assertEquals(expected, result, "Метод должен возвращать пустой список при отсутствии совпадений");
    }

    @Test
    void testFindMatchingWords_EmptyInput() {
        // Пустой ввод
        List<String> lines = Arrays.asList();

        // Ожидаем
        List<String> expected = Arrays.asList();

        // Вызов метода
        List<String> result = LAB10_A.findMatchingWords(lines);

        // Проверка результата
        assertEquals(expected, result, "Метод должен возвращать пустой список для пустого ввода");
    }

    @Test
    void testFindMatchingWords_SingleLineMatch() {
        // Одна строка с совпадением
        List<String> lines = Arrays.asList("race egg");

        // Ожидаем
        List<String> expected = Arrays.asList("race egg");

        // Вызов метода
        List<String> result = LAB10_A.findMatchingWords(lines);

        // Проверка результата
        assertEquals(expected, result, "Метод должен корректно обрабатывать одну строку с совпадением");
    }

    @Test
    void testFindMatchingWords_IgnoreCase() {
        // С разным регистром
        List<String> lines = Arrays.asList("Apple", "elephant");

        // Ожидаем
        List<String> expected = Arrays.asList("Apple elephant");

        // Вызов метода
        List<String> result = LAB10_A.findMatchingWords(lines);

        // Проверка результата
        assertEquals(expected, result, "Метод должен учитывать регистр букв");
    }
}

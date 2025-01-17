package chapter11_Test;

import chapters.chapter_11.LAB11_A.LAB11_A;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PoemSorterTest {

    @Test
    void testSortPoemLinesByLength() {
        List<String> poemLines = Arrays.asList(
                "Тестовый стишочек",
                "Самая длинная строка",
                "Короткая строка"
        );

        List<String> expected = Arrays.asList(
                "Короткая строка",
                "Тестовый стишочек",
                "Самая длинная строка"
        );

        List<String> sortedPoemLines = LAB11_A.sortPoemByLineLength(poemLines);

        assertEquals(expected, sortedPoemLines, "Строки не были отсортированы правильно по длине");
    }

    @Test
    void testSortPoemLinesByLength_EmptyList() {
        // Пустой список
        List<String> poemLines = Arrays.asList();

        List<String> expected = Arrays.asList();

        List<String> sortedPoemLines = LAB11_A.sortPoemByLineLength(poemLines);

        assertEquals(expected, sortedPoemLines, "Пустой список должен возвращать пустой результат");
    }

    @Test
    void testSortPoemLinesByLength_SingleElement() {
        // С одним элементом
        List<String> poemLines = Arrays.asList("Только один");

        List<String> expected = Arrays.asList("Только один");

        List<String> sortedPoemLines = LAB11_A.sortPoemByLineLength(poemLines);

        assertEquals(expected, sortedPoemLines, "Список с одним элементом должен остаться неизменным");
    }

}

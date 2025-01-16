package chapter8_Test;

import chapters.chapter_8.LAB8_B;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class LAB8B_Test {

    @Test
    public void testFindWordsInQuestions() {
        // Проверка слов длиной 3 в вопросах
        String text = "Hello, how are you? Is this the right way? What is this thing? Where did you go?";
        int wordLength = 3;
        Set<String> words = LAB8_B.findWordsInQuestions(text, wordLength);

        Set<String> expected = Set.of("how", "are", "you", "the", "way", "did");
        assertEquals(expected, words, "Слова не совпадают с ожидаемыми!");
    }

    @Test
    public void testFindNoWordsOfGivenLength() {
        // Нет слов длиной 3
        String text = "This is a test.";
        int wordLength = 3;
        Set<String> words = LAB8_B.findWordsInQuestions(text, wordLength);
        Set<String> expected = Set.of();
        assertEquals(expected, words, "Найдено ненужное слово!");
    }

    @Test
    public void testFindWordsInEmptyText() {
        // Пустой текст
        String text = "";
        int wordLength = 3;
        Set<String> words = LAB8_B.findWordsInQuestions(text, wordLength);

        // Пустое множество
        Set<String> expected = Set.of();
        assertEquals(expected, words, "Текст пуст, а слова найдены!");
    }

}

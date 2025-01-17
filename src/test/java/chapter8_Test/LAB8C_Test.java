package chapter8_Test;

import chapters.chapter_8.LAB8_C;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LAB8C_Test {

    @Test
    public void testMinimizeSentences() {
        //Простой тест
        String text = "Мыши - это грызуны. Они бегают быстро. Я люблю играть в игры. Мыши часто прячутся.";
        List<String> result = LAB8_C.minimizeSentences(text);
        assertEquals(2, result.size());
        assertTrue(result.contains("Мыши - это грызуны."));
        assertTrue(result.contains("Мыши часто прячутся."));
    }

    @Test
    public void testEmptyText() {
        //Пустой тест
        String text = "";
        List<String> result = LAB8_C.minimizeSentences(text);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleSentence() {
        //Тест с одним предолжением. Выведет только его
        String text = "Мыши - это грызуны.";
        List<String> result = LAB8_C.minimizeSentences(text);
        assertEquals(1, result.size());
        assertTrue(result.contains("Мыши - это грызуны."));
    }

    @Test
    public void testNoCommonWords() {
        //Тест с предложениями без одинаковых слов. Будет возвращено только первое предложение
        String text = "Я люблю котов. У меня есть собака.";
        List<String> result = LAB8_C.minimizeSentences(text);
        assertEquals(1, result.size());
    }
}

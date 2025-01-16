package chapter8_Test;

import chapters.chapter_8.LAB8_A;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LAB8A_Test {

    // Тест 1: Вставка подстроки в середину текста
    @Test
    public void testInsertSubstringInMiddle() {
        String text = "Поставьте отлично";
        String substring = "пожалуйста ";
        int k = 9;
        String result = LAB8_A.insertSubstring(text, k, substring);
        assertEquals("Поставьте пожалуйста отлично", result);
    }

    // Тест 2: Вставка подстроки в начало текста
    @Test
    public void testInsertSubstringAtStart() {
        String text = "отлично";
        String substring = "Поставьте ";
        int k = -1; // вставляем в начало
        String result = LAB8_A.insertSubstring(text, k, substring);
        assertEquals("Поставьте отлично", result);
    }

    // Тест 3: Вставка подстроки в конец текста
    @Test
    public void testInsertSubstringAtEnd() {
        String text = "Поставьте ";
        String substring = "отлично";
        int k = 20; // k больше длины строки, вставляется в конец
        String result = LAB8_A.insertSubstring(text, k, substring);
        assertEquals("Поставьте отлично", result);
    }

    // Тест 4: Вставка подстроки в пустую строку
    @Test
    public void testInsertSubstringInEmptyString() {
        String text = "";
        String substring = "Поставьте";
        int k = 0; // вставка в пустую строку
        String result = LAB8_A.insertSubstring(text, k, substring);
        assertEquals("Поставьте", result);
    }

    // Тест 5: Проверка на null аргументы
    @Test
    public void testNullArguments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LAB8_A.insertSubstring(null, 3, "Test");
        });
        assertEquals("Текст и подстрока не должны быть null", exception.getMessage());
    }
}

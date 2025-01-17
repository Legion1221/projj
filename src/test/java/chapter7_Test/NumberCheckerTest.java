package chapter7_Test;

import static org.junit.jupiter.api.Assertions.*;

import chapters.chapter_7.NumberChecker;
import org.junit.jupiter.api.Test;

public class NumberCheckerTest {

    @Test
    public void testCheckDivisibilityBy13() {
        NumberChecker isDivisibleBy13 = number -> number % 13 == 0;

        // Проверяем делимость для разных чисел
        assertTrue(isDivisibleBy13.check(39));  // 39 делится на 13
        assertFalse(isDivisibleBy13.check(100)); // 100 не делится на 13
    }
}

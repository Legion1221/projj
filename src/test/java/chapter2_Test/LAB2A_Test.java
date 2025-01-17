package chapter2_Test;

import chapters.chapter_2.LAB2_A;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab2ATest {

    @Test
    void testFindShortestAndLongest() {
        String[] numbers = {"123", "12", "12345", "1"};
        assertDoesNotThrow(() -> LAB2_A.findShortestAndLongest(numbers));
    }

    @Test
    void testSortByLength() {
        String[] numbers = {"12345", "12", "1", "123"};
        assertDoesNotThrow(() -> LAB2_A.sortByLength(numbers));
        assertArrayEquals(new String[]{"1", "12", "123", "12345"}, numbers, "Числа должны быть отсортированы по длине");
    }

    @Test
    void testFindNumbersByAverageLength() {
        String[] numbers = {"12345", "12", "123", "1"};
        assertDoesNotThrow(() -> LAB2_A.findNumbersByAverageLength(numbers));
    }

    @Test
    void testFindMinimalUniqueDigits() {
        String[] numbers = {"123", "1222", "5678", "987"};
        assertDoesNotThrow(() -> LAB2_A.findMinimalUniqueDigits(numbers));
    }

    @Test
    void testCountEvenDigitNumbers() {
        String[] numbers = {"246", "135", "258", "111"};
        assertDoesNotThrow(() -> LAB2_A.countEvenDigitNumbers(numbers));
    }

    @Test
    void testFindIncreasingDigitNumber() {
        String[] numbers = {"123", "321", "3456", "2345"};
        assertDoesNotThrow(() -> LAB2_A.findIncreasingDigitNumber(numbers));
    }

    @Test
    void testFindUniqueDigitNumber() {
        String[] numbers = {"123", "122", "5678", "987"};
        assertDoesNotThrow(() -> LAB2_A.findUniqueDigitNumber(numbers));
    }

    @Test
    void testFindSecondPalindrome() {
        String[] numbers = {"123", "121", "787", "12321", "343"};
        assertDoesNotThrow(() -> LAB2_A.findSecondPalindrome(numbers));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(LAB2_A.isPalindrome("121"), "Число 121 должно быть палиндромом");
        assertTrue(LAB2_A.isPalindrome("12321"), "Число 12321 должно быть палиндромом");
        assertFalse(LAB2_A.isPalindrome("123"), "Число 123 не является палиндромом");
    }

    @Test
    void testIsDigitsIncreasing() {
        assertTrue(LAB2_A.isDigitsIncreasing("123"), "Число 123 должно иметь цифры в порядке возрастания");
        assertFalse(LAB2_A.isDigitsIncreasing("321"), "Число 321 не имеет цифры в порядке возрастания");
    }

    @Test
    void testCountUniqueDigits() {
        assertEquals(3, LAB2_A.countUniqueDigits("123"), "Число 123 должно иметь 3 уникальные цифры");
        assertEquals(2, LAB2_A.countUniqueDigits("122"), "Число 122 должно иметь 2 уникальные цифры");
        assertEquals(4, LAB2_A.countUniqueDigits("5678"), "Число 5678 должно иметь 4 уникальные цифры");
    }
}

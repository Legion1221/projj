package chapter1_Test;

import chapters.chapter_1.LAB1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab1Test {

    @Test
    void testUniq() {
        assertTrue(LAB1.Uniq(123), "Число 123 должно быть уникальным");
        assertFalse(LAB1.Uniq(112), "Число 112 не уникально");
        assertTrue(LAB1.Uniq(987), "Число 987 должно быть уникальным");
        assertFalse(LAB1.Uniq(101), "Число 101 не уникально");
    }

    @Test
    void testPrime() {
        assertTrue(LAB1.Prime(2), "Число 2 должно быть простым");
        assertTrue(LAB1.Prime(7), "Число 7 должно быть простым");
        assertFalse(LAB1.Prime(4), "Число 4 не является простым");
        assertFalse(LAB1.Prime(1), "Число 1 не является простым");
        assertFalse(LAB1.Prime(-7), "Отрицательное число -7 не является простым");
    }

    @Test
    void testPalindrome() {
        assertTrue(LAB1.Palindrome(121), "Число 121 должно быть палиндромом");
        assertTrue(LAB1.Palindrome(1221), "Число 1221 должно быть палиндромом");
        assertFalse(LAB1.Palindrome(123), "Число 123 не является палиндромом");
        assertFalse(LAB1.Palindrome(10), "Число 10 не является палиндромом");
    }

    @Test
    void testHappyNumber() {
        assertTrue(LAB1.HappyNumber(123321), "Число 123321 должно быть счастливым");
        assertTrue(LAB1.HappyNumber(441801), "Число 441801 должно быть счастливым");
        assertFalse(LAB1.HappyNumber(12345), "Число 12345 не является счастливым");
        assertFalse(LAB1.HappyNumber(1), "Число 1 не является счастливым");
    }

    @Test
    void testEvenAndOddNumbers() {
        int[] numbers = {1, 2, 3, 4, 5};
        StringBuilder evenNumbers = new StringBuilder();
        StringBuilder oddNumbers = new StringBuilder();

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.append(num).append(" ");
            } else {
                oddNumbers.append(num).append(" ");
            }
        }

        assertEquals("2 4 ", evenNumbers.toString(), "Чётные числа должны быть: 2, 4");
        assertEquals("1 3 5 ", oddNumbers.toString(), "Нечётные числа должны быть: 1, 3, 5");
    }

    @Test
    void testMaxAndMinNumbers() {
        int[] numbers = {5, 3, 7, 1, 9};
        int max = numbers[0];
        int min = numbers[0];

        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        assertEquals(9, max, "Наибольшее число должно быть 9");
        assertEquals(1, min, "Наименьшее число должно быть 1");
    }
}

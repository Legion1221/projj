package chapter2_Test;

import chapters.chapter_2.LAB2_B;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Lab2BTest {

    @Test
    void testPrintMultiplicationTable() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.printMultiplicationTable();

        String result = outputStream.toString();
        assertTrue(result.contains("   1"), "Таблица умножения должна начинаться с 1");
        assertTrue(result.contains("100"), "Таблица умножения должна содержать число 100");
    }

    @Test
    void testReverseArray() {
        // Здесь можно использовать Scanner для имитации ввода
        String input = "5\n1 2 3 4 5\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.reverseArray();

        String result = outputStream.toString();
        assertTrue(result.contains("5 4 3 2 1"), "Массив должен быть выведен в обратном порядке");
    }

    @Test
    void testCheckIntervalMembership() {
        String input = "5 10\n7\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.checkIntervalMembership();

        String result = outputStream.toString();
        assertTrue(result.contains("(n, m]: true"), "(n, m] должно вернуть true для k = 7");
        assertTrue(result.contains("[n, m): true"), "[n, m) должно вернуть true для k = 7");
    }

    @Test
    void testPrintDivisibleByThree() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.printDivisibleByThree();

        String result = outputStream.toString();
        assertTrue(result.contains("3 6 9"), "Должны быть выведены числа, делящиеся на 3");
    }

    @Test
    void testCountSignificantZerosInBinary() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.countSignificantZerosInBinary(129);

        String result = outputStream.toString();
        assertTrue(result.contains("Количество значащих нулей"), "Должен быть выведен результат подсчета нулей в двоичной записи");
    }

    @Test
    void testFindNumberBase() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.findNumberBase(81, "100");

        String result = outputStream.toString();
        assertTrue(result.contains("Основание системы счисления для числа 81"), "Должен быть выведен результат нахождения основания");
    }

    @Test
    void testConvertDecimalToBase() {
        String input = "129 2\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.convertDecimalToBase();

        String result = outputStream.toString();
        assertTrue(result.contains("Результат перевода: 10000001"), "Результат перевода в двоичную систему должен быть 10000001");
    }

    @Test
    void testConvertBetweenNumberSystems() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.convertBetweenNumberSystems("1010", 2, 10);

        String result = outputStream.toString();
        assertTrue(result.contains("Число 1010 из системы счисления 2 в систему счисления 10: 10"),
                "Должен быть правильный перевод числа из одной системы счисления в другую");
    }

    @Test
    void testPrintMonthByNumber() {
        String input = "3\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LAB2_B.printMonthByNumber();

        String result = outputStream.toString();
        assertTrue(result.contains("Март"), "Месяц для номера 3 должен быть март");
    }
}

package chapters.chapter_2;

import java.util.*;

/*
 * Выполнил: Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 05.12.2024
 */
public class LAB2_B {
    public static void main(String[] args) {
        printMultiplicationTable();
        reverseArray();
        checkIntervalMembership();
        printDivisibleByThree();
        countSignificantZerosInBinary(129);
        findNumberBase(81, "100");
        convertDecimalToBase();
        convertBetweenNumberSystems("1010", 2, 10);
        printMonthByNumber();
    }

    /**
     * Вывести на экран таблицу умножения.
     */
    public static void printMultiplicationTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    /**
     * Вывести элементы массива в обратном порядке.
     */
    public static void reverseArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Массив в обратном порядке:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].
     */
    public static void checkIntervalMembership() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения n и m:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Введите значение k:");
        int k = scanner.nextInt();

        System.out.println("Принадлежность:");
        System.out.println("(n, m]: " + (k > n && k <= m));
        System.out.println("[n, m): " + (k >= n && k < m));
        System.out.println("(n, m): " + (k > n && k < m));
        System.out.println("[n, m]: " + (k >= n && k <= m));
    }

    /**
     * Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.
     */
    public static void printDivisibleByThree() {
        System.out.println("Числа от 1 до 100, делящиеся на 3:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * Сколько значащих нулей в двоичной записи числа 129?
     */
    public static void countSignificantZerosInBinary(int number) {
        String binary = Integer.toBinaryString(number);
        long zeroCount = binary.chars().filter(ch -> ch == '0').count();
        System.out.println("Количество значащих нулей в двоичной записи числа " + number + ": " + zeroCount);
    }

    /**
     * В системе счисления с некоторым основанием десятичное число 81 записывается в виде 100. Найти это основание.
     */
    public static void findNumberBase(int number, String representation) {
        for (int base = 2; base <= 36; base++) {
            if (Integer.toString(number, base).equals(representation)) {
                System.out.println("Основание системы счисления для числа " + number + ", записанного как " + representation + ": " + base);
                return;
            }
        }
        System.out.println("Не удалось найти подходящее основание.");
    }

    /**
     * Написать код программы, которая бы переводила числа из десятичной системы счисления в любую другую.
     */
    public static void convertDecimalToBase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число и основание:");
        int number = scanner.nextInt();
        int base = scanner.nextInt();
        System.out.println("Результат перевода: " + Integer.toString(number, base));
    }

    /**
     * Написать код программы, которая бы переводила числа одной любой системы счисления в любую другую.
     */
    public static void convertBetweenNumberSystems(String number, int fromBase, int toBase) {
        int decimalValue = Integer.parseInt(number, fromBase);
        System.out.println("Число " + number + " из системы счисления " + fromBase + " в систему счисления " + toBase + ": " + Integer.toString(decimalValue, toBase));
    }

    /**
     * Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
     */
    public static void printMonthByNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца (1-12):");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Некорректный номер месяца.");
        } else {
            String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
            System.out.println("Месяц: " + months[month - 1]);
        }
    }
}

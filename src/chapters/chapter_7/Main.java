package chapters.chapter_7;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 11.01.2025
 */

public class Main {
    public static void main(String[] args) {
        NumberChecker isDivisibleBy13 = number -> number % 13 == 0;

        System.out.println("26 делится на 13: " + isDivisibleBy13.check(26)); // true
        System.out.println("27 делится на 13: " + isDivisibleBy13.check(27)); // false
    }
}

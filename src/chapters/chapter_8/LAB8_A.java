package chapters.chapter_8;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 12.01.2025
 */

public class LAB8_A {
    public static String insertSubstring(String text, int k, String substring) {
        // Проверка на null
        if (text == null || substring == null) {
            throw new IllegalArgumentException("Текст и подстрока не должны быть null");
        }

        if (k < 0) {
            // Если k < 0 то вставляем в начало
            return substring + text;
        } else if (k >= text.length()) {
            // Если k больше или равен длине строки, вставляется в конец
            return text + substring;
        }

        // Вставляем подстроку
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.insert(k + 1, substring);  // +1, чтобы вставить после k-го символа

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String text = "Поставьте отлично";
        String substring = "пожалуйста ";
        int k = 9; // Вставка подстроки после 5-го символа

        String result = insertSubstring(text, k, substring);
        System.out.println(result);
    }
}

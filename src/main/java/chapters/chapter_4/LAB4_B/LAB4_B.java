package chapters.chapter_4.LAB4_B;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 10.01.2025
 */

import java.io.IOException;

public class LAB4_B {
    public static void main(String[] args) {
        try {
            // Загружаем салат из файла
            Salad salad = FileLoader.loadSaladFromFile("ingredients.txt");
            System.out.println("Салат: " + salad);

            // Выводим калории
            System.out.println("Общая калорийность салата: " + salad.getTotalCalories() + " ккал");

            // Сортировка ингредиентов по весу
            salad.sortIngredientsByWeight();
            System.out.println("Сортировка по весу: " + salad);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

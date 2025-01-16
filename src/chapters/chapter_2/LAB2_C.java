package chapters.chapter_2;

import java.util.*;

/**
 * Выполнил: Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 09.12.2024
 */
public class LAB2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем размерность матрицы
        System.out.println("Введите размерность матрицы (n):");
        int n = scanner.nextInt();

        // Создаем матрицу и заполняем её случайными числами
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        // Выводим матрицу
        System.out.println("Сгенерированная матрица:");
        printMatrix(matrix);

        // Задание 1
        System.out.println("\n1. Упорядочить строки (столбцы) в порядке возрастания значений элементов.");
        System.out.println("Выберите действие: 1 - Упорядочить строки, 2 - Упорядочить столбцы");
        int choice = scanner.nextInt();
        if (choice == 1) {
            orderMatrix(matrix, n, true); // Сортируем строки
        } else if (choice == 2) {
            orderMatrix(matrix, n, false); // Сортируем столбцы
        } else {
            System.out.println("Неверный выбор!");
        }

        // Задание 2
        System.out.println("\n2. Выполнить циклический сдвиг на k позиций вправо.");
        System.out.println("Введите k для сдвига:");
        int k = scanner.nextInt();
        shiftMatrix(matrix, k, "right");

        // Задание 3
        System.out.println("\n3. Найти наибольшее количество подряд идущих возрастающих или убывающих элементов.");
        findLongestSequence(matrix);
    }

    // Метод для вывода матрицы
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для упорядочивания строк или столбцов
    public static void orderMatrix(int[][] matrix, int n, boolean sortRows) {
        if (sortRows) {
            for (int i = 0; i < n; i++) {
                Arrays.sort(matrix[i]);
            }
            System.out.println("Матрица после сортировки строк:");
        } else {
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                Arrays.sort(column);
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = column[i];
                }
            }
            System.out.println("Матрица после сортировки столбцов:");
        }
        printMatrix(matrix);
    }





    // Метод для выполнения циклического сдвига
    public static void shiftMatrix(int[][] matrix, int k, String direction) {
        int n = matrix.length;
        if (direction.equals("right")) {
            for (int i = 0; i < n; i++) {
                int[] row = matrix[i];
                // Циклический сдвиг
                int[] temp = new int[n];
                for (int j = 0; j < n; j++) {
                    temp[(j + k) % n] = row[j];
                }
                matrix[i] = temp;
            }
        }
        System.out.println("Матрица после циклического сдвига вправо на " + k + " позиций:");
        printMatrix(matrix);
    }

    // Метод для поиска наибольшего количества подряд идущих возрастающих или убывающих элементов
    public static int findLongestSequence(int[][] matrix) {
        int maxLength = 0;

        // Проверяем строки на наличие возрастающих последовательностей
        for (int i = 0; i < matrix.length; i++) {
            int currentLength = 1;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > matrix[i][j - 1]) {
                    currentLength++;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        // Проверяем столбцы на наличие возрастающих последовательностей
        for (int j = 0; j < matrix[0].length; j++) {
            int currentLength = 1;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > matrix[i - 1][j]) {
                    currentLength++;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        System.out.println("Наибольшее количество подряд идущих возрастающих элементов: " + maxLength);
        return maxLength;
    }
}

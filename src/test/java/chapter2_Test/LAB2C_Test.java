package chapter2_Test;

import chapters.chapter_2.LAB2_C;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class LAB2C_Test {

    @Test
    public void testMatrixGeneration() {
        int n = 5;
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        assertEquals(n, matrix.length);
        assertEquals(n, matrix[0].length);
    }

    @Test
    public void testOrderMatrixRows() {
        int[][] matrix = {
                {5, 3, 1},
                {9, 7, 2},
                {4, 6, 8}
        };

        LAB2_C.orderMatrix(matrix, 3, true);

        assertArrayEquals(new int[]{1, 3, 5}, matrix[0]);
        assertArrayEquals(new int[]{2, 7, 9}, matrix[1]);
        assertArrayEquals(new int[]{4, 6, 8}, matrix[2]);
    }

    @Test
    public void testOrderMatrixColumns() {
        int[][] matrix = {
                {5, 3, 1},
                {9, 7, 2},
                {4, 6, 8}
        };

        LAB2_C.orderMatrix(matrix, 3, false);

        // Проверяем, что столбцы отсортированы
        assertArrayEquals(new int[]{4, 3, 1}, matrix[0]);
        assertArrayEquals(new int[]{5, 6, 2}, matrix[1]);
        assertArrayEquals(new int[]{9, 7, 8}, matrix[2]);
    }

    @Test
    public void testShiftMatrixRight() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        LAB2_C.shiftMatrix(matrix, 1, "right");

        assertArrayEquals(new int[]{3, 1, 2}, matrix[0]);
        assertArrayEquals(new int[]{6, 4, 5}, matrix[1]);
        assertArrayEquals(new int[]{9, 7, 8}, matrix[2]);
    }

    @Test
    public void testFindLongestSequence() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 3, 2},
                {1, 2, 1}
        };

        assertEquals(3, LAB2_C.findLongestSequence(matrix));
    }
}

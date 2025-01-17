package chapter9_Test;

import chapters.chapter_9.Process;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessTest {

    private static final String TEST_FILE = "test/chapter9_Test/test_numbers.txt";

    @Test
    public void testValidNumbers() throws IOException {
        List<String> numbers = Arrays.asList("1.5", "2,5", "3.0", "4,5");
        Files.write(Paths.get(TEST_FILE), numbers);

        // Чтение и обработка файла
        List<String> lines = Process.readNumbersFromFile(TEST_FILE);
        List<Double> validNumbers = new ArrayList<>();
        for (String number : lines) {
            try {
                validNumbers.add(Double.parseDouble(number.replace(',', '.').trim()));
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число: " + number);
            }
        }

        // Проверка суммы и среднего
        double sum = validNumbers.stream().mapToDouble(Double::doubleValue).sum();
        double average = sum / validNumbers.size();

        assertEquals(11.5, sum);
        assertEquals(2.875, average, 0.0001);
    }

    @Test
    public void testEmptyFile() throws IOException {
        // Готовим пустой файл
        List<String> emptyList = Collections.emptyList();
        Files.write(Paths.get(TEST_FILE), emptyList);

        // Читаем и обрабатывыем его
        List<String> lines = Process.readNumbersFromFile(TEST_FILE);
        List<Double> validNumbers = new ArrayList<>();
        for (String number : lines) {
            try {
                validNumbers.add(Double.parseDouble(number.replace(',', '.').trim()));
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число: " + number);
            }
        }

        // Проверка что в файле нет чисел
        assertTrue(validNumbers.isEmpty(), "Список чисел не должен быть пустым.");
    }

    @Test
    public void testInvalidNumberFormat() throws IOException {
        // Готовим файл с некорректным числом
        List<String> numbers = Arrays.asList("1.5", "abc", "3.0", "4,5");
        Files.write(Paths.get(TEST_FILE), numbers);

        List<String> lines = Process.readNumbersFromFile(TEST_FILE);
        List<Double> validNumbers = new ArrayList<>();
        for (String number : lines) {
            try {
                validNumbers.add(Double.parseDouble(number.replace(',', '.').trim()));
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число: " + number);
            }
        }

        // Проверяем что некоректное число не добавилось
        assertEquals(3, validNumbers.size());  // Всего должно быть 3 числа
        assertTrue(validNumbers.contains(1.5));
        assertTrue(validNumbers.contains(3.0));
        assertTrue(validNumbers.contains(4.5));
    }

    @Test
    public void testFileNotFound() {
        // Проверяем если файл не существует
        assertThrows(FileNotFoundException.class, () -> {
            Process.readNumbersFromFile("src/chapters/chapter_9/nAn_file.txt");
        });
    }

    @Test
    public void testOutOfMemoryError() {
        // Ожидаем OutOfMemoryError
        assertThrows(OutOfMemoryError.class, () -> {
            // Попробуем создать массив размера половину от максимального значения int примерно млрд элементов
            int[] largeArray = new int[Integer.MAX_VALUE / 2];
        });
    }

}

package chapters.chapter_10.LAB10_B;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadCountry {
    public static void main(String[] args) {
        String filePath = "country.ser"; // Убедитесь, что путь к файлу правильный

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            // Чтение объекта из файла
            Country country = (Country) ois.readObject();

            // Вывод информации о стране
            System.out.println("Страна: " + country.getName());
            System.out.println("Столица: " + country.getCapital().getName());
            System.out.println("Общая площадь: " + country.getTotalArea());
            System.out.println("Количество регионов: " + country.getRegionCount());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

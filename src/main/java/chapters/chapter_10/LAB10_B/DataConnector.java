package chapters.chapter_10.LAB10_B;

import java.io.*;
import java.util.List;

// Класс для сериализации и десериализации
public class DataConnector {

    // Метод для сериализации объекта в файл
    public static void serialize(Object object, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
            System.out.println("Объект успешно сериализован в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта из файла
    public static Object deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Метод для сериализации списка объектов
    public static void serializeList(List<?> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("Список объектов успешно сериализован в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации списка объектов
    public static List<?> deserializeList(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

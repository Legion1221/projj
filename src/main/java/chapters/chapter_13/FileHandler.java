package chapters.chapter_13;

import java.io.*;
import java.util.*;

public class FileHandler {

    // Чтение списка людей из файла
    public static List<Person> readPeopleFromFile() {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/chapters/chapter_13/people.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {  // Убедитесь, что три параметра: ID, ФИО, дата рождения
                    people.add(new Person(Integer.parseInt(parts[0]), parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    // Чтение списка писем из файла
    public static List<Letter> readLettersFromFile() {
        List<Letter> letters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/chapters/chapter_13/letters.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {  // Убедитесь, что пять параметров: ID отправителя, получателя, тема, текст, дата
                    letters.add(new Letter(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return letters;
    }
}

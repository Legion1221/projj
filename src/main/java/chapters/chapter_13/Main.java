package chapters.chapter_13;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 17.01.2025
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Чтение списка людей из файла
        List<Person> people = FileHandler.readPeopleFromFile();

        // Чтение списка писем из файла
        List<Letter> letters = FileHandler.readLettersFromFile();

        System.out.println("===== Информация о пользователях и их письмах :");
        QueryExecutor.printUserLetterCounts(people, letters);
        System.out.println();

        String subject = "Привет";
        System.out.println("===== Пользователи, которые не получили письма с темой: \"" + subject + "\" :");
        QueryExecutor.printUsersWithoutSubject(people, letters, subject);
        System.out.println();

        System.out.println("===== Пользователь с наименьшей длиной письма :");
        Person personWithShortestLetter = QueryExecutor.findPersonWithShortestLetter(people, letters);
        if (personWithShortestLetter != null) {
            System.out.println("Имя: " + personWithShortestLetter.name);
            System.out.println("Дата рождения: " + personWithShortestLetter.dateOfBirth);
            System.out.println("Длина самого короткого письма: " + personWithShortestLetter.getShortestLetterLength(letters) + " символов");
        } else {
            System.out.println("Не удалось найти пользователя с наименьшей длиной письма.");
        }
    }
}

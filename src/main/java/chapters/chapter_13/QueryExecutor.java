package chapters.chapter_13;

import java.util.*;
import java.util.stream.Collectors;

public class QueryExecutor {

    // Получить количество отправленных писем для пользователя
    public static long getSentCount(Person person, List<Letter> letters) {
        return letters.stream()
                .filter(letter -> letter.senderId == person.id)
                .count();
    }

    // Получить количество полученных писем для пользователя
    public static long getReceivedCount(Person person, List<Letter> letters) {
        return letters.stream()
                .filter(letter -> letter.receiverId == person.id)
                .count();
    }

    // Получить список пользователей, которые не получили письма с заданной темой
    public static List<Person> getUsersWithoutSubject(List<Person> people, List<Letter> letters, String subject) {
        Set<Integer> usersWithSubject = letters.stream()
                .filter(letter -> letter.subject.equals(subject))
                .map(letter -> letter.receiverId)
                .collect(Collectors.toSet());

        return people.stream()
                .filter(person -> !usersWithSubject.contains(person.id))
                .collect(Collectors.toList());
    }

    // Найти пользователя с наименьшей длиной письма
    public static Person findPersonWithShortestLetter(List<Person> people, List<Letter> letters) {
        Map<Integer, Integer> letterLengths = letters.stream()
                .collect(Collectors.groupingBy(
                        letter -> letter.senderId,
                        Collectors.summingInt(letter -> letter.body.length())
                ));

        return letterLengths.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(entry -> people.stream()
                        .filter(p -> p.id == entry.getKey())
                        .findFirst()
                        .orElse(null))
                .orElse(null);
    }

    // Вывести информацию о пользователях и количестве отправленных и полученных писем
    public static void printUserLetterCounts(List<Person> people, List<Letter> letters) {
        // Подсчитываем количество отправленных и полученных писем для каждого пользователя
        Map<Integer, Long> sentCount = letters.stream()
                .collect(Collectors.groupingBy(letter -> letter.senderId, Collectors.counting()));

        Map<Integer, Long> receivedCount = letters.stream()
                .collect(Collectors.groupingBy(letter -> letter.receiverId, Collectors.counting()));

        // Выводим информацию о пользователях
        people.forEach(person -> {
            long sent = sentCount.getOrDefault(person.id, 0L);
            long received = receivedCount.getOrDefault(person.id, 0L);
            System.out.println(person.name + " - Отправлено: " + sent + ", Получено: " + received);
        });
    }

    // Вывести пользователей, которые не получали письма с заданной темой
    public static void printUsersWithoutSubject(List<Person> people, List<Letter> letters, String subject) {
        // Собираем ID получателей, которые получили письма с данной темой
        Set<Integer> usersWithSubject = letters.stream()
                .filter(letter -> letter.subject.equals(subject))
                .map(letter -> letter.receiverId)
                .collect(Collectors.toSet());

        // Выводим пользователей, чьи ID не находятся в списке получателей с заданной темой
        people.stream()
                .filter(person -> !usersWithSubject.contains(person.id))
                .forEach(person -> System.out.println(person.name));
    }
}

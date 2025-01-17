package chapter13_Test;

import chapters.chapter_13.Letter;
import chapters.chapter_13.Person;
import chapters.chapter_13.QueryExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class LAB13_Test {

    private List<Person> people;
    private List<Letter> letters;

    @BeforeEach
    public void setUp() {

        people = new ArrayList<>();
        people.add(new Person(1, "Дамдинов Арья Аюрович", "07-08-2004"));
        people.add(new Person(2, "Шубин Дмитрий Дмитриевич", "12-04-2004"));
        people.add(new Person(3, "Юматова Алёна Сергеевна", "21-11-2002"));

        letters = new ArrayList<>();
        letters.add(new Letter(1, 2, "Привет", "Как дела?", "2025-17-01"));
        letters.add(new Letter(2, 3, "Важное сообщение", "срочно прочитай", "2025-17-02"));
        letters.add(new Letter(1, 3, "Привет", "Как дела?", "2025-17-03"));
        letters.add(new Letter(3, 1, "Ответ", "Все в порядке", "2025-17-04"));
        letters.add(new Letter(2, 1, "Ответ", "Привет, как ты?", "2025-17-05"));
    }

    @Test
    public void testPrintUserLetterCounts() {
        // Проверим, что у пользователя с id 1 отправлено 2 письма и получено 1 письмо
        assertEquals(2, QueryExecutor.getSentCount(people.get(0), letters));
        assertEquals(2, QueryExecutor.getReceivedCount(people.get(0), letters));

        assertEquals(2, QueryExecutor.getSentCount(people.get(1), letters));
        assertEquals(1, QueryExecutor.getReceivedCount(people.get(1), letters));

        assertEquals(1, QueryExecutor.getSentCount(people.get(2), letters));
        assertEquals(2, QueryExecutor.getReceivedCount(people.get(2), letters));
    }

    // Тест для проверки пользователей, которые не получили письма с определённой темой
    @Test
    public void testPrintUsersWithoutSubject() {
        List<Person> usersWithoutSubject = QueryExecutor.getUsersWithoutSubject(people, letters, "Привет");
        assertEquals(1, usersWithoutSubject.size());
        assertEquals("Дамдинов Арья Аюрович", usersWithoutSubject.get(0).name);
    }

    // Тест для нахождения пользователя с наименьшей длиной письма
    @Test
    public void testFindPersonWithShortestLetter() {
        Person personWithShortestLetter = QueryExecutor.findPersonWithShortestLetter(people, letters);
        assertNotNull(personWithShortestLetter);
        assertEquals("Юматова Алёна Сергеевна", personWithShortestLetter.name);
        assertEquals(13, personWithShortestLetter.getShortestLetterLength(letters));
    }
}

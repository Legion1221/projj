package chapters.chapter_13;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    int id;
    public String name;
    public String dateOfBirth;

    public Person(int id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // Метод для нахождения длины самого короткого письма
    public int getShortestLetterLength(List<Letter> letters) {
        // Фильтруем письма этого пользователя
        List<Letter> sentLetters = letters.stream()
                .filter(letter -> letter.senderId == this.id) // Отбираем только отправленные письма
                .collect(Collectors.toList());

        // Если у пользователя нет отправленных писем, возвращаем 0
        if (sentLetters.isEmpty()) {
            return 0;
        }

        // Находим письмо с наименьшей длиной
        int minLength = Integer.MAX_VALUE;
        for (Letter letter : sentLetters) {
            minLength = Math.min(minLength, letter.body.length());
        }

        return minLength;
    }
}

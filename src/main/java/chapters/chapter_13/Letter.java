package chapters.chapter_13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Letter {
    int senderId;
    int receiverId;
    String subject;
    String body;
    String sendDate;

    public Letter(int senderId, int receiverId, String subject, String body, String sendDate) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.subject = subject;
        this.body = body;
        this.sendDate = sendDate;
    }

    // Метод для получения даты отправки письма в формате "день месяц год"
    public String getFormattedSendDate() {
        try {
            // Парсим строку в объект Date
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(this.sendDate);

            // Форматируем в нужный формат
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return this.sendDate; // В случае ошибки возвращаем исходную строку
        }
    }

    @Override
    public String toString() {
        return senderId + ", " + receiverId + ", " + subject + ", " + body + ", " + getFormattedSendDate();
    }
}

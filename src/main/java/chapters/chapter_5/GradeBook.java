package chapters.chapter_5;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 11.01.2025
 */

import java.util.ArrayList;
import java.util.List;

public class GradeBook {

    private String firstName;
    private String lastName;
    private String group;
    private int yearOfStudy;

    private List<Session> sessions;

    public GradeBook(String firstName, String lastName, String group, int yearOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.yearOfStudy = yearOfStudy;
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void printGradeBook() {
        System.out.println("Студент: " + firstName + " " + lastName);
        System.out.println("Группа: " + group);
        System.out.println("Год обучения: " + yearOfStudy);
        System.out.println("Сессии:");

        for (Session session : sessions) {
            session.printSessionInfo();
        }
    }

    public class Session {
        private String sessionName;
        private List<Subject> subjects;

        public Session(String sessionName) {
            this.sessionName = sessionName;
            this.subjects = new ArrayList<>();
        }

        public void addSubject(String subjectName, boolean passed, String grade) {
            subjects.add(new Subject(subjectName, passed, grade));
        }

        public void printSessionInfo() {
            System.out.println("  Сессия: " + sessionName);
            for (Subject subject : subjects) {
                subject.printSubjectInfo();
            }
        }

        public class Subject {
            private String subjectName;
            private boolean passed;
            private String grade;

            public Subject(String subjectName, boolean passed, String grade) {
                this.subjectName = subjectName;
                this.passed = passed;
                this.grade = grade;
            }

            public void printSubjectInfo() {
                System.out.println("    Предмет: " + subjectName);
                // Печатаем зачет сдан/не сдан только если оценка - зачет
                if ("Зачет".equals(grade)) {
                    System.out.println("    Зачет: " + (passed ? "Сдан" : "Не сдан"));
                }
                // Печатаем оценку если она не зачет
                if (!"Зачет".equals(grade)) {
                    System.out.println("    Оценка: " + grade);
                }
            }
        }
    }

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook("Арья", "Дамдинов", "Б762-2", 3);

        GradeBook.Session session1 = gradeBook.new Session("Сессия 5 2025");

        session1.addSubject("Сетевые протоколы", true, "Зачет");
        session1.addSubject("Java-программирование", true, "Отлично");
        session1.addSubject("ПЧМИ", false, "Хорошо");
        session1.addSubject("Курсовая работа", true, "Хорошо");

        gradeBook.addSession(session1);
        gradeBook.printGradeBook();
    }
}
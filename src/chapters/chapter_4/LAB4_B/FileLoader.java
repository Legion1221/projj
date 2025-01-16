package chapters.chapter_4.LAB4_B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    public static Salad loadSaladFromFile(String filename) throws IOException {
        Salad salad = new Salad();

        // Создаем путь к файлу в папке LAB4_B
        String filePath = "src/chapters/chapter_4/LAB4_B/" + filename;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                double weight = Double.parseDouble(parts[1]);

                // Добавляем овощи в салат
                switch (name) {
                    case "Carrot" -> salad.addIngredient(new Carrot(weight));
                    case "Cucumber" -> salad.addIngredient(new Cucumber(weight));
                    case "Tomato" -> salad.addIngredient(new Tomato(weight));
                    default -> throw new IllegalArgumentException("Неизвестный овощ: " + name);
                }
            }
        }

        return salad;
    }
}

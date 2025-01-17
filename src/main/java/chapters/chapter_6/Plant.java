package chapters.chapter_6;

public interface Plant {
    void setName(String name);
    String getName();

    void setOrigin(String origin);
    String getOrigin();

    void water(); // Полив
    void setTemperature(double temperature); // Установка температуры
    void setLighting(String lighting); // Установка освещения

    void displayInfo(); // Отображение информации о растении
}

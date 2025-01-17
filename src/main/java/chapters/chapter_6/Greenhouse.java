package chapters.chapter_6;

import java.util.ArrayList;
import java.util.List;

public class Greenhouse {
    private List<Plant> plants;

    public Greenhouse() {
        this.plants = new ArrayList<>();
    }

    // Добавить растение в оранжерею
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    // Удалить растение из оранжереи
    public void removePlant(Plant plant) {
        plants.remove(plant);
        System.out.println(plant.getName() + " было удалено из оранжереи.");
    }

    // Полить все растения
    public void waterAllPlants() {
        for (Plant plant : plants) {
            plant.water();
        }
    }

    // Установить температуру для всех растений
    public void setTemperatureForAllPlants(double temperature) {
        for (Plant plant : plants) {
            plant.setTemperature(temperature);
        }
    }

    // Установить освещение для всех растений
    public void setLightingForAllPlants(String lighting) {
        for (Plant plant : plants) {
            plant.setLighting(lighting);
        }
    }

    // Показать информацию о всех растениях
    public void displayAllPlantsInfo() {
        for (Plant plant : plants) {
            plant.displayInfo();
        }
    }

    public List<Plant> getPlants() {
        return plants;
    }
}

package chapters.chapter_6;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 11.01.2025
 */

public class Main {
    public static void main(String[] args) {
        // Создаем оранжерею
        Greenhouse greenhouse = new Greenhouse();

        // Добавляем растения
        Plant boosh = new Boosh("Куст розы", "Европа");
        Plant flower = new Flower("Тюльпан", "Голандия");
        Plant housePlant = new HousePlant("Венерина Мухоловка", "Америка");

        greenhouse.addPlant(boosh);
        greenhouse.addPlant(flower);
        greenhouse.addPlant(housePlant);

        // Выставляем температуру и освещение
        greenhouse.setTemperatureForAllPlants(25.0);
        greenhouse.setLightingForAllPlants("Яркое");

        // Поливаем растения
        greenhouse.waterAllPlants();

        // Информация о растениях
        greenhouse.displayAllPlantsInfo();

        // Убираем растение из оранжереи
        greenhouse.removePlant(housePlant);
    }
}

package chapter6_Test;

import chapters.chapter_6.Greenhouse;
import chapters.chapter_6.Plant;
import chapters.chapter_6.Boosh;
import chapters.chapter_6.Flower;
import chapters.chapter_6.HousePlant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GreenhouseTest {

    private Greenhouse greenhouse;
    private Plant shrub;
    private Plant floweringPlant;
    private Plant housePlant;

    @BeforeEach
    public void setUp() {
        greenhouse = new Greenhouse();
        shrub = new Boosh("Кустовая роза", "Европа");
        floweringPlant = new Flower("Тюльпан", "Голандия");
        housePlant = new HousePlant("Венерина Мухоловка", "Америка");

        greenhouse.addPlant(shrub);
        greenhouse.addPlant(floweringPlant);
        greenhouse.addPlant(housePlant);
    }

    @Test
    public void testAddPlant() {
        assertEquals(3, greenhouse.getPlants().size(), "Растения должны быть добавлены в оранжерею.");
    }

    @Test
    public void testRemovePlant() {
        greenhouse.removePlant(housePlant);
        assertEquals(2, greenhouse.getPlants().size(), "Растение должно быть удалено из оранжереи.");
    }

    @Test
    public void testWaterAllPlants() {
        // Проверяем что бы все растения поливались
        greenhouse.waterAllPlants();
    }

    @Test
    public void testSetTemperatureForAllPlants() {
        greenhouse.setTemperatureForAllPlants(30.0);
        assertDoesNotThrow(() -> greenhouse.setTemperatureForAllPlants(30.0), "Установка температуры не должна вызвать исключение.");
    }

    @Test
    public void testSetLightingForAllPlants() {
        greenhouse.setLightingForAllPlants("Dim");
        // Проверяем освещение
        assertDoesNotThrow(() -> greenhouse.setLightingForAllPlants("Dim"), "Установка освещения не должна вызвать исключение.");
    }

    @Test
    public void testDisplayAllPlantsInfo() {
        // Проверяем что displayAllPlantsInfo() не вызывает ошибок
        assertDoesNotThrow(() -> greenhouse.displayAllPlantsInfo(), "Отображение информации о растениях не должно вызвать исключение.");
    }
}

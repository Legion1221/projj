package chapter10_Test;

import chapters.chapter_10.LAB10_B.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LAB10_BTest {

    private City city1, city2, city3, city4;
    private District district1, district2;
    private Region region1;
    private Country country;

    @BeforeEach
    void setUp() {
        // Создаём города
        city1 = new City("Город А", 321);
        city2 = new City("Город Б", 1020);
        city3 = new City("Город С", 982);
        city4 = new City("Город В", 741);

        // Создаём районы
        district1 = new District("Район 1", city2, Arrays.asList(city2, city3));
        district2 = new District("Район 2", city1, Arrays.asList(city1, city4));

        // Создаём регионы
        region1 = new Region("Регион 1", 2002, city1, Arrays.asList(district1, district2));

        // Создаём государство
        country = new Country("Страна N", city1, Arrays.asList(region1));
    }

    @Test
    void testCityCreation() {
        assertEquals("Город А", city1.getName());
        assertEquals(321, city1.getArea());
    }

    @Test
    void testDistrictCreation() {
        assertEquals("Район 1", district1.getName());
        assertEquals(city2, district1.getCapital());
        assertEquals(2, district1.getCities().size());
    }

    @Test
    void testRegionCreation() {
        assertEquals("Регион 1", region1.getName());
        assertEquals(2002, region1.getArea());
        assertEquals(city1, region1.getCapital());
        assertEquals(2, region1.getDistricts().size());
    }

    @Test
    void testCountryCreation() {
        assertEquals("Страна N", country.getName());
        assertEquals(city1, country.getCapital());
        assertEquals(1, country.getRegions().size());
    }

    @Test
    void testTotalArea() {
        assertEquals(2002, country.getTotalArea());
    }

    @Test
    void testRegionCount() {
        assertEquals(1, country.getRegionCount());
    }

    @Test
    void testRegionalCapitals() {
        List<City> capitals = country.getRegionalCapitals();
        assertEquals(1, capitals.size());
        assertEquals(city1, capitals.get(0));
    }

    @Test
    void testSerializationAndDeserialization() {
        String filePath = "src/main/java/chapters/chapter_10/LAB10_B/country_test.ser";

        // сериализация
        DataConnector.serialize(country, filePath);

        // Десериализация
        Country deserializedCountry = (Country) DataConnector.deserialize(filePath);

        assertNotNull(deserializedCountry);
        assertEquals(country, deserializedCountry);
        assertEquals(country.getName(), deserializedCountry.getName());
        assertEquals(country.getTotalArea(), deserializedCountry.getTotalArea());
    }
}

package chapters.chapter_10.LAB10_B;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double area;

    public City(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.area, area) == 0 && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area);
    }

    @Override
    public String toString() {
        return String.format("Город: %s, Площадь: %.2f км²", name, area);
    }
}

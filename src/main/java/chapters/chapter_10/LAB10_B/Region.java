package chapters.chapter_10.LAB10_B;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double area;
    private City capital;
    private List<District> districts;

    public Region(String name, double area, City capital, List<District> districts) {
        this.name = name;
        this.area = area;
        this.capital = capital;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public City getCapital() {
        return capital;
    }

    public List<District> getDistricts() {
        return districts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.area, area) == 0 &&
                Objects.equals(name, region.name) &&
                Objects.equals(capital, region.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, capital);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Область: %s, Площадь: %.2f км²\n", name, area));
        sb.append(String.format("  Столица области: %s\n", capital.getName()));
        sb.append("  Районы области:\n");
        for (District district : districts) {
            sb.append(district).append("\n");
        }
        return sb.toString();
    }
}

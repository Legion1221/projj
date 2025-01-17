package chapters.chapter_10.LAB10_B;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private City capital;
    private List<Region> regions;

    public Country(String name, City capital, List<Region> regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
    }

    public String getName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public int getRegionCount() {
        return regions.size();
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Region region : regions) {
            totalArea += region.getArea();
        }
        return totalArea;
    }

    public List<City> getRegionalCapitals() {
        List<City> capitals = new ArrayList<>();
        for (Region region : regions) {
            capitals.add(region.getCapital());
        }
        return capitals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(capital, country.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Государство: %s\n", name));
        sb.append(String.format("  Столица: %s\n", capital.getName()));
        sb.append(String.format("  Общая площадь: %.2f км²\n", getTotalArea()));
        sb.append(String.format("  Количество областей: %d\n", getRegionCount()));
        sb.append("  Области:\n");
        for (Region region : regions) {
            sb.append(region).append("\n");
        }
        return sb.toString();
    }
}

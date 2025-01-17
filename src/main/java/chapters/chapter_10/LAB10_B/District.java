package chapters.chapter_10.LAB10_B;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class District implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private City capital;
    private List<City> cities;

    public District(String name, City capital, List<City> cities) {
        this.name = name;
        this.capital = capital;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(name, district.name) && Objects.equals(capital, district.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Район: %s\n", name));
        sb.append(String.format("  Столица района: %s\n", capital.getName()));
        sb.append("  Города района:\n");
        for (City city : cities) {
            sb.append(String.format("    - %s\n", city));
        }
        return sb.toString();
    }
}

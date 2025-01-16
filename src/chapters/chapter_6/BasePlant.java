package chapters.chapter_6;

public class BasePlant implements Plant {
    private String name;
    private String origin;
    private double temperature;
    private String lighting;

    public BasePlant(String name, String origin) {
        this.name = name;
        this.origin = origin;
        this.temperature = 22.0; // по умолчанию
        this.lighting = "Комнатное"; // по умолчанию
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public void water() {
        System.out.println(name + " был(о) полито(а).");
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("Температура для " + name + " установлена на " + temperature + "°C.");
    }

    @Override
    public void setLighting(String lighting) {
        this.lighting = lighting;
        System.out.println("Освещение для " + name + " установлено на " + lighting + ".");
    }

    @Override
    public void displayInfo() {
        System.out.println("Название растения: " + name);
        System.out.println("Происхождение: " + origin);
        System.out.println("Температура: " + temperature + "°C");
        System.out.println("Освещение: " + lighting);
    }
}

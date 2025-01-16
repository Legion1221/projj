package chapters.chapter_6;

public class Boosh extends BasePlant {
    public Boosh(String name, String origin) {
        super(name, origin);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Это кустовое растение.");
    }
}

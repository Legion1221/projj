package chapters.chapter_6;

public class HousePlant extends BasePlant {
    public HousePlant(String name, String origin) {
        super(name, origin);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Это комнатное растение.");
    }
}

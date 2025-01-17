package chapters.chapter_6;

public class Flower extends BasePlant {
    public Flower(String name, String origin) {
        super(name, origin);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Это цветок.");
    }
}

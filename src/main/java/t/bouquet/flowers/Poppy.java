package t.bouquet.flowers;

public class Poppy extends Flower {
    public Poppy(double price, String color, int fresh, double height) {
        super(price, color, fresh, height);
    }

    public String getName() {
        return "Poppy";
    }

    public boolean isSpiky() {
        return false;
    }
}

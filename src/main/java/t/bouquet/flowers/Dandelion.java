package t.bouquet.flowers;

public class Dandelion extends Flower {
    public Dandelion(double price, String color, int fresh, double height) {
        super(price, color, fresh, height);
    }

    public String getName() {
        return "Dandelion";
    }

    public boolean isSpiky() {
        return false;
    }
}

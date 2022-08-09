package t.bouquet.flowers;

public class Rose extends Flower {
    public Rose(double price, String color, int fresh, double height) {
        super(price, color, fresh, height);
    }

    public String getName() {
        return "Rose";
    }

    public boolean isSpiky() {
        return true;
    }
}

package grocery;

public class GroceryItem {
    private String name;
    private double price;
    private int quantity;

    public GroceryItem(String name, double price, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public void decrementQuantity(int amount) {
        if (quantity - amount < 0) {
            throw new IllegalArgumentException("Not enough items in stock");
        }
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (Quantity: " + quantity + ")";
    }
}

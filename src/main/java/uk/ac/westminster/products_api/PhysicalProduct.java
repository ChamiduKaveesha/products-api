package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {

    private double weight;
    private String dimensions;

    private double discountedPrice;

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public PhysicalProduct() { }

    public PhysicalProduct(Long id, String name, double price, double weight, String dimensions) {
        super(id, name, price);
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Weight: " + weight;
    }
}

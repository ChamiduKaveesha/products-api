package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {

    private double weight;
    private String dimensions;

    public PhysicalProduct() {

    }
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
}

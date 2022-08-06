package com.mike.les3_bean_property_and_constructor;

public class Tyre {
    private String brand;
    private double radius;

    public Tyre(double radius) {
        this.radius = radius;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                ", radius=" + radius +
                '}';
    }
}

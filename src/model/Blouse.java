package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Blouse extends Product implements Discounts{
    private final String POLYESTER = "Polyester";
    private final String SILK = "Silk";
    private final String COTTON = "Cotton";
    private final int PRICE_PER_MATERIAL = 5000;
    private final Double DISCOUNT = 0.2;
    private final String BLACK = "Black";
    private final String WHITE = "White";
    private String color;
    private char size;
    private String[] materials;

    public Blouse(String id, String color, char size, String[] materials) {
        super(id);
        this.color = color;
        this.size = size;
        this.materials = materials;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String[] getMaterials() {
        return materials;
    }

    public void setMaterials(String[] materials) {
        this.materials = materials;
    }

    public void calculatePrice() {
        setPrice(getPrice() + (PRICE_PER_MATERIAL * materials.length));
    }
    public void calculateDiscount() {
        double discount = 0;
        discount = getPrice() * DISCOUNT;
        setPrice(getPrice() - (int) discount);
    }

    @Override
    public String toString() {
        return "Blouse{" +
                "ID=" + getId() +
                ", Price=" + getPrice() +
                ", PRICE_PER_MATERIAL=" + PRICE_PER_MATERIAL +
                ", DISCOUNT=" + DISCOUNT +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", materials=" + Arrays.toString(materials) +
                '}';
    }

}

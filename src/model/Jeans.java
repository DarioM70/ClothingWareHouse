package model;

public class Jeans extends Product implements Discounts{
    private final int PRICE_PER_CM = 1000;
    private final boolean MALE = true;
    private final boolean FEMALE = false;
    private final Double DISCOUNT = 0.2;
    private boolean gender;
    private int length;

    public Jeans(String id, boolean gender, int length) {
        super(id);
        this.gender = gender;
        this.length = length;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void calculatePrice() {
        setPrice(getPrice() + PRICE_PER_CM * length);
    }
    public void calculateDiscount() {
        double discount = 0;
        if(gender == FEMALE){
            discount = getPrice() * DISCOUNT;
            setPrice(getPrice() - (int) discount);
        }
    }

    @Override
    public String toString() {
        return "Jeans{" +
                "ID=" + getId() +
                ", Price=" + getPrice() +
                ", PRICE_PER_CM=" + PRICE_PER_CM +
                ", DISCOUNT=" + DISCOUNT +
                ", gender=" + gender +
                ", length=" + length +
                '}';
    }
}

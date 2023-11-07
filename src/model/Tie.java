package model;

public class Tie extends Product implements Discounts{
    private final String SILK = "Silk";
    private final String WOOL = "Wool";
    private final int SILK_PRICE = 45000;
    private final int WOOL_PRICE = 30000;
    private String material;
    private int width;

    public Tie(String id, String material, int width, int price) {
        super(id);
        this.material = material;
        this.width = width;
        setPrice(price);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void calculatePrice() {
        if(material.equalsIgnoreCase(SILK))
            setPrice(45000);
        else if (material.equalsIgnoreCase(WOOL))
            setPrice(30000);
    }
    public void calculateDiscount() {
        setPrice(getPrice());
    }

    @Override
    public String toString() {
        return "Tie{" +
                ", ID=" + getId() +
                ", Price=" + getPrice() +
                ", material='" + material + '\'' +
                ", width=" + width +
                '}';
    }
}

package model;

public class Meal {
    private String code;
    private String name;
    private boolean halfPrice;
    private Integer price;

    public Meal() {
    }

    public Meal(String code, String name, boolean halfPrice,Integer price) {
        this.code = code;
        this.name = name;
        this.halfPrice = halfPrice;
        this.price=price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHalfPrice() {
        return halfPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setHalfPrice(boolean halfPrice) {
        this.halfPrice = halfPrice;
    }


}

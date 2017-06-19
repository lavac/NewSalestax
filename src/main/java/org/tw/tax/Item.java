package org.tw.tax;


public class Item {

    private static final double BASE_RATE = 0.1;
    String itemName;
    double price;
    double tax;
    int quantity;

    public Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price * quantity;
        tax = price*BASE_RATE;
    }

    public Item() {

    }

    public double getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return  itemName.toString() +  " - " + (price + tax);
    }

    public double getPrice() {
        return price;
    }

}

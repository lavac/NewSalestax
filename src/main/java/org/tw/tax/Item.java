package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */
public class Item {

    private static final double BASE_RATE = 0.1;
    String itemName;
    double price;
    double tax;


    //multiplying pricw i=with the quantity
    public Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price * quantity;
        tax = price*BASE_RATE * quantity;
    }

    public Item() {

    }

    public double getTax() {
        return tax;
    }
}

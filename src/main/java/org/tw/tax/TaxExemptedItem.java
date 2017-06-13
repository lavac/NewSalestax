package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */

// do i  need to create an seperate object
public class TaxExemptedItem extends Item {
    public TaxExemptedItem(Item item) {
        itemName = item.itemName;
        price = item.price;
        tax = 0.0;
        System.out.println("tax "+ " price "  + tax + price);
    }
}

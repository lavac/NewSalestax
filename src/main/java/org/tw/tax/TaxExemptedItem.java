package org.tw.tax;

public class TaxExemptedItem extends Item {
    public TaxExemptedItem(Item item) {
        itemName = item.itemName;
        price = item.price;
        tax = 0.0;
    }
}

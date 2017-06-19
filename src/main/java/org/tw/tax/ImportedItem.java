package org.tw.tax;

public class ImportedItem extends Item{
    static final double IMPORT_TAX = 0.05;
    public ImportedItem(Item item) {
        itemName = item.itemName;
        price = item.price;
        tax = item.getTax() + price*IMPORT_TAX;
    }
}

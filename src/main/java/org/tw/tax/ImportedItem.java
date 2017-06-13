package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */
public class ImportedItem extends Item{
    static final double IMPORT_TAX = 0.05;
    public ImportedItem(Item item) {
        itemName = item.itemName;
        price = item.price;
        tax = item.getTax() + price*IMPORT_TAX;
        System.out.println("tax "+ " price "  + tax + price);
    }


}

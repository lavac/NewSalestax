package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */


public class ImportedItemPrivider implements ItemProvider {
    @Override
    public Item createItem(String input, Item item) {

        return item;
    }
}

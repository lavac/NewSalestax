package org.tw.tax;

public class ImportedItemPrivider implements ItemProvider {
    private static final String IMPORTED_FACTOR = " imported ";

    @Override
    public Item createItem(String input, Item item) {
        if(input.contains(IMPORTED_FACTOR))
            return new ImportedItem(item);
        return item;
    }
}

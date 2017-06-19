package org.tw.tax;

public class TaxableItemProvider implements ItemProvider {

    ItemParser parser = new ItemParser();
    @Override
    public Item createItem(String input, Item item) {
        item = parser.inputParser(input);
        return item;
    }
}

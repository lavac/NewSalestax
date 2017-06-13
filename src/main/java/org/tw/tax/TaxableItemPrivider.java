package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */
public class TaxableItemPrivider implements ItemProvider {

    Parser parser = new Parser();
    @Override
    public Item createItem(String input, Item item) {
        item = parser.inputParser(input);
        return item;
    }
}

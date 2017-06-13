package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */
public class Parser {
    final static String AT = "at";

    public Item inputParser(String itemInfo) {

        String [] lastPart = itemInfo.split(AT);
        String [] remainingParts = lastPart[0].split(" ");
        double price = Double.parseDouble(lastPart[1]);
        int quantity = Integer.parseInt(remainingParts[0]);
        String itemName = lastPart[0];
        return new Item(itemName, price, quantity);

    }
}

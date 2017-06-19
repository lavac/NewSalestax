package org.tw.tax;

import java.util.ArrayList;
import java.util.List;


public class InputParser {
    List<ItemProvider> itemProviders = new ArrayList<>();

    InputParser()
    {
        itemProviders.add(new TaxableItemProvider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
    }


    ArrayList<Item> inputParser(List<String> itemInfo ) {
        Item item = null;
        double expectedTax = 75.0;
        ArrayList<Item> cartList = new ArrayList<>();
        for (String input : itemInfo) {
            for (ItemProvider provider : itemProviders) {
                item = provider.createItem(input, item);
            }
            cartList.add(item);
        }
        return cartList;
    }
}

package org.tw.tax;

import java.util.ArrayList;
import java.util.List;

public class TaxExemptedItemProvider implements ItemProvider {

   List<String> taxExmeptedItem = new ArrayList<>(5);

    TaxExemptedItemProvider() {
        createTaxExemptedItemList();
    }

    private void createTaxExemptedItemList() {
        taxExmeptedItem.add("chocolate");
        taxExmeptedItem.add("pills");
        taxExmeptedItem.add("book");
    }

   @Override
    public Item createItem(String input, Item item) {
        for(String taxExemptedItem:taxExmeptedItem) {
            if(input.contains(taxExemptedItem))
                return new TaxExemptedItem(item);
        }
        return item;
    }
}

package org.tw.tax;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lavanya on 6/13/17.
 */
public class TaxEmotedItemProvider implements ItemProvider {

   List<String> taxExmeptedItem = new ArrayList<String>(5);

    TaxEmotedItemProvider() {
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

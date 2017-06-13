package org.tw.tax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by lavanya on 6/13/17.
 */
public class TestSalesTax {
    @Test
    public void taxShouldBeCalculatedForAnTaxableItem()  {
        List<ItemProvider> itemProviders =  new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExmptedItemPrivider());
        itemProviders.add(new ImportedItemPrivider());
        String input = "1 music CD at 10.0";
        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expetedTax = 1.0;
        assertEquals(expetedTax, item.getTax());

    }

}

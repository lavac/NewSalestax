package org.tw.tax;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class TestSalesTax {
    @Test
    public void taxShouldBeCalcualtedForAnTaxableItem()  {
        List<ItemProvider> itemProviders =  new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemPrivider());
        String input = "1 music CD at 10.0";
        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expetedTax = 1.0;
        assertEquals(expetedTax, item.getTax());

    }
    @Test
    public void taxShouldBeZeroForAnTaxExemptedItem() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemPrivider());
        String input = "1 chocolate at 10.0";
        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expetedTax = 0.0;
        assertEquals(expetedTax, item.getTax());
    }

    @Test
    public void taxShouldReturnforImportedItem() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemPrivider());
        String input = "1 imported phone at 50000.00";
        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expetedTax = 7500.0;
        assertEquals(expetedTax, item.getTax());
    }

    @Test
    public void taxShouldReturnforImportedAndTaxExeptedItem() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemPrivider());
        String input = "1 imported chocolate bar at 500.00";
        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expetedTax = 25.0;
        assertEquals(expetedTax, item.getTax());
    }

    @Test
    public void taxShouldBeDoubleForTwoItems() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemPrivider());
        String input = "2 imported chocolate bar at 500.00";
        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expetedTax = 50.0;
        assertEquals(expetedTax, item.getTax());

    }




}

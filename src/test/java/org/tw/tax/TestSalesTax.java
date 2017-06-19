package org.tw.tax;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;


public class TestSalesTax {

    @Test
    public void taxShouldBeCalculatedForAnTaxableItem()  {
        List<ItemProvider> itemProviders =  new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        String input = "1 music CD at 10.0";

        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }

        double expectedTax = 1.0;
        assertEquals(expectedTax, item.getTax());
    }

    @Test
    public void taxShouldBeZeroForAnTaxExemptedItem() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        String input = "1 chocolate at 10.0";

         Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }

        double expectedTax = 0.0;
        assertEquals(expectedTax, item.getTax());
    }

    @Test
    public void taxShouldReturnforImportedItem() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        String input = "1 imported phone at 50000.00";

        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }

        double expectedTax = 7500.0;
        assertEquals(expectedTax, item.getTax());
    }

    @Test
    public void taxShouldReturnforImportedAndTaxExeptedItem() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        String input = "1 imported chocolate bar at 500.00";

        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }

        double expectedTax = 25.0;
        assertEquals(expectedTax, item.getTax());
    }

    @Test
    public void taxShouldBeDoubleForTwoItems() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        String input = "2 imported chocolate bar at 500.00";

        Item item = null;
        for(ItemProvider provider: itemProviders) {
            item = provider.createItem(input, item);
        }
        double expectedTax = 50.0;
        double expectedPrice = 1000.0;

        assertEquals(expectedTax, item.getTax());
        assertEquals(expectedPrice, item.getPrice());

    }

    @Test
    public void totalTaxShouldBeSumOfTheTaxesForManyItems() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        List<String> itemInfo = new ArrayList<>();
        itemInfo.add("1 imported chocolate bar at 500.00");
        itemInfo.add("2 phones at 500.00");
        itemInfo.add("1 book at 500.00");
        Item item = null;
        double expectedTax = 75.0;

        ArrayList<Item> cartList = new ArrayList<>();
        for(String input : itemInfo) {
            for (ItemProvider provider : itemProviders) {
                item = provider.createItem(input, item);
            }
            cartList.add(item);
        }
        Receipt receipt = new ReceiptGenerator().generateReceipt(cartList);

        assertEquals(expectedTax, receipt.getTotalTax());
    }

    @Test
    public void totalValueShouldBeSumOfTheTaxesForManyItems() {
        List<ItemProvider> itemProviders = new ArrayList<>();
        itemProviders.add(new TaxableItemPrivider());
        itemProviders.add(new TaxExemptedItemProvider());
        itemProviders.add(new ImportedItemProvider());
        List<String> itemInfo = new ArrayList<>();
        itemInfo.add("1 imported chocolate bar at 500.00");
        itemInfo.add("2 phones at 500.00");
        itemInfo.add("1 book at 500.00");
        Item item = null;

        double expectedTax = 75.0;
        double expectedTotal = 2075.0;
        ArrayList<Item> cartList = new ArrayList<>();
        for(String input : itemInfo) {
            for (ItemProvider provider : itemProviders) {
                item = provider.createItem(input, item);
            }
            cartList.add(item);
        }
        Receipt receipt = new ReceiptGenerator().generateReceipt(cartList);

        assertEquals(expectedTax, receipt.getTotalTax());
        assertEquals(expectedTotal, receipt.getTotalValue());
    }
}

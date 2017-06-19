package org.tw.tax;

import java.util.ArrayList;
public class Receipt {

    ArrayList<String> itemDetails;
    double totalTax;
    double totalValue;
    public Receipt(ArrayList<String> itemDetails, double totalTax, double totalValue) {
        this.itemDetails = itemDetails;
        this.totalTax = totalTax;
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        String itemInfo = "";
        for(String item : itemDetails) {
            itemInfo += item;
            itemInfo += "\n";
        }
        return itemInfo + "SalesTax - " + totalTax + " \ntotal - " +
                totalValue;
    }

    public double getTotalTax() {
        return totalTax;
    }
    public double getTotalValue() {
        return totalValue;
    }

}

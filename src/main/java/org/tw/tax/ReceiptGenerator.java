package org.tw.tax;

import java.util.ArrayList;
import java.util.List;

    public class ReceiptGenerator {

        public Receipt generateReceipt(List<Item> cartList) {
            double totalTax = 0;
            double totalPrice = 0;
            double totalValue = 0;
            ArrayList<String> itemDetails = new ArrayList<>();
            for(Item item: cartList) {
                itemDetails.add(item.toString());
                totalTax += item.getTax();
                totalPrice += item.getPrice();
            }
            totalValue = totalPrice + totalTax;
            Receipt receipt =  new Receipt(itemDetails, totalTax, totalValue);
            return receipt;
        }
    }



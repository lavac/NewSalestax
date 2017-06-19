package org.tw.tax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SalesTax {
    public static void main(String args[]) throws IOException {
        InputParser parser = new InputParser();
        List<String> itemDetails = new ArrayList<>();
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int noOfInputs = Integer.parseInt(inp.readLine());
        for (int i = 0; i < noOfInputs; i++) {
            String itemInfo = inp.readLine();
            itemDetails.add(itemInfo);
        }
        List<Item> items = parser.inputParser(itemDetails);
        Receipt receipt = new ReceiptGenerator().generateReceipt(items);
        System.out.println(receipt);

    }
}

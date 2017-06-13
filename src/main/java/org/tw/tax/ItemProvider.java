package org.tw.tax;

/**
 * Created by lavanya on 6/13/17.
 */
public interface ItemProvider {
    Item createItem(String input, Item item);
}

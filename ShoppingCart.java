package shopping.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<ShoppingCartItem> items;
	int numberOfItems;
	double total;
 
    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        total = 0;
    }
 
    public synchronized void addItem(Item item) {
 
        boolean newItem = true;
 
        for (ShoppingCartItem scItem : items) {
 
            if (scItem.getItem().getId() == item.getId()) {
 
                newItem = false;
                scItem.incrementQuantity();
            }
        }
 
        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(item);
            items.add(scItem);
        }
    }
 
    public synchronized void update(Item item, String quantity) {
 
        short qty = -1;
 
        // cast quantity as short
        qty = Short.parseShort(quantity);
 
        if (qty >= 0) {
 
            ShoppingCartItem itm = null;
 
            for (ShoppingCartItem scItem : items) {
 
                if (scItem.getItem().getId() == item.getId()) {
 
                    if (qty != 0) {
                        // set item quantity to new value
                        scItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save item and break
                        itm = scItem;
                        break;
                    }
                }
            }
 
            if (itm != null) {
                // remove from cart
                items.remove(itm);
            }
        }
    }
 
    public synchronized List<ShoppingCartItem> getItems() {
        return items;
    }
 
    public synchronized int getNumberOfItems() {
 
        numberOfItems = 0;
 
        for (ShoppingCartItem scItem : items) {
 
            numberOfItems += scItem.getQuantity();
        }
 
        return numberOfItems;
    }
 
    public synchronized double getSubtotal() {
 
        double amount = 0;
 
        for (ShoppingCartItem scItem : items) {
 
            Item item = (Item) scItem.getItem();
            amount += (scItem.getQuantity() * item.getPrice());
        }
 
        return amount;
    }
    public synchronized void calculateTotal(String surcharge) {
 
        double amount = 0;
 
        // cast surcharge as double
        double s = Double.parseDouble(surcharge);
 
        amount = this.getSubtotal();
        amount += s;
 
        total = amount;
    }
 
   public synchronized double getTotal() {

       return total;
       }

    public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
 
}

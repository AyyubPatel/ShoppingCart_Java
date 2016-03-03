package shopping.cart;

public class ShoppingCartItem {
 
    Item item;
    short quantity;
 
    public ShoppingCartItem(Item item) {
        this.item = item;
        quantity = 1;
    }
 
    public Item getItem() {
        return item;
    }
 
    public short getQuantity() {
        return quantity;
    }
 
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
 
    public void incrementQuantity() {
        quantity++;
    }
 
    public void decrementQuantity() {
        quantity--;
    }
 
    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * item.getPrice());
        return amount;
    }
}

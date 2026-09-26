package assignment.session_7;

public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.itemPrices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price > 0 && itemCount < itemPrices.length) {
            itemPrices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total Amount: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}
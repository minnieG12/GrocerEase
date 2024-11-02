package threads;

import grocery.Cart;

public class CheckoutThread extends Thread {
    private Cart cart;

    public CheckoutThread(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing checkout...");
            Thread.sleep(2000); // Simulate time taken for checkout
            cart.clear();
            System.out.println("Checkout complete!");
        } catch (InterruptedException e) {
            System.err.println("Checkout was interrupted.");
        }
    }
}

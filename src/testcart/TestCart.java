package testcart;

import testcart.catalogue.DefaultCatalogue;

/**
 *
 * @author JPALMA
 */
public class TestCart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DefaultCatalogue prodCatalogue = new DefaultCatalogue();
        
        ShoppingCart cart = new ShoppingCart(prodCatalogue);
        // Scenario 1
        System.out.println("Scenario 1 ======================================");
        cart.add("ult_small");
        cart.add("ult_small");
        cart.add("ult_small");
        cart.add("ult_large");
        cart.items();
        cart.total();
        // Scenario 2
        cart = new ShoppingCart(prodCatalogue);
        System.out.println("Scenario 2 ======================================");
        cart.add("ult_small");
        cart.add("ult_small");
        cart.add("ult_large");
        cart.add("ult_large");
        cart.add("ult_large");
        cart.add("ult_large");
        cart.items();
        cart.total();
        // Scenario 3
        cart = new ShoppingCart(prodCatalogue);
        System.out.println("Scenario 3 ======================================");
        cart.add("ult_small");
        cart.add("ult_medium");
        cart.add("ult_medium");
        cart.items();
        cart.total();
        // Scenario 4
        cart = new ShoppingCart(prodCatalogue);
        System.out.println("Scenario 4 ======================================");
        cart.add("ult_small");
        cart.add("1gb", "I<3AMAYSIM");
        cart.items();
        cart.total();
        
    }
    
    
    
}

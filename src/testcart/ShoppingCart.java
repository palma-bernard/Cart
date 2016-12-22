package testcart;

import testcart.sim.SimProduct;
import testcart.catalogue.Catalogue;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JPALMA
 */
public class ShoppingCart {

    protected Map<String, Integer> orderList = null;
    protected Catalogue catalogue = null;
    protected double totalPrice = 0;
    protected boolean isPromoCodeActivated = false;

    // should be configurable (no time to implement)
    public final boolean hasActivePromo = true;
    public final String PROMO_CODE = "I<3AMAYSIM";

    public ShoppingCart(Catalogue newCatalogue) {
        orderList = new HashMap<String, Integer>();
        catalogue = newCatalogue;
    }

    /**
     * Add item to cart
     * @param order
     */
    public boolean add(String order) {

        boolean isValid = false;
        try {

            // validate product
            for (SimProduct product : catalogue.getProductList()) {
                // check if exisiting in current catalogue
                if (product.getProductCode().equals(order)) {
                    // check if already in the order list
                    if (orderList.containsKey(order)) {
                        orderList.put(order, Integer.parseInt(orderList.get(order).toString()) + 1);
                    } else { // add the product in order list if new
                        orderList.put(order, 1);
                    }
                    //update price
                    totalPrice += product.getPrice();

                    System.out.println("Item added to cart: " + product.getProductName());

                    isValid = true;
                    break;
                }

            }
            // if not valid
            if (isValid == false) {
                System.out.println("Invalid product: " + order);
            }

        } catch (Exception ex) {
            printError(ex);
        }

        return isValid;

    }

    /**
     * Add item to cart with promo code
     * @param order
     * @param code
     */
    public void add(String order, String code) {

        boolean isOrderValid = false;

        try {
            // add the order to list
            isOrderValid = add(order);

            // check if order is successful
            if (isOrderValid) {
                // check the promo code
                if (PROMO_CODE.equals(code)) {
                    isPromoCodeActivated = true;
                    System.out.println("Promo activated : " + code);
                }
                else {
                    System.out.println("Invalid promo code : " + code);
                }
            }

        } catch (Exception ex) {
            printError(ex);
        }
    }

    /**
     * View items added to cart
     */
    public void items() {

        try {
            System.out.println("Added Items ===================================");
            // print the list
            printItems(orderList);
            System.out.println("===============================================");
        } catch (Exception ex) {
            printError(ex);
        }

    }

    /**
     * Compute the total price and items (display expected output)
     */
    public void total() {
        DecimalFormat roundTotal = new DecimalFormat("#.##");
        HashMap<String, Integer> totalList = null;

        try {

            if (hasActivePromo) {
                Promo promo = new Promo(catalogue, orderList, isPromoCodeActivated);
                totalPrice = promo.implementPromoComputation();
                totalList = new HashMap<>(promo.getUpdatedOrderList());

                System.out.println("Total Items ===================================");
                printItems(totalList);
                System.out.println("===============================================");
            } else {
                printItems(orderList);
            }

            System.out.println("Total Price: $" + roundTotal.format(totalPrice));

        } catch (Exception ex) {
            printError(ex);
        }
    }

    private void printItems(Map<String, Integer> itemList) throws Exception {
        if (itemList.size() > 0) {
            // print the list
            for (SimProduct product : catalogue.getProductList()) {
                for (Map.Entry pair : itemList.entrySet()) {
                    if (product.getProductCode().equals(pair.getKey())) {
                        System.out.println(pair.getValue() + " x " + product.getProductName());
                        break;
                    }
                }
            }
            // if promo code is activated, print it
            if (isPromoCodeActivated) {
                System.out.println(PROMO_CODE);
            }
        } else {
            System.out.println("No ordered items yet!");
        }
    }

    private void printError(Exception ex) {

        if (catalogue == null) {
            System.out.println("No catalogue loaded.");
        } else {
            System.out.println("Error occured : " + ex);
        }
    }

}

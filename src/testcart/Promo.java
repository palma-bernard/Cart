package testcart;

import java.util.HashMap;
import testcart.sim.SimProduct;
import testcart.catalogue.Catalogue;
import java.util.Map;

/**
 *
 * @author JPALMA
 */
public class Promo {
    
    private Map<String, Integer> orderList = null;
    private Catalogue catalogue = null;
    private boolean isPromoCodeActivated = false;
    
    private final String SIM_ULT_SMALL = "ult_small";
    private final String SIM_ULT_MEDIUM = "ult_medium";
    private final String SIM_ULT_LARGE = "ult_large";
    private final String SIM_ONE_GB = "1gb";
    
    // should be configurable (no time to implement)
    private final double PROMO_CODE_DISCOUNT = 0.1;
    private final double SIM_ULT_LARGE_REPRICE = 39.9;
    
    public Promo(Catalogue catalogue, Map<String, Integer> orderList, boolean isPromoCodeActivated) {
        this.catalogue = catalogue;
        this.orderList = new HashMap<>(orderList);
        this.isPromoCodeActivated = isPromoCodeActivated;
    }
    
    /**
     * Implements the promo
     */
    public double implementPromoComputation() throws Exception {
        
        double newTotal = 0;
        boolean isUltMediumPromoApplied = false;
        
        for (Map.Entry pair : orderList.entrySet()) {
            int quantity = Integer.parseInt(pair.getValue().toString());
            
            for(SimProduct product : catalogue.getProductList()) {
                // buy 3 deal 2 (for every 3 sims purchased)
                if(pair.getKey().equals(product.getProductCode()) && 
                        pair.getKey().equals(SIM_ULT_SMALL)) {
                    
                    if (quantity >= 3) {
                        // get the price of not included in promo
                        int excess = quantity % 3;
                        newTotal += excess * product.getPrice();
                        // compute the buy 3 deal 2 promo
                        newTotal += ((quantity - excess) / 3) * (2 * product.getPrice());
                    }
                    else {
                        newTotal += quantity * product.getPrice();
                    }
                    break;
                }
                // buy one get 1gb SIM free
                if (pair.getKey().equals(product.getProductCode()) && 
                        pair.getKey().equals(SIM_ULT_MEDIUM)) {
                    newTotal += quantity * product.getPrice();
                    isUltMediumPromoApplied = true;
                    break;
                }
                // buy more than 3, price down to 39.9 for each
                if (pair.getKey().equals(product.getProductCode()) && 
                        pair.getKey().equals(SIM_ULT_LARGE)) {
                    if (quantity > 3) {
                        newTotal += quantity * SIM_ULT_LARGE_REPRICE;
                    }
                    else {
                        newTotal += quantity * product.getPrice();
                    }
                    break;
                }
                // no promo applied
                if (pair.getKey().equals(product.getProductCode()) && 
                        pair.getKey().equals(SIM_ONE_GB)) {
                    newTotal += quantity * product.getPrice();
                    break;
                }
            }
        }
        
        // compute discount if promo code is applied        
        if (isPromoCodeActivated) {
            newTotal -= (newTotal * PROMO_CODE_DISCOUNT);
        }
        
        if (isUltMediumPromoApplied) {
            if (orderList.containsKey(SIM_ONE_GB)) {
                    orderList.put(SIM_ONE_GB, 
                            Integer.parseInt(orderList.get(SIM_ONE_GB).toString()) + 
                                    Integer.parseInt(orderList.get(SIM_ULT_MEDIUM).toString()));
            }
            else {
                orderList.put(SIM_ONE_GB, Integer.parseInt(orderList.get(SIM_ULT_MEDIUM).toString()));
            }
        }
        return newTotal;
    }

    public Map<String, Integer> getUpdatedOrderList() {
        return orderList;
    }
}

package testcart.sim;

/**
 *
 * @author JPALMA
 */
public class UltMediumSim implements SimProduct {
    
    private final String productCode = "ult_medium";
    private final String productName = "Unlimited 2GB";
    private double price = 0;
    
    
    @Override
    public String getProductCode() {
        return this.productCode;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
    
    @Override
    public String getProduct() {
        return "Code=" + this.productCode + "; Name=" + this.productName + "; Price=" + this.price;
    }
    
}

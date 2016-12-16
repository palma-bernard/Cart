package testcart.catalogue;

import testcart.sim.OneGbSim;
import testcart.sim.SimProduct;
import testcart.sim.UltLargeSim;
import testcart.sim.UltMediumSim;
import testcart.sim.UltSmallSim;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPALMA
 */
public class DefaultCatalogue implements Catalogue {
    
    private List<SimProduct> productList;
    
    public DefaultCatalogue() {
        
        productList = new ArrayList<SimProduct>();
        loadProducts();
        
    }
    
    private void loadProducts() {
        
        SimProduct product = null;
        
        System.out.println("Loading catalogue..");
        System.out.println("====================================================");
        product = new UltSmallSim();
        product.setPrice(24.9);
        productList.add(product);
        System.out.println("Added product to Catalogue : " + product.getProduct());
        
        product = new UltMediumSim();
        product.setPrice(29.9);
        productList.add(product);
        System.out.println("Added product to Catalogue : " + product.getProduct());
        
        product = new UltLargeSim();
        product.setPrice(44.9);
        productList.add(product);
        System.out.println("Added product to Catalogue : " + product.getProduct());
        
        product = new OneGbSim();
        product.setPrice(9.9);
        productList.add(product);
        System.out.println("Added product to Catalogue : " + product.getProduct());
        
        System.out.println("====================================================");
    }
    
    @Override
    public List<SimProduct> getProductList() {
        return this.productList;
    }
   
    
}

package testcart;

import testcart.catalogue.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TGSI
 */
public class ShoppingCartTest {
    
    private Catalogue cat = null;
    private ShoppingCart instance = null;
    
    public ShoppingCartTest() {
        
    }
    
    /**
     * Test of add(item) method, catalogue is null.
     */
    @Test
    public void testAdd_String_NullCatalogue() {
        System.out.println("+++ add(item) : catalogue = null +++");
        String order = "ult_small";
        instance = new ShoppingCart(cat);
        boolean expResult = false;
        boolean result = instance.add(order);
        assertEquals(expResult, result);
        
        System.out.println();
        System.out.println();
    }

    /**
     * Test of add(item) method, invalid item.
     */
    @Test
    public void testAdd_String_InvalidItem() {
        System.out.println("+++ add(item) : invalid item +++");
        String order = "test";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        boolean expResult = false;
        boolean result = instance.add(order);
        assertEquals(expResult, result);
        
        System.out.println();
        System.out.println();
        //fail("Expected is false since item is invalid.");
    }

    /**
     * Test of add(item) method, valid item.
     */
    @Test
    public void testAdd_String_ValidItem() {
        System.out.println("+++ add(item) : valid item +++");
        String order = "ult_small";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        boolean expResult = true;
        boolean result = instance.add(order);
        assertEquals(expResult, result);
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of add(item, code) method, catalogue is null.
     */
    @Test
    public void testAdd_StringString_NullCatalogue() {
        System.out.println("+++ add(item,code) : catalogue = null +++");
        String order = "ult_small";
        String code = "I<3AMAYSIM";
        instance = new ShoppingCart(cat);
        instance.add(order, code);
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of add(item, code) method, invalid item and code.
     */
    @Test
    public void testAdd_StringString_InvItemInvCode() {
        System.out.println("+++ add(item,code) : invalid item, invalid code +++");
        String order = "test";
        String code = "test";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        instance.add(order, code);
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of add(item, code) method, invalid item, valid code.
     */
    @Test
    public void testAdd_StringString_InvItemValCode() {
        System.out.println("+++ add(item,code) : invalid item, valid code +++");
        String order = "test";
        String code = "I<3AMAYSIM";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        instance.add(order, code);
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of add(item, code) method, valid item, invalid code.
     */
    @Test
    public void testAdd_StringString_ValItemInvCode() {
        System.out.println("+++ add(item,code) : valid item, invalid code +++");
        String order = "ult_medium";
        String code = "test";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        instance.add(order, code);
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of add(item, code) method, valid item, valid code.
     */
    @Test
    public void testAdd_StringString_ValItemValCode() {
        System.out.println("+++ add(item,code) : valid item, valid code +++");
        String order = "ult_medium";
        String code = "I<3AMAYSIM";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        instance.add(order, code);
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of items() method, catalogue = null
     */
    @Test
    public void testItems_NullCatalogue() {
        System.out.println("+++ items() : catalogue = null +++");
        instance = new ShoppingCart(cat);
        instance.items();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of items() method, no items added
     */
    @Test
    public void testItems_NoItem() {
        System.out.println("+++ items() : no item +++");
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
                
        instance.items();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of items() method, item added
     */
    @Test
    public void testItems_ItemAdded() {
        System.out.println("+++ items() : item added +++");
        String order = "ult_large";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        // add items
        instance.add(order);
        
        instance.items();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of items() method, item added with code
     */
    @Test
    public void testItems_ItemCodeAdded() {
        System.out.println("+++ items() : item added +++");
        String order = "ult_large";
        String code = "I<3AMAYSIM";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        // add items
        instance.add(order, code);
        
        instance.items();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of total() method, catalogue = null
     */
    @Test
    public void testTotal_NullCatalogue() {
        System.out.println("+++ total() : catalogue = null +++");
        instance = new ShoppingCart(cat);
        instance.total();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of total() method, no items added
     */
    @Test
    public void testTotal_NoItem() {
        System.out.println("+++ items() : no item +++");
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
                
        instance.total();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of total() method, item added
     */
    @Test
    public void testTotal_ItemAdded() {
        System.out.println("+++ total() : item added +++");
        String order = "1gb";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        // add items
        instance.add(order);
        
        instance.total();
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Test of items() method, item added with code
     */
    @Test
    public void testTotal_ItemCodeAdded() {
        System.out.println("+++ items() : item added +++");
        String order = "1gb";
        String code = "I<3AMAYSIM";
        cat = new DefaultCatalogue();
        instance = new ShoppingCart(cat);
        // add items
        instance.add(order, code);
        
        instance.total();
        
        System.out.println();
        System.out.println();
    }
    
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis365week2.platt_baristamatic;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author justinplatt
 */
public class DrinkTest {

    Drink d = null;

    public DrinkTest() {
    }

    @Before
    public void setUp() {
        String[] ingArray = new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"};
        d = new Drink("Caffe Mocha", ingArray);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCompareToTrue() {
        System.out.println("compareTo");
        Drink d2 = new Drink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
       // assertTrue(d.equals(d2)); //NEEDS FIXING
    }

     @Test
    public void testCompareToFalse() {
        System.out.println("compareTo");
        Drink d3 = new Drink("Caffe Americano", new String[]{"Cocoa", "Steamed Milk", "Espresso"});
        assertFalse(d.equals(d3));
    }

    @Test//RETHINK
    public void testSetRecipe() {
        System.out.println("setRecipe");
        String[] recipe = {"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"};
        
        d.setRecipe(recipe);
        assertNotNull( d.getRecipe());//RETHINK

    }

    @Test
    public void testSetName() throws InvalidParameterException {
        System.out.println("setName");
        String name = "test";
        d.setName(name);
        assertTrue(name == d.getName());
    }

    public void testEmptySetName() {
        System.out.println("emptySetName");
        String name = "";
        try {
            d.setName(name);
            fail("Empty value accepted for name");
        } catch (Exception e) {

        }
    }

    public void testNullSetName() {
        System.out.println("nulSetName");
        String name = null;
        try {
            d.setName(name);
            fail("Null value accepted for name");
        } catch (Exception e) {
            assertNull(name);
        }

    }

    @Test
    public void testSetCost() throws InvalidParameterException {
        System.out.println("setCost");
        double cost = 0.0;
        d.setCost(cost);
        assertTrue(cost == d.getCost());
    }
    
    @Test
    public void testNegativeSetCost() {
        double cost = -1.0;
        try {
            d.setCost(cost);
            fail("Negative value accepted for cost");
        } catch (Exception e) {
        }
    }

    @Test
    public void testSetCanMake() {
        System.out.println("setCanMake");
        boolean canMake = false;
        d.setCanMake(canMake);
        assertFalse(d.getCanMake());
    }

    @Test
    public void testGetRecipe() {
        System.out.println("getRecipe");
        String[] recipe = {"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"};
        d.setRecipe(recipe);
        assertNotNull(d.getRecipe());

    }

    @Test
    public void testGetCost() throws InvalidParameterException {
        System.out.println("getCost");
        double cost = 1.00;
        d.setCost(cost);
        assertTrue(cost == d.getCost());

    }

    @Test
    public void testGetName() throws InvalidParameterException {
        System.out.println("getName");
        String name = "Coffee";
        d.setName(name);
        assertEquals(name, d.getName());
    }

    @Test
    public void testGetCanMake() {
        System.out.println("getCanMake");
        boolean result = true;
        d.setCanMake(result);
        assertTrue(d.getCanMake()==true);
    }

}

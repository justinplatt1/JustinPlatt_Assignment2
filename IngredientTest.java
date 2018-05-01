/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis365week2.platt_baristamatic;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author justinplatt
 */
public class IngredientTest {

    Ingredient i = null;
    DrinkMachine dm = mock(DrinkMachine.class);

    public IngredientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws InvalidParameterException {

        i = new Ingredient("Coffee", 0.70);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCompareTo() throws InvalidParameterException {
         System.out.println("compareTo");
        
        assertEquals("Coffee", i.getName());
       
       
    }

    @Test
    public void testSetName() throws InvalidParameterException {
        System.out.println("setName");
        String name = "abc";
        i.setName(name);
        assertTrue(name == i.getName());

    }

    @Test
    public void testEmptySetName() {
        String name = "";
        try {
            i.setName(name);
            fail("Empty value accepted for name");
        } catch (Exception e) {

        }
    }

    @Test
    public void testNullSetName() {

        String name = null;
        try {
            i.setName(name);
            fail("Null value accepted for name");
        } catch (Exception e) {
            assertNull(name);
        }

    }

    @Test
    public void testSetCost() throws InvalidParameterException {
        System.out.println("setCost");
        double cost = 0.0;
        i.setCost(cost);
        assertTrue(cost == i.getCost());
    }

    @Test
    public void testNegativeSetCost() {
        double cost = -1.0;
        try {
            i.setCost(cost);
            fail("Negative value accepted for cost");
        } catch (Exception e) {
        }
    }

    @Test
    public void testSetStock() throws InvalidParameterException {
        System.out.println("setStock");
        int stock = 0;
        i.setStock(stock);
        assertTrue(stock == i.getStock());

        stock = -1;
        try {
            i.setStock(stock);
            fail("Negative value accepted for stock");
        } catch (Exception ex) {
        }
        stock = 11;
        try {
            i.setStock(stock);
            fail("This machine accepted a value greater than 10");
        } catch (Exception ex) {
        }
    }

    @Test
    public void testGetName() throws InvalidParameterException {
        System.out.println("getName");
        String name = "Coffee";
        i.setName(name);
        assertEquals(name, i.getName());
    }

    @Test
    public void testGetCost() throws InvalidParameterException {
        System.out.println("getCost");
        double cost = 1.00;
        i.setCost(cost);
        assertTrue(cost == i.getCost());

    }

    @Test
    public void testGetStock() throws InvalidParameterException {
        System.out.println("getStock");
        int stock = 10;
        i.setStock(stock);
        assertTrue(stock == i.getStock());
    }

}

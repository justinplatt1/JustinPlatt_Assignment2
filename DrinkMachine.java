package cis365week2.platt_baristamatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DrinkMachine{

    private static List<Drink> drinkList = new ArrayList<Drink>();
    private static List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    public static void main(String[] args) throws InvalidParameterException {
        addAllIngredients();
        addAllDrinks();
        updateCosts();
        updateCanMake();
        display();
        startIO();
    }

    public static void startIO(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        //running loop
        while(true){            
            try {
               
                input = reader.readLine().toLowerCase();

                if(input.equals("")){
                    continue;
                }else if (input.equals("q")){ 
                    System.exit(0); 
                }else if(input.equals("r")){ 
                    restockIngredients();
                    updateCanMake();
                }else if(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= drinkList.size()){ //dynamic drink menu selection
                    makeDrink(drinkList.get(Integer.parseInt(input)-1));
                }else{
                    throw new IOException();//legal, but invalid input
                }
            } catch (Exception e) {
                System.out.println("Invalid selection: " + input + "\n");//illegal input
            }
        }//running loop     
    }

    public static void display(){
        //The sample IO in the assignment appears to add a blank line after output, so I included that.
        System.out.println("Inventory:\n");
        for (Ingredient i : ingredientList){
            System.out.println(i.getName() + "," + i.getStock() + "\n");
        }

        System.out.println("Menu:\n");
        int count = 1;
        for (Drink d : drinkList){
            System.out.printf("%d,%s,$%.2f," + d.getCanMake() + "\n\n", count, d.getName(), d.getCost());
            count++;
        }
    }

    public static void updateCanMake(){
        for (Drink d : drinkList){
            Map<String, Integer> currRecipe = d.getRecipe();
            for (Ingredient i : ingredientList){
                if (currRecipe.containsKey(i.getName()) && i.getStock() < currRecipe.get(i.getName())){
                    d.setCanMake(false);
                    break;
                }
                d.setCanMake(true);
            }
        }
    }

    public static void updateCosts() throws InvalidParameterException{
        for (Drink d : drinkList){
            double currCost = 0;
            Map<String, Integer> currRecipe = d.getRecipe();
            for (Ingredient i : ingredientList){
                if (currRecipe.containsKey(i.getName())){
                    currCost += i.getCost()*currRecipe.get(i.getName());
                }
            }//inner
            d.setCost(currCost);
        }//outer
    }

    public static void makeDrink(Drink drink) throws InvalidParameterException{
        if(drink.getCanMake()){
            System.out.println("Dispensing: " + drink.getName() + "\n");
            for (Ingredient i : ingredientList){
                if(drink.getRecipe().containsKey(i.getName())){
                    i.setStock(i.getStock()-drink.getRecipe().get(i.getName()));
                }
            }
        }else{
            System.out.println("Out of stock: " + drink.getName() + "\n");
        }
        updateCanMake();
        display();
    }

    public static void restockIngredients() throws InvalidParameterException{
        for(Ingredient i : ingredientList){
            i.setStock(10);
        }
        updateCanMake();
        display();
    }

    //Add ingredients through addAllIngredients
    public static void addIngredient(Ingredient ingredient){
        ingredientList.add(ingredient);
    }
    //Add drinks through addAllDrinks
    public static void addDrink(String name, String[] recipe){
        drinkList.add(new Drink(name, recipe));
    }

    public static void addAllIngredients() throws InvalidParameterException{
        addIngredient(new Ingredient("Coffee", 0.75));
        addIngredient(new Ingredient("Decaf Coffee", 0.75));
        addIngredient(new Ingredient("Sugar", 0.25));
        addIngredient(new Ingredient("Cream", 0.25));
        addIngredient(new Ingredient("Steamed Milk", 0.35));
        addIngredient(new Ingredient("Foamed Milk", 0.35));
        addIngredient(new Ingredient("Espresso", 1.10));
        addIngredient(new Ingredient("Cocoa", 0.90));
        addIngredient(new Ingredient("Whipped Cream", 1.00));   

        Collections.sort(ingredientList);
    }

    public static void addAllDrinks(){  
        addDrink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"});
        addDrink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"});
        addDrink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"});
        addDrink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        addDrink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
        addDrink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});

        Collections.sort(drinkList);
    }

}

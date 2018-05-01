package cis365week2.platt_baristamatic;

import java.util.HashMap;
import java.util.Map;

public class Drink implements Comparable<Drink>{
    private Map<String, Integer> recipe = new HashMap<String, Integer>();
    private String name;
    private double totalCost = 0;
    private boolean canMake = false;

    public Drink(String name, String[] recipe){
        this.name = name;
        setRecipe(recipe);
    }

    public int compareTo(Drink drink){
        return name.compareTo(drink.getName());
    }

    public void setRecipe(String[] recipe){
        for(String s : recipe){
            if(this.recipe.containsKey(s)){
                this.recipe.put(s, this.recipe.get(s)+1);
            }else{
                this.recipe.put(s, 1);
            }
        }
    }

   public void setName(String name) throws InvalidParameterException{
            if (name == "" || name == null)
            
                throw new InvalidParameterException("Name cannot be empty or null"); 
            
            else
            this.name = name;
        }

        public void setCost(double totalCost) throws InvalidParameterException{
            if (totalCost <0)
                throw new InvalidParameterException("totalCost must be a positive integer value");
            this.totalCost = totalCost;
        }

    public void setCanMake(boolean canMake){
        this.canMake = canMake;
    }

    public Map<String, Integer> getRecipe(){
        return recipe;
    }

    public double getCost(){
        return totalCost;
    }

    public String getName(){
        return name;
    }

    public boolean getCanMake(){
        return canMake;
    }

}
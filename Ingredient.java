package cis365week2.platt_baristamatic;

  public class Ingredient implements Comparable<Ingredient> {
        private String name = "";
        private double cost = 0.00;
        private int stock = 0;

        public Ingredient(String name, double cost) throws InvalidParameterException{
            setName(name);
            setCost(cost);
            setStock(10);        }

        public int compareTo(Ingredient ingredient) {
            return name.compareTo(ingredient.getName());
        }

        public void setName(String name) throws InvalidParameterException{
            if (name == "" || name == null)
            
                throw new InvalidParameterException("Name cannot be empty or null"); 
            
            else
            this.name = name;
        }

        public void setCost(double cost) throws InvalidParameterException{
            if (cost <0)
                throw new InvalidParameterException("Cost must be a positive integer value");
            this.cost = cost;
        }

        public void setStock(int stock) throws InvalidParameterException{
            if (stock < 0)
                throw new InvalidParameterException("Stock cannot be a negative value");
            if (stock >10)
                throw new InvalidParameterException("This machine cannot store above 10 of each ingredient");
            else     
            this.stock = stock;
        }

        public String getName(){
            return name;
        }

        public double getCost(){
            return cost;
        }

        public int getStock(){
            return stock;
        }



    }

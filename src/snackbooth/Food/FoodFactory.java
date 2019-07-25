/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Food;

/**
 *
 * @author PC
 */
public class FoodFactory {
    
    private Food food;
    private static FoodFactory foodFactory;

    private FoodFactory() {

    }

    public static FoodFactory getInstance() {

        if (foodFactory == null) {

            foodFactory = new FoodFactory();

        }
        return foodFactory;

    }

    public Food makeFood(String f) {
        
        switch (f){
            case "Curry Puff":
                food = new CurryPuff();
                break;
            case "Kuih":
                food = new Kuih();
                break;
            case "Pau":
                food = new Pau();
                break;
            case "Tuna Sandwich":
                food = new TunaSandwich();
                break;
        }
        
        return food;
    }
    
}

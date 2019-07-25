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
public class Cheese extends SandwichDecorator {
    
    public Cheese(Food newFood) {
        super(newFood);
    }
    
    @Override
    public String getName() {
        
        return tempFood.getName() + " + Cheese";        
        
    }
    
}

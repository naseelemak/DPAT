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
public abstract class SandwichDecorator implements Food {

    protected Food tempFood;

    public SandwichDecorator(Food newFood) {

        tempFood = newFood;

    }

    @Override
    public String getName() {

        return tempFood.getName();

    }

    @Override
    public String getAvailability() {

        return tempFood.getAvailability();

    }

    @Override
    public double getCost() {

        return tempFood.getCost();

    }

}

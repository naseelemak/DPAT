/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Food;

import snackbooth.Database.FoodManagement;

/**
 *
 * @author PC
 */
public class Pau implements Food {

    FoodManagement foodMgmt;
    String food = "Pau";

    public Pau() {

        foodMgmt = FoodManagement.getInstance();

    }

    @Override
    public String getName() {
        return food;
    }

    @Override
    public String getAvailability() {
        foodMgmt.getData(food);
        return foodMgmt.getAvailability();
    }

    @Override
    public double getCost() {
        foodMgmt.getData(food);
        return foodMgmt.getCost();
    }

}

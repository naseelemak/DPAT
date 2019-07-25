/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Drink;

import snackbooth.Database.DrinkManagement;

/**
 *
 * @author PC
 */
public class Milo implements Drink {

    private DrinkManagement drinkMgmt;
    private String drink = "Milo";

    public Milo() {
        drinkMgmt = DrinkManagement.getInstance();
    }

    @Override
    public String getName() {
        return drink;
    }

    @Override
    public String getAvailability() {
        drinkMgmt.getData(drink);
        return drinkMgmt.getAvailability();
    }

    @Override
    public double getSmall() {
        drinkMgmt.getData(drink);
        return drinkMgmt.getSmall();
    }

    @Override
    public double getMedium() {
        drinkMgmt.getData(drink);
        return drinkMgmt.getMedium();
    }

    @Override
    public double getLarge() {
        drinkMgmt.getData(drink);
        return drinkMgmt.getLarge();
    }

}

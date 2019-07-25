/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Drink;

/**
 *
 * @author PC
 */
public abstract class DrinkDecorator implements Drink {

    protected Drink tempDrink;

    public DrinkDecorator(Drink newDrink) {
        tempDrink = newDrink;
    }

    @Override
    public String getName() {
        return tempDrink.getName();
    }

    @Override
    public double getSmall() {
        return tempDrink.getSmall();
    }

    @Override
    public double getMedium() {
        return tempDrink.getMedium();
    }

    @Override
    public double getLarge() {
        return tempDrink.getLarge();
    }

    @Override
    public String getAvailability() {
        return tempDrink.getAvailability();
    }

}

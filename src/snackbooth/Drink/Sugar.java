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
public class Sugar extends DrinkDecorator {

    String amount;

    public Sugar(Drink newDrink, String amount) {

        super(newDrink);

        this.amount = amount;
    }

    @Override
    public String getName() {

        switch (amount) {
            case "Some":
                return tempDrink.getName() + " + Some Sugar";
            case "More":
                return tempDrink.getName() + " + More Sugar";
            default:
                return tempDrink.getName() + "";
        }

    }

}

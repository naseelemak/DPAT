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
public class Milk extends DrinkDecorator {

    private String amount;

    public Milk(Drink newDrink, String amount) {
        super(newDrink);

        this.amount = amount;
    }

    @Override
    public String getName() {
        switch (amount) {
            case "Some":
                return tempDrink.getName() + " + Some Milk";
            case "More":
                return tempDrink.getName() + " + More Milk";
            default:
                return tempDrink.getName() + "";
        }
    }


}

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
public class DrinkFactory {

    private Drink drink;
    private static DrinkFactory drinkFactory;

    private DrinkFactory() {
    }

    public static DrinkFactory getInstance() {

        if (drinkFactory == null) {
            drinkFactory = new DrinkFactory();
        }
        return drinkFactory;
    }

    public Drink makeDrink(String d) {
        switch (d) {
            case "m":
                drink = new Milo();
                break;
            case "t":
                drink = new Tea();
                break;
            case "c":
                drink = new Coffee();
                break;
        }
        return drink;
    }
}

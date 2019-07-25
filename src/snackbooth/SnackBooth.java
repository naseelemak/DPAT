/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth;

import snackbooth.GUI.SnackBoothGUI;

/**
 *
 * @author PC
 */
public class SnackBooth {

    private static SnackBooth snackBooth;
    snackbooth.GUI.SnackBoothGUI menu = new snackbooth.GUI.SnackBoothGUI();

    private SnackBooth() {

        menu.setVisible(true);
    }

    public SnackBoothGUI getMenu() {
        return menu;
    }

    public static SnackBooth getInstance() {

        if (snackBooth == null) {

            snackBooth = new SnackBooth();

        }
        return snackBooth;

    }

}

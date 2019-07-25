/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth;

import snackbooth.GUI.KioskGUI;

/**
 *
 * @author PC
 */
public class KioskOff implements KioskState {

    @Override
    public void turnOffOn(Kiosk k) {
        k.setState(new KioskOn());
        k.kioskGUI = new KioskGUI();
        k.kioskGUI.bindKiosks(k);
        k.kioskGUI.setVisible(true);
        
        System.out.println("Kiosk turned on");
    }

}

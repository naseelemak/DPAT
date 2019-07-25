/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth;

/**
 *
 * @author PC
 */
public class KioskOn implements KioskState {

    @Override
    public void turnOffOn(Kiosk k) {
        k.setState(new KioskOff());
        k.kioskGUI.dispose();
        
        System.out.println("Kiosk turned off");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Account;

import snackbooth.GUI.KioskGUI;
import snackbooth.Kiosk;

/**
 *
 * @author PC
 */
public class Customer implements iCustomer {

    private Kiosk k;
    
    public Customer (Kiosk k) {
        
        this.k = k;
        
    }
    
    @Override
    public void viewMainMenu(KioskGUI kgui) {
              
        k.viewMainMenu(kgui);
                
    }

}

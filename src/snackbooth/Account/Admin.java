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
public class Admin implements iAdmin {
    
    private Kiosk k;
    
    public Admin (Kiosk k) {
        
        this.k = k;
        
    }
    
    @Override
    public void getTransactionLog(KioskGUI kgui) {
        k.getTransactionLog(kgui);
    }
    
}

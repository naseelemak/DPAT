/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import snackbooth.Account.iAdmin;
import snackbooth.Account.iCustomer;
import snackbooth.Drink.Drink;
import snackbooth.Food.Food;
import snackbooth.GUI.KioskGUI;

/**
 *
 * @author PC
 */
public class Kiosk implements iAdmin, iCustomer {

    private KioskState state;
    KioskGUI kioskGUI;
    private int kioskID;

    public Kiosk(int kioskID) {
        state = new KioskOff();
        this.kioskID = kioskID;
    }

    public void change() {
        state.turnOffOn(this);
    }

    public void setState(KioskState ks) {
        state = ks;
    }
    
    public int getKioskID() {
        return kioskID;
    }

    public void restart() {
        change();
        change();
    }


    public double requestDrink(Drink drink, String size) {

        double cost = 0.00;

        switch (size) {
            case "S":
                cost = drink.getSmall();
                break;
            case "M":
                cost = drink.getMedium();
                break;
            case "L":
                cost = drink.getLarge();
                break;
        }

        return cost;
    }

    public double requestFood(Food food) {

        double cost;

        cost = food.getCost();

        return cost;
    }

    public void viewMoreDetails(JTable table) {

        int row = table.getSelectedRow();
        System.out.println(row);
        String orderid = String.valueOf(table.getValueAt(row, 0));
        String customer = String.valueOf(table.getValueAt(row, 1));
        String item = String.valueOf(table.getValueAt(row, 2));
        String totalcost = String.valueOf(table.getValueAt(row, 3));
        JOptionPane.showConfirmDialog(null, "Order ID: " + orderid + "\nCustomer: " + customer + "\nItem: " + item + "\nCost: RM" + totalcost + "0", "Order Information", JOptionPane.DEFAULT_OPTION);
    }

    @Override
    public void getTransactionLog(KioskGUI kgui) {

        kgui.updateTableTransactions();
        kgui.setLogLabel("Transaction Log: Kiosk ");
        kgui.switchPanel("pnlAdmin");

    }

    @Override
    public void viewMainMenu(KioskGUI kgui) {
        kgui.switchPanel("pnlMainMenu");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class AccountManagement {

    private String id;
    private double balance;

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Retrieves specific entries from the text file
    public void getData(String id) {
        try {
            BufferedReader get = new BufferedReader(new FileReader("accounts.txt"));
            String read;
            boolean checked = false;
            while (checked == false) {
                while ((read = get.readLine()) != null) {
                    String[] splitt = read.split("!!");
                    if (splitt[0].equals(id)) {
                        setID(splitt[0]);
                        setBalance(Double.parseDouble(splitt[1]));
                    }
                }
                checked = true;
            }
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("accounts.txt");
                addItem("TP034526", 121.00);
                addItem("L031547", 154.00);
                addItem("TP034699", 24.00);
                addItem("TP034699", 24.00);
                getData(id);
            } catch (IOException IOe) {
                JOptionPane.showMessageDialog(null, IOe.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    // Adds entries to the text file
    public void addItem(String id, double balance) {
        String tosave = id + "!!" + balance;
        int lines = 1;
        try {
            BufferedReader in = new BufferedReader(new FileReader("accounts.txt"));
            while (in.readLine() != null) {
                lines++;
            }
            in.close();
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("accounts.txt", true);
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }

        try {
            FileWriter out = new FileWriter("accounts.txt", true);
            out.write(tosave + "\n");
            out.close();
        } catch (IOException e) {

        }
    }

    // Retrieves all account names from the text file
    public List<String> getEntries() {
        List<String> all = new ArrayList<>();
        try {
            BufferedReader get = new BufferedReader(new FileReader("accounts.txt"));
            String read;

            while ((read = get.readLine()) != null) {
                String[] splitt = read.split("!!");
                all.add(splitt[0]);
            }

            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("accounts.txt");
                writer.close();
            } catch (IOException IOe) {

            }
        } catch (Exception e) {

        }
        return all;
    }
    
    //Modifies account information
    public void updateBalance(String id, double balance){
        String newString;
        newString = id + "!!" + balance;
        try{
            BufferedReader get = new BufferedReader(new FileReader("accounts.txt"));
            String read;
            String total = "";
            String old = "";
            while ((read = get.readLine()) != null) {
                total += read + "\r\n";
                String[] splitt = read.split("!!");
                if (splitt[0].equals(this.id)){
                    old = read;
                }                 
            }
            total = total.replaceAll(old, newString);
            
            try{
                FileWriter fw = new FileWriter("accounts.txt");
                fw.write(total);
                fw.close();
                }     
            catch(IOException IOe){
            }
            
        }
        catch(Exception e){
        }        
    }
}

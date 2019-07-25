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
import snackbooth.Kiosk;

/**
 *
 * @author PC
 */
public class OrderManagement {

    private Kiosk kiosk;
    private int orderID = 0;
    private String customer;
    private String item;
    private double cost;
    
    public OrderManagement(Kiosk kiosk) {
        
        this.kiosk = kiosk;
        
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getItem() {
        return customer;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    //Gets a specific entry from text file
    public void getData(int id) {
        try {
            BufferedReader get = new BufferedReader(new FileReader("orders.txt"));
            String read;
            boolean checked = false;
            while (checked == false) {
                while ((read = get.readLine()) != null) {
                    String[] splitt = read.split("!!");
                    if (splitt[0].equals(String.valueOf(id))) {
                        setOrderID(Integer.parseInt(splitt[0]));
                        setCustomer(splitt[1]);
                        setItem(splitt[2]);
                        setCost(Double.parseDouble(splitt[3]));
                    }
                }
                checked = true;
            }
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("orders.txt");
                addOrder(1, "TP034526", "Coffee", 5.00);
                getData(id);
            } catch (IOException IOe) {
                JOptionPane.showMessageDialog(null, IOe.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    //Adds a new entry to text file
    public void addOrder(int orderID, String customer, String item, double cost) {
        String kiosk = String.valueOf(this.kiosk.getKioskID());
        
        String tosave = orderID + "!!" + customer + "!!" + item + "!!" + cost;
        int lines = 1;
        try {
            BufferedReader in = new BufferedReader(new FileReader("orders.txt"));
            while (in.readLine() != null) {
                lines++;
            }
            in.close();
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("orders.txt", true);
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }

        try {
            FileWriter out = new FileWriter("orders.txt", true);
            out.write(tosave + "\n");
            out.close();
            //FileWriter out = new FileWriter("transactions" + k.kiosk +".txt", true);
            //out.write(tosave + "\n");
            //out.close();            
        } catch (IOException e) {

        }
        
        try {
            FileWriter out = new FileWriter("kiosk" + kiosk + ".txt", true);
            out.write(tosave + "\n");
            out.close();
            //FileWriter out = new FileWriter("transactions" + k.kiosk +".txt", true);
            //out.write(tosave + "\n");
            //out.close();            
        } catch (IOException e) {

        }
    }

    // Retrieves all orders from the orders text file
    public List<String> getEntries() {
        List<String> all = new ArrayList<>();
        try {
            BufferedReader get = new BufferedReader(new FileReader("orders.txt"));
            String read;

            while ((read = get.readLine()) != null) {
                String[] splitt = read.split("!!");
                all.add(splitt[0]);
                all.add(splitt[1]);
                all.add(splitt[2]);
                all.add(splitt[3]);
            }

            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("orders.txt");
                writer.close();
            } catch (IOException IOe) {

            }
        } catch (Exception e) {

        }
        return all;
    }
    
    // Retrieves all orders from the text file
    public List<String> getEntries(int kioskID) {
        List<String> all = new ArrayList<>();
        try {
            BufferedReader get = new BufferedReader(new FileReader("kiosk" + kioskID + ".txt"));
            String read;

            while ((read = get.readLine()) != null) {
                String[] splitt = read.split("!!");
                all.add(splitt[0]);
                all.add(splitt[1]);
                all.add(splitt[2]);
                all.add(splitt[3]);
            }

            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("kiosk" + kioskID + ".txt");
                writer.close();
            } catch (IOException IOe) {

            }
        } catch (Exception e) {

        }
        return all;
    }
    
    //Removes an order entry
    public void fulfilOrder(String id) {

        try {
            BufferedReader get = new BufferedReader(new FileReader("orders.txt"));
            String read;
            String total = "";
            while ((read = get.readLine()) != null) {

                String[] splitt = read.split("!!");
                if (splitt[0].equals(id)) {

                } else {

                    total += read + "\r\n";

                }
            }

            try {
                FileWriter fw = new FileWriter("orders.txt");
                fw.write(total);
                fw.close();
            } catch (IOException IOe) {
            }

        } catch (Exception e) {
        }
    }

    //Updates the order count
    public void updateOrderCount() {
        int newString;
        String total;
        String old = "";
        try {
            BufferedReader get = new BufferedReader(new FileReader("ordercount.txt"));

            old = get.readLine();
            get.close();
            System.out.println(old);

            newString = Integer.parseInt(old) + 1;
            total = String.valueOf(newString);
            System.out.println(newString);
            old = old.replaceAll(old, total);
            System.out.println(old);
        } catch (FileNotFoundException fe) {
            try {
                System.out.println("hgh");
                FileWriter writer = new FileWriter("ordercount.txt", true);
                addFirstOrderCount();
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }
        try {
            FileWriter fw = new FileWriter("ordercount.txt");
            System.out.println(old);
            fw.write(old);
            System.out.println(old);
            fw.close();
        } catch (IOException IOe) {
        } catch (Exception e) {
        }
    }

    //Adds first order count
    public void addFirstOrderCount() {
        String tosave = "0";
        try {
            FileWriter out = new FileWriter("ordercount.txt", true);
            out.write(tosave + "\n");
            out.close();
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("ordercount.txt", true);
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }
    }

    //Gets the order count
    public int getOrderCount() {
        int newString = 0;
        int read = 0;
        try {
            BufferedReader get = new BufferedReader(new FileReader("ordercount.txt"));

            read = Integer.parseInt(get.readLine());
            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("ordercount.txt", true);
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }

        return read;
    }

}

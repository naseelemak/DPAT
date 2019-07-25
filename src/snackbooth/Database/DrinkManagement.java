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
public class DrinkManagement {

    private static DrinkManagement drinkMgmt;
    private String product;
    private double small;
    private double medium;
    private double large;
    private String availability;

    private DrinkManagement() {

    }

    // returns instance of DrinkManagement
    public static DrinkManagement getInstance() {

        if (drinkMgmt == null) {

            drinkMgmt = new DrinkManagement();

        }

        return drinkMgmt;
    }

    public double getLarge() {
        return large;
    }

    public void setLarge(double large) {
        this.large = large;
    }

    public double getMedium() {
        return medium;
    }

    public void setMedium(double medium) {
        this.medium = medium;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getSmall() {
        return small;
    }

    public void setSmall(double small) {
        this.small = small;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void getData(String product) {
        try {
            BufferedReader get = new BufferedReader(new FileReader("drinks.txt"));
            String read;
            boolean checked = false;
            while (checked == false) {
                while ((read = get.readLine()) != null) {
                    String[] splitt = read.split("!!");
                    if (splitt[0].equals(product)) {
                        setProduct(splitt[0]);
                        setSmall(Double.parseDouble(splitt[1]));
                        setMedium(Double.parseDouble(splitt[2]));
                        setLarge(Double.parseDouble(splitt[3]));
                        setAvailability(splitt[4]);
                    }
                }
                checked = true;
            }
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("drinks.txt");
                addItem("Milo", 3.00, 4.00, 5.00, "Available");
                addItem("Tea", 2.00, 3.00, 4.00, "Available");
                addItem("Coffee", 2.00, 3.00, 4.00, "Available");
                getData(product);
            } catch (IOException IOe) {
                JOptionPane.showMessageDialog(null, IOe.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    // Adds a new food item to the text file
    public void addItem(String product, double small, double medium, double large, String availability) {
        String tosave = product + "!!" + small + "!!" + medium + "!!" + large + "!!" + availability;
        int lines = 1;
        try {
            BufferedReader in = new BufferedReader(new FileReader("drinks.txt"));
            while (in.readLine() != null) {
                lines++;
            }
            in.close();
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("drinks.txt", true);
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }

        try {
            FileWriter out = new FileWriter("drinks.txt", true);
            System.out.println(tosave); // REMEMBER TO REMOVE
            out.write(tosave + "\n");
            out.close();
        } catch (IOException e) {

        }
    }

    // Overwrites text file with given list
    public void updateDrinks(List<String> list) {

        String total = "";

        try {
            FileWriter fw = new FileWriter("drinks.txt");
            fw.write(total);
            fw.close();
        } catch (IOException IOe) {
        }

        for (int i = 0; i < list.size(); i = i + 5) {

            addItem(list.get(i), Double.parseDouble(list.get(i + 1)), Double.parseDouble(list.get(i + 2)), Double.parseDouble(list.get(i + 3)), list.get(i + 4));
        }

    }
    
    // Retrieves all drink entries from the text file
    public List<String> getEntries() {
        List<String> all = new ArrayList<>();
        try {
            BufferedReader get = new BufferedReader(new FileReader("drinks.txt"));
            String read;

            while ((read = get.readLine()) != null) {
                String[] splitt = read.split("!!");
                all.add(splitt[0]);
                all.add(splitt[1]);
                all.add(splitt[2]);
                all.add(splitt[3]);
                all.add(splitt[4]);
            }

            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("drinks.txt");
                addItem("Milo", 3.00, 4.00, 5.00, "Available");
                addItem("Tea", 2.00, 3.00, 4.00, "Available");
                addItem("Coffee", 2.00, 3.00, 4.00, "Available");
                writer.close();
            } catch (IOException IOe) {

            }
        } catch (Exception e) {

        }
        return all;
    }

}

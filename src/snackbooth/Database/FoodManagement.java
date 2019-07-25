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
public class FoodManagement {

    private String product;
    private double cost;
    private String availability;
    private static FoodManagement foodMgmt;
    
    private FoodManagement() {
        
    }
    
    public static FoodManagement getInstance() {
        
        if (foodMgmt == null) {
            foodMgmt = new FoodManagement();
        }
        
        return foodMgmt;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public String getAvailability() {
        return availability;
    }
    
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // Retrieves specific entry from text file
    public void getData(String product) {
        try {
            BufferedReader get = new BufferedReader(new FileReader("food.txt"));
            String read;
            boolean checked = false;
            while (checked == false) {
                while ((read = get.readLine()) != null) {
                    String[] splitt = read.split("!!");
                    if (splitt[0].equals(product)) {
                        setProduct(splitt[0]);
                        setCost(Double.parseDouble(splitt[1]));
                        setAvailability(splitt[2]);
                    }
                }
                checked = true;
            }
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("food.txt");
                addItem("Curry Puff", 2.00, "Available");
                addItem("Kuih", 1.00, "Available");
                addItem("Pau", 3.00, "Available");
                addItem("Tuna Sandwich", 5.00, "Available");
                writer.close();
                getData(product);
            } catch (IOException IOe) {
                JOptionPane.showMessageDialog(null, IOe.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    //Adds food items to the text file
    public void addItem(String product, double cost, String availability) {
        String tosave = product + "!!" + cost + "!!" + availability;
        int lines = 1;
        try {
            BufferedReader in = new BufferedReader(new FileReader("food.txt"));
            while (in.readLine() != null) {
                lines++;
            }
            in.close();
        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("food.txt", true);
                writer.close();
            } catch (IOException ioe) {

            }
        } catch (IOException ioe2) {

        }

        try {
            FileWriter out = new FileWriter("food.txt", true);
            out.write(tosave + "\n");
            out.close();
        } catch (IOException e) {

        }
    }
    
    // Overwrites text file with given list
    public void updateFood(List<String> list) {

        String total = "";

        try {
            FileWriter fw = new FileWriter("food.txt");
            fw.write(total);
            fw.close();
        } catch (IOException IOe) {
        }

        for (int i = 0; i < list.size(); i = i + 3) {
            
            System.out.println(list.get(i));
            addItem(list.get(i), Double.parseDouble(list.get(i + 1)), list.get(i + 2));
        }

    }

    // Retrieves all food names from the text file
    public List<String> getNames() {
        List<String> all = new ArrayList<>();
        try {
            BufferedReader get = new BufferedReader(new FileReader("food.txt"));
            String read;

            while ((read = get.readLine()) != null) {
                String[] splitt = read.split("!!");
                all.add(splitt[0]);
            }
                        
            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("food.txt");
                addItem("Curry Puff", 2.00, "Available");
                addItem("Kuih", 1.00, "Available");
                addItem("Pau", 3.00, "Available");
                addItem("Tuna Sandwich", 5.00, "Available");
                writer.close();
            } catch (IOException IOe) {

            }
        } catch (Exception e) {

        }
        return all;
    }
    
    // Retrieves all food entries from the text file
    public List<String> getEntries() {
        List<String> all = new ArrayList<>();
        try {
            BufferedReader get = new BufferedReader(new FileReader("food.txt"));
            String read;

            while ((read = get.readLine()) != null) {
                String[] splitt = read.split("!!");
                all.add(splitt[0]);
                all.add(splitt[1]);
                all.add(splitt[2]);
            }

            get.close();

        } catch (FileNotFoundException fe) {
            try {
                FileWriter writer = new FileWriter("food.txt");
                addItem("Curry Puff", 2.00, "Available");
                addItem("Kuih", 1.00, "Available");
                addItem("Pau", 3.00, "Available");
                addItem("Tuna Sandwich", 5.00, "Available");
                writer.close();
            } catch (IOException IOe) {

            }
        } catch (Exception e) {

        }
        return all;
    }
}

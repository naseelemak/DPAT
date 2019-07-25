/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackbooth.Drink;

import snackbooth.Product;

/**
 *
 * @author PC
 */
public interface Drink extends Product {
    
    public double getSmall();
    public double getMedium();
    public double getLarge();
    
}

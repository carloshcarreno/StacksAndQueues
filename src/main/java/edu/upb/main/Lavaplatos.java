/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.main;

import edu.upb.stacks.ArrayStack;

/**
 *
 * @author cahuc
 */
public class Lavaplatos {
    
    private ArrayStack<String> toWash;
    
    public Lavaplatos(int max){
        toWash = new ArrayStack(max);
    }
    
    public void addPlate(String plate){
        toWash.push(plate);
    }
    
    public String removePlate(){
        return toWash.pop();
    }

    
}

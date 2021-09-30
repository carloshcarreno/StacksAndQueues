/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.models;

/**
 *
 * @author cahuc
 */
public interface ITree {
    
    public void add(int value);
    public boolean contains(int value);
    public void delete(int value);
    public int getRootValue();
    
}

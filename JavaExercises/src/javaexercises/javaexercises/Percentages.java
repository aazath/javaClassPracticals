/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexercises;

import java.util.Scanner;

/**
 *
 * @author apple
 */
public class Percentages {
    public static void main(String args[]){
        double var1, var2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Number 01 :");
        var1 = input.nextDouble();
        
        System.out.println("Enter the Number 02 :");
        var2 = input.nextDouble();
        
        computePercent(var1, var2);
    }
    
    public static void computePercent(double input1, double input2){
        double percent;
        percent = (input1/input2)* 100;
        System.out.println(input1 + " is "+percent+" Percent of "+input2);
    }
}

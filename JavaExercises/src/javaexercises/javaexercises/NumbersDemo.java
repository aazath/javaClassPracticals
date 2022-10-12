/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexercises;

/**
 *
 * @author apple
 */
public class NumbersDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // int num1, num2;
        displayTwiceTheNumber(5);
        displayNumberPlusFive(10);
        displayNumberSquared(5);

    }

    /**
     *
     * @param input
     */
    public static void displayTwiceTheNumber(int input) {
        System.out.println(input * 2);
    }

    public static void displayNumberPlusFive(int input) {
        System.out.println(input + 5);
    }

    public static void displayNumberSquared(int input) {
        System.out.println(input * input);
    }

}

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
public class BookStoreCredits {
    public static void main(String[] args) {
        String name;
        double grade, credit;

        Scanner input   = new Scanner(System.in);

        System.out.println("Enter your Name :");
        name = input.nextLine();

        System.out.println("Enter your Grade :");
        grade = input.nextDouble();

        credit = grade * 10;

        System.out.println(name + " Earned $ "+credit +" in Bookstore Credit");

        input.close();


    }

}

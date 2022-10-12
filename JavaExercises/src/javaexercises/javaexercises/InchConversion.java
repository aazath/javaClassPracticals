package javaexercises;

import java.util.Scanner;

public class InchConversion {
    public static void main(String[] args) {
        int inches,feets;
        double yards;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Number of Inches :");
        inches = input.nextInt();

        inchesToFeet(inches);
        feetsToYard(inches);

    }

    public static void inchesToFeet(int in) {
        feets = (in/12);
        System.out.println(in +" inches are "+ feets);
    }

    public static void feetsToYard(int in) {
        yards = in/3 ;
        System.out.println(yards);
    }
    
}

package javaexercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PaintCalculator{

    public static void main(String[] args) {
        //1 gallon covers 350 sq.feet
        double height, width, length, area;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Height of the Wall in Feets :");
        height = input.nextDouble();
        System.out.println("Enter the Width of the Wall :");
        width = input.nextDouble();
        System.out.println("Enter the Length of the Wall in Feets:");
        length = input.nextDouble();

        area = AreaCalculate(length, height, width);
        PaintGallons(area);

    }
    
    public static double AreaCalculate(double len, double ht, double wide){
         return len * ht * wide;
    }

    public static void PaintGallons( double a) {
        double gallonsNeeded = (a/350);
        DecimalFormat format = new DecimalFormat("#0.00");
        System.out.println("Number of Paint Gallons Needed :"+format.format(gallonsNeeded));
    }

    public double PaintCost(double num) {
        double paintCost = num / 32 ;
        return paintCost;
    }
}

import java.util.*;

public class SimpleMethod {
    public static void main(String[] args) {
        // System.out.println("Hello from the main method");
        // displayMessage();
        // System.out.println("Back in the main method");
        // add(3, 5, 34, 90);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your Capital :");
        double capital = in.nextDouble();

        System.out.print("Enter your Time :");
        int time = in.nextInt();

        System.out.print("Enter your Rate of Interest :");
        double rate = in.nextDouble();

        double inte = interestCalculator(capital, time, rate);
        System.out.println("The interest of your capital is : " + inte);

        // double number = Math.pow(4, 3);
        // System.out.println(number);
        in.close();
    }

    static double interestCalculator(double principle, int time, double rate) {
        return (principle * time * rate) / 100;
        // return interest;
    }

    static void add(int a, int b, int c, int d) {
        int sum = (a + b + c + d);
        System.out.println(sum);
    }

    public static void displayMessage() {
        System.out.println("Hello from the displayMessage method");
    }
}
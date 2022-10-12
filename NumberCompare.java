import java.util.Scanner;

public class NumberCompare {
    public static void main(String[] args) {
        int number1, number2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the First Number :");
        number1 = in.nextInt();

        System.out.println("Enter the Second Number :");
        number2 = in.nextInt();

        if (number1 > number2) {
            System.out.println("The Larger number of your input is : " + number1);
        } else {
            System.out.println("The Larger number of your input is : " + number2);
        }
        in.close();
    }
}
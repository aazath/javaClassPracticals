import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        double income, taxable, tax;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your Annual Income ");
        income = in.nextDouble();

        if (income < 15000) {
            tax = 0;
            System.out.println("You are free from tax");
        } else if ((income > 15000) && (income < 30000)) {
            tax = (income - 15000) * 0.05;
            System.out.println("Your tax for the income is " + tax);
        } else {
            taxable = income - 30000;
            tax = (taxable * 0.1) + 750.0;
            System.out.println("Your tax for the income is :" + tax);
        }

        in.close();

    }
}
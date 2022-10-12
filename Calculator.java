import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        double number1, number2, result;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Operator (Either +, -, * or /) :");
        char op = in.next().charAt(0);
        System.out.println("Enter Number1 :");
        number1 = in.nextDouble();
        System.out.println("Enter Number2 :");
        number2 = in.nextDouble();

        switch (op) {
        case '+':
            result = number1 + number2;
            System.out.println("The output is: " + result);
            break;
        case '-':
            result = number1 - number2;
            System.out.println("The output is: " + result);
            break;
        case '*':
            result = number1 * number2;
            System.out.println("The output is: " + result);
            break;
        case '/':
            result = number1 / number2;
            System.out.println("The output is: " + result);
            break;
        default:
            System.out.println("Invalid Input!. ");
            break;
        }
        in.close();
    }

}
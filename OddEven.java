import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a Number :");

        int input = keyboard.nextInt();

        if (input % 2 == 0) {
            System.out.println("Your input is Even");
        } else {
            System.out.println("Your Input is Odd");
        }
        keyboard.close();
    }
}
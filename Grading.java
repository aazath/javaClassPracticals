import java.util.Scanner;

public class Grading {
    public static void main(String[] args[]) {
        int marks1, marks2, marks3, marks4, marks5, total = 0;
        double average;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the First Marks :");
        marks1 = in.nextInt();
        total += marks1;
        System.out.println("Enter the Second Marks :");
        marks2 = in.nextInt();
        total += marks2;
        System.out.println("Enter the Third Marks :");
        marks3 = in.nextInt();
        total += marks3;
        System.out.println("Enter the Fourth Marks :");
        marks4 = in.nextInt();
        total += marks4;
        System.out.println("Enter the Fifth Marks :");
        marks5 = in.nextInt();
        total += marks5;

        average = total / 5;
        System.out.println("Your Total Marks is: " + total);
        System.out.println("Your Average is : " + average);
        if (average >= 90) {
            System.out.println("Your Grade is : 'A'");
        } else if (average >= 80) {
            System.out.println("Your Grade is : 'B'");
        } else if (average >= 70) {
            System.out.println("Your Grade is : 'C'");
        } else if (average >= 60) {
            System.out.println("Your Grade is : 'D'");
        } else {
            System.out.println("Your Grade is : 'E'");
        }
        in.close();
    }
}

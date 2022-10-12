
public class WhileLoop {
    public static void main(String[] args) {
        int i = 0;// counter

        // Print the odd numbers between 0 to 100
        System.out.println("List of Odd Numbers Between: 0 - 100 :");

        while (i <= 100) {
            if (i % 2 == 1)
                System.out.println(i);
            i++;
        }
    }
}
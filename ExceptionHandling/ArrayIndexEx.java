import java.util.Scanner;

public class ArrayIndexEx {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Welcome to AYAINN Application");
		System.out.println("=============================");
		System.out.println("Enter the size of the Array :");
		
		try
		{
			int size = scan.nextInt();
			
			//create an array with size of input
			int[] nums = new int[size];
			
			System.out.println("Enter an element to save into the array ");
			int elem = scan.nextInt();
			
			System.out.println("Enter the position to save the element (0-"+(nums.length-1)+")");
			int pos = scan.nextInt();
			
			nums[pos] = elem;
		}
		catch(NegativeArraySizeException e)
		{
			System.out.println("Array size cannot be in negative");
		}
		catch(ArrayIndexOutOfBoundsException f)
		{
			System.out.println("You can't save element out of bounds the array");
		}
		catch(Exception a)
		{
			System.out.println("Enter proper inputs");
		}
		
		System.out.println("Thank you for using our Application");

	}

}

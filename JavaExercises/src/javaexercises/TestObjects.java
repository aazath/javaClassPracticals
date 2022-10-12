
public class TestObjects {

    public static void main(String[] args) {
        CirclefromSGO circle = new CirclefromSGO(2);
        //System.out.println("A Circle "+ circle.toString());
       System.out.printf("Area of the circle is: %.2f", circle.getArea());
        System.out.println("\nA Circle is Filled with: "+ circle.getColour());
    }
    

}

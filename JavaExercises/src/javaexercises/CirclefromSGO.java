public class CirclefromSGO extends SimpleGeometricObjects {
    private double radius;

    public CirclefromSGO(){

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public CirclefromSGO(double radius){
        this.setRadius(radius);
    }

    public CirclefromSGO(double radius, String colour, boolean filled){
        this.setRadius(radius);
        setColour(colour);
        setFilled(filled);
    }

    public double getArea(){
        return (radius * radius * Math.PI);
    }

    public double getDiameter(){
        return radius * 2;
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    public void printCircle(){
        System.out.println("The Circle is Created "+ getDateCreated() + "and the radius is "+ radius);
    }
}

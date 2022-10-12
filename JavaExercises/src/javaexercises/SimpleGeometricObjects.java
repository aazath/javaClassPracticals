
import java.util.Date;

public class SimpleGeometricObjects {
    private String colour = "White";
    private boolean filled;
    Date dateCreated;

    SimpleGeometricObjects(){
        dateCreated = new Date();
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public SimpleGeometricObjects(String colour, boolean filled){
        dateCreated = new Date();
        this.setColour(colour);
        this.setFilled(filled);
    }

    public String toString(){
        return "Created On "+dateCreated+ " \ncolour: " +colour + " and filled: "+ filled;

    }
    
}

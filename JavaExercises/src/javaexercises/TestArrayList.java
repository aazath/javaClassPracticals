import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> citiesList = new ArrayList<>();

        citiesList.add("London");
        citiesList.add("Tokyo");    
        citiesList.add("Delhi");
        citiesList.add("Paris");
        citiesList.add("Tokyo");

        System.out.println("List Size? "+citiesList.size());
        System.out.println("Is Miami in the list? "+citiesList.contains("Miami"));
        System.out.println("Index of London in the List? "+citiesList.indexOf("London"));

        citiesList.add("Xian");
        citiesList.add("London");
        System.out.println("List Size? "+citiesList.size());
        citiesList.remove("London");

        citiesList.remove("Delhi");
        citiesList.remove(1);

        System.out.println(citiesList.toString());

        //print the content of the list in reverse order
        for(int i = citiesList.size() - 1; i>=0; i--){
            System.out.println(citiesList.get(i) +" ");
            System.out.println();
        }
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Demo2 {
    public static void main(String[] args) throws IOException{
        //Integer Stream
        IntStream
            .range(1, 10)
            .forEach(System.out::print);
        System.out.println();

        //Integer stream with skip
        IntStream
            .range(1, 10)
            .skip(5)//skip to print until 5 /only print 6-9
            .forEach(x -> System.out.println(x));
        System.out.println();

        System.out.println(
            "Sum of the elements b/w range "+
            IntStream
                .range(1, 5)
                .sum());
        System.out.println();

        //Stream.of, sorted and findFirst
        System.out.print("First name in the alphabetically sorted list : ");
        Stream.of("Aazath", "Ayana", "Atheena","Aafiya")
            .sorted()
            .findFirst()
            .ifPresent(System.out::println);
        System.out.println();
        
        //Stream from Array, sort, filter and print
        System.out.println("Printing Names sorted with First Letter :");
        String[] names = {"Sachin", "Dravid", "Sanath", "Kalu","Vaas","Lasith","Chamika","Dinesh"};
        Arrays.stream(names) //same as Stream.of(names)
            .filter(x -> x.startsWith("S"))
            .sorted()
            .forEach(System.out::println);
        System.out.println();

        
        System.out.println("Average of squares of an int array : ");
        Arrays.stream(new int[] {2,4,6,8,10})
            .map(x -> x * x)
            .average()
            .ifPresent(System.out::println);

        System.out.println();
        System.out.println("Stream from List, Filter and Print : ");
        List<String> people = Arrays.asList("Sachin", "Dravid", "Sanath", "Kalu","Vaas","Lasith","Chamika","Dinesh");
        people.stream() //create a stream of people
            .map(String::toLowerCase) //convert all names into lowercase
            .filter(s -> s.startsWith("s")) //filter names that starts with "s"
            .forEach(System.out::println); //print the filtered names
        
        System.out.println();
        System.out.println("Stream rows from text file, sort, filter and print : ");
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
            .sorted()
            .filter(x -> x.length() > 13)
            .forEach(System.out::println);
        bands.close(); //should close to prevent the memory leak

        System.out.println();
        System.out.println("Stream rows from text file and save to list :");
        //creating bands2 list by applying filter on the contents of the text file
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
            .filter(s -> s.contains("jit"))
            .collect(Collectors.toList());
        bands2.forEach(System.out::println);

        System.out.println();
        System.out.println("Streams rows from CSV file and count :");
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int) rows1
            .map(s -> s.split(","))
            .filter(s -> s.length == 3)
            .count();
        System.out.println(rowCount + " rows. ");
        rows1.close();


    }
}

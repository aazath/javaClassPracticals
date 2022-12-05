import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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
        // System.out.println("Contents of the file :");
        // rows1.forEach(System.out::println);
        int rowCount = (int) rows1
            .map(s -> s.split(","))
            .filter(s -> s.length == 3)
            .count();
        System.out.println(rowCount + " rows. ");
        rows1.close();

        System.out.println();
        System.out.println("Stream rows from CSV file, parse data from rows :");
        Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2   
            .map(x -> x.split(","))
            .filter(x -> x.length ==3)
            .filter(x -> Integer.parseInt(x[1]) > 15)
            .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();

        System.out.println();
        System.out.println("Stream rows from CSV file, store fields in HashMap ");
        Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3 
            .map(x -> x.split(","))
            .filter(x ->x.length ==3)
            .filter(x-> Integer.parseInt(x[1])>15)
            .collect(Collectors.toMap(
                x ->x[0], 
                x -> Integer.parseInt(x[1])));
        rows3.close();
        for(String key : map.keySet())
        {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println();
        System.out.println("Reduction - sum ");
        double total = Stream.of(7.3, 1.5, 4.8)
            .reduce(0.0, (Double a, Double b) -> a +b);
        System.out.println("Total = "+total );


        System.out.println();
        System.out.println("Reducation - summary statistics ");
        IntSummaryStatistics summary = IntStream.of(5, 10,7,8,3,9)
            .summaryStatistics();
        System.out.println(summary);
    }
}

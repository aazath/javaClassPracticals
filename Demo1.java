// stream is faster then collection
// stream can used with multi-thread
// stream does not change the orinigal data
// use-cases: use only with huge chunk of data

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Demo1{

public static void main(String[]args){

        //create a list of integers by passing some values
        List<Integer> nums = Arrays.asList(6,5,2,8,1,7);
        
        //create a predicate to pass to the stream filter function

        //normal implementation
        // Predicate<Integer> predicate = new Predicate<Integer>() {
        //         @Override
        //         public boolean test(Integer t) {
        //                 //if odd number return true
        //                 //so, only odd numbers will be returned to the predicate
        //                 if(t%2==1)
        //                         return true;
        //                 else
        //                         return false;
        //         }
                
        // };

        //implementation with lambda expression
       // Predicate<Integer> predicate = t -> t%2==1;

        //create a stream object for nums list
        //stream object is used only once
        Stream<Integer> stream1 = nums.stream();
        
        //filter() will return another stream object
        // Stream<Integer> stream2 = stream1.filter(predicate);

        //pass the lambda opject directly
        Stream<Integer> stream2 = stream1.filter(t -> t%2==1);

        //to do another operation on data like double the number (n * 2)
        //use a map -> not the collection map
        //map will take Function as input and return another value

        //so, create a Function object with normal implementation
        // Function<Integer,Integer> func = new Function<Integer,Integer>() {
        //         @Override
        //         public Integer apply(Integer n){
        //                 return n *2;
        //         }
        // };

        //so, create a Function object using lambda expression
        Function<Integer,Integer> func = n -> n *2;

        //map() will return another stream objects with doubled values
        //Stream<Integer> stream3 = stream2.map(func);
        Stream<Integer> stream3 = stream2.map(n -> n *2);

        //print the contents of the new stream object
        stream3.forEach(n -> System.out.println(n));
}
}
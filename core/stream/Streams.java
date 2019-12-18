package core.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("strings = " + strings);
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("filtered = " + filtered);
		
		//forEach
		//Stream has provided a new method ‘forEach’ to iterate each element of the stream. 
		//The following code segment shows how to print 10 random numbers using forEach.
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		//map
		//The ‘map’ method is used to map each element to its corresponding result. 
		//The following code segment prints unique squares of numbers using map.
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);		
		List<Integer> squaresList = numbers.stream().map( i -> i*i).collect(Collectors.toList());		
		System.out.println("squaresList = " + squaresList);
		//get list of unique squares
		List<Integer> uniqueSquaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.println("uniqueSquaresList = " + uniqueSquaresList);
		
		//filter
		// The ‘filter’ method is used to eliminate elements based on a criteria. 
		//The following code segment prints a count of empty strings using filter.
		List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		long count = strings1.stream().filter(string -> string.isEmpty()).count();
		System.out.println("count = " + count);
		
		
		//limit
		// The ‘limit’ method is used to reduce the size of the stream. 
		//The following code segment shows how to print 10 random numbers using limit.
		Random random1 = new Random();
		random1.ints().limit(10).forEach(System.out::println);
		
		
		//sorted
		// The ‘sorted’ method is used to sort the stream. 
		//The following code segment shows how to print 10 random numbers in a sorted order.
		Random random2 = new Random();
		random2.ints().limit(10).sorted().forEach(System.out::println);
		
		//Parallel Processing
		//parallelStream is the alternative of stream for parallel processing. 
		//Take a look at the following code segment that prints a count of empty strings using parallelStream.
		List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		long count1 = strings.parallelStream().filter(string -> string.isEmpty()).count();
		
		//Collectors
		// Collectors are used to combine the result of processing on the elements of a stream. 
		//Collectors can be used to return a list or a string.
		List<String>strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered1 = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered1);
		String mergedString = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		//Statistics
		//With Java 8, statistics collectors are introduced to calculate all statistics when 
		//stream processing is being done.
		/*List numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = numbers1.stream().mapToInt((x) -> Integer.parseInt((String) x)).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());*/
		
		
	}

}

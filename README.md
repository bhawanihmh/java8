# java8
Java 8 Examples

## For Java programming, Java SE 8 offers a plethora of features. Some of them are

 **Lambda expression** − Adds functional processing capability to Java.

**Method references** − Referencing functions by their names instead of invoking them directly. Using functions as parameter.

**Default method** − Interface to have default method implementation.

**New tools** − New compiler tools and utilities are added like ‘jdeps’ to figure out dependencies.

**Stream API** − New stream API to facilitate pipeline processing.

**Date Time API** − Improved date time API.

**Optional** − Emphasis on best practices to handle null values properly.

**Nashorn, JavaScript Engine** − A Java-based engine to execute JavaScript code.

**ForEach() Method** - In order to iterate over the Collection Framework, Java SE8 offers a new method called forEach which is defined in the Iterable interface. ForEach() loop can be used in a collection class that extends the interface Iterable. Since this method inputs a single parameter, a lambda expression can also be passed as a parameter.

**StringJoiner** - A new final class StringJoiner has been added to Java 8 in the java. util package. A sequence of characters can be constructed separated by delimiters like comma (,), hyphen (-), etc.

## Security Enhancements
In addition to these features, several other Security Enhancements are also done to Java SE8. They are:

The Public Key Cryptography Standards 11 (PKCS) has been extended to comprise 64-bit supports for the Operating system, Windows.

For UNIX platforms, two new implementations have been presented. It offers blocking and non-blocking behavior.

In SunJCE provider, AES and PBE algorithms such as PBEWithSHA256AndAES_128 and PBEWithSHA512AndAES_256 are also added.

Java SE 8 supports the Server Name Indication (SNI) extension that extends the TLS/SSL protocols to connect during handshaking for supporting server applications.

## Functional interfaces
Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a single method ‘compareTo’ is used for comparison purpose. Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. Following is the list of functional interfaces defined in java.util.Function package.

### Consumer<T>
Represents an operation that accepts a single input argument and returns no result.<br>
Syntax: void accept(T t)<br>
t– the input argument<br>
```java
        // Consumer to display a number 
        Consumer<Integer> display = a -> System.out.println(a); 
  
        // Implement display using accept() 
        display.accept(10); 
  
        // Consumer to multiply 2 to every integer of a list 
        Consumer<List<Integer> > modify = list -> 
        { 
            for (int i = 0; i < list.size(); i++) 
                list.set(i, 2 * list.get(i)); 
        }; 
  
        // Consumer to display a list of numbers 
        Consumer<List<Integer> > 
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " ")); 
  
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(2); 
        list.add(1); 
        list.add(3); 
  
        // Implement modify using accept() 
        modify.accept(list); 
  
        // Implement dispList using accept() 
        dispList.accept(list); 
```
using addThen() :  modify.andThen(dispList).accept(list); 
### Supplier<T>
It represents a function which does not take in any argument but produces a value of type T.<br>
Syntex: T get()  <br>
Returns: This method returns a value of type T.<br>
```java
        // This function returns a random value. 
        Supplier<Double> randomValue = () -> Math.random(); 
  
        // Print the random value using get() 
        System.out.println(randomValue.get()); 
```
### Function<T,R>
It represents a function which takes in one argument and produces a result.<br>
Syntex : R apply(T t) <br>
Parameters: This method takes in only one parameter t which is the function argument <br>
Returns: This method returns the function result which is of type R. <br>
```java
        // Function which takes in a number 
        // and returns half of it 
        Function<Integer, Double> half = a -> a / 2.0; 
  
        // apply the function to get the result 
        System.out.println(half.apply(10)); 
```

### Predicate<T>
Represents a predicate (Boolean-valued function) of one argument.
### BinaryOperator<T>
Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
### UnaryOperator<T>
Represents an operation on a single operand that produces a result of the same type as its operand.

## Lambda expressions
Lambda expressions are used primarily to define inline implementation of a functional interface, i.e., an interface with a single method only.
Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming capability to Java.

## Method references
Method references help to point to methods by their names. A method reference is described using :: (double colon) symbol. A method reference can be used to point the following types of methods −

Static methods<br>
Instance methods<br>
Constructors using new operator (TreeSet::new)<br>

## Default Methods
Java 8 introduces a new concept of default method implementation in interfaces. This capability is added for backward compatibility so that old interfaces can be used to leverage the lambda expression capability of Java 8.

For example, ‘List’ or ‘Collection’ interfaces do not have ‘forEach’ method declaration. Thus, adding such method will simply break the collection framework implementations. Java 8 introduces default method so that List/Collection interface can have a default implementation of forEach method, and the class implementing these interfaces need not implement the same.

Multiple Defaults
With default functions in interfaces, there is a possibility that a class is implementing two interfaces with same default methods. The following code explains how this ambiguity can be resolved.<br>

First solution is to create an own method that overrides the default implementation.<br>
Second solution is to call the default method of the specified interface using super.<br>

## What is Stream?
Stream represents a sequence of objects from a source, which supports aggregate operations. Following are the characteristics of a Stream −

Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.

Source − Stream takes Collections, Arrays, or I/O resources as input source.

Aggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.

Pipelining − Most of the stream operations return stream itself so that their result can be pipelined. These operations are called intermediate operations and their function is to take input, process them, and return output to the target. collect() method is a terminal operation which is normally present at the end of the pipelining operation to mark the end of the stream.

Automatic iterations − Stream operations do the iterations internally over the source elements provided, in contrast to Collections where explicit iteration is required.

With Java 8, Collection interface has two methods to generate a Stream.

stream() − Returns a sequential stream considering collection as its source.
parallelStream() − Returns a parallel Stream considering collection as its source.
```java
//distinct string
		List<String> names = Arrays.asList("abc", "abc", "bc", "efg", "abcd","bc", "jkl","efg");
		names = names.stream().distinct().collect(Collectors.toList());
		System.out.println("distinct names: " + names);
            
//sort using java 8
            Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
```
```java
Syntex Eg:
stream()
    .intemediateOperation1()
    .intemediateOperation2()
    ...
    .intemediateOperationN()
    .terminalOperation();
```
#### Stream Creation
```java
//Let’s first obtain a stream from an existing array:
private static Employee[] arrayOfEmps = {
    new Employee(1, "Jeff Bezos", 100000.0), 
    new Employee(2, "Bill Gates", 200000.0), 
    new Employee(3, "Mark Zuckerberg", 300000.0)
};
Stream.of(arrayOfEmps);

//We can also obtain a stream from an existing list:
private static List<Employee> empList = Arrays.asList(arrayOfEmps);
empList.stream();

//Note that Java 8 added a new stream() method to the Collection interface.
//And we can create a stream from individual objects using Stream.of():
Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);

//Or simply using Stream.builder():
Stream.Builder<Employee> empStreamBuilder = Stream.builder();
empStreamBuilder.accept(arrayOfEmps[0]);
empStreamBuilder.accept(arrayOfEmps[1]);
empStreamBuilder.accept(arrayOfEmps[2]);
Stream<Employee> empStream = empStreamBuilder.build();
```

### Intermediate Operations
filter(Predicate<T>)<br>
```java
    Integer[] empIds = { 1, 2, 3, 4 };
    List<Employee> employees = Stream.of(empIds)
      .map(employeeRepository::findById)
      .filter(e -> e != null)
      .filter(e -> e.getSalary() > 200000)
      .collect(Collectors.toList());
```
map(Function<T>)<br>
```java
    Integer[] empIds = { 1, 2, 3 };
    List<Employee> employees = Stream.of(empIds)
      .map(employeeRepository::findById)
      .collect(Collectors.toList());
```
flatmap(Function<T>)<br>
```java
    List<List<String>> namesNested = Arrays.asList( 
      Arrays.asList("Jeff", "Bezos"), 
      Arrays.asList("Bill", "Gates"), 
      Arrays.asList("Mark", "Zuckerberg"));

    List<String> namesFlatStream = namesNested.stream()
      .flatMap(Collection::stream)
      .collect(Collectors.toList());
```
sorted(Comparator<T>)<br>
```java
List<Employee> employees = empList.stream()
      .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
      .collect(Collectors.toList());
```
peek(Consumer<T>)<br>
```java
   empList.stream()
      .peek(e -> e.salaryIncrement(10.0))
      .peek(System.out::println)
      .collect(Collectors.toList());
```
distinct()<br>
```java
List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
```
limit(long n)<br>
skip(long n)<br>
	
### Terminal Operations
forEach<br>
```java
empList.stream().forEach(e -> e.salaryIncrement(10.0));
```
forEachOrdered<br>
toArray<br>
```java
Employee[] employees = empList.stream().toArray(Employee[]::new);
```
reduce<br>
A reduction operation (also called as fold) takes a sequence of input elements and combines them into a single summary result by repeated application of a combining operation. We already saw few reduction operations like findFirst(), min() and max().<br>
```java
    Double sumSal = empList.stream()
      .map(Employee::getSalary)
      .reduce(0.0, Double::sum);
```
collect<br>
```java
List<Employee> employees = empList.stream().collect(Collectors.toList());
```
min<br>
```java
Employee firstEmp = empList.stream()
      .min((e1, e2) -> e1.getId() - e2.getId())
      .orElseThrow(NoSuchElementException::new);
```
max<br>
```java
Employee maxSalEmp = empList.stream()
      .max(Comparator.comparing(Employee::getSalary))
      .orElseThrow(NoSuchElementException::new);
```
count<br>

### Short Circuiting Terminal Operations
anyMatch<br>
allMatch<br>
noneMatch<br>
```java
    List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
    boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
    boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
    boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
```
findFirst<br>
```java
    Integer[] empIds = { 1, 2, 3, 4 };
    Employee employee = Stream.of(empIds)
      .map(employeeRepository::findById)
      .filter(e -> e != null)
      .filter(e -> e.getSalary() > 100000)
      .findFirst()
      .orElse(null);
```
findAny<br>
### Creation
The most common way of creating an IntStream is to call mapToInt() on an existing stream:
```java
Integer latestEmpId = empList.stream()
      .mapToInt(Employee::getId)
      .max()
      .orElseThrow(NoSuchElementException::new);
 //We can also use IntStream.of() for creating the IntStream:
 IntStream.of(1, 2, 3);
 // or IntStream.range():
 IntStream.range(10, 20) // which creates IntStream of numbers 10 to 19.
 ```
 ### Specialized Operations
 Specialized streams provide additional operations as compared to the standard Stream – which are quite convenient when dealing with numbers.<br>
For example sum(), average(), range() etc:<br>
```java
Double avgSal = empList.stream()
      .mapToDouble(Employee::getSalary)
      .average()
      .orElseThrow(NoSuchElementException::new);
```
joining<br>
```java
//Collectors.joining() will insert the delimiter between the two String elements of the stream. It internally uses a 
// java.util.StringJoiner to perform the joining operation.
String empNames = empList.stream()
      .map(Employee::getName)
      .collect(Collectors.joining(", "))
      .toString();
```
toSet<br>
```java
//We can also use toSet() to get a set out of stream elements:
Set<String> empNames = empList.stream()
     .map(Employee::getName)
     .collect(Collectors.toSet());
```
toCollection<br>
```java
//We can use Collectors.toCollection() to extract the elements into any other collection by passing in a Supplier<Collection>. 
//We can also use a constructor reference for the Supplier:
Vector<String> empNames = empList.stream()
    .map(Employee::getName)
    .collect(Collectors.toCollection(Vector::new));
```
summarizingDouble<br>
```java
//summarizingDouble() is another interesting collector – which applies a double-producing 
//mapping function to each input element and returns a special class containing statistical 
//information for the resulting values:
DoubleSummaryStatistics stats = empList.stream()
  .collect(Collectors.summarizingDouble(Employee::getSalary));
  
//summaryStatistics() can be used to generate similar result when we’re using one of the specialized streams:
	DoubleSummaryStatistics stats = empList.stream()
	.mapToDouble(Employee::getSalary)
	.summaryStatistics();
```
partitioningBy<br>
```java
//We can partition a stream into two – based on whether the elements satisfy certain criteria or not.
//Let’s split our List of numerical data, into even and ods:
	List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
	Map<Boolean, List<Integer>> isEven = intList.stream().collect(
	Collectors.partitioningBy(i -> i % 2 == 0));
```
groupingBy<br>
```java
//groupingBy() offers advanced partitioning – where we can partition the stream into more than just two groups.
//It takes a classification function as its parameter. This classification function is applied to each element of the stream.
//The value returned by the function is used as a key to the map that we get from the groupingBy collector:
	Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
	Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));
```
mapping<br>
```java
//groups elements of the stream with the use of a Map.
	Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
	Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
	Collectors.mapping(Employee::getId, Collectors.toList())));
//Here mapping() maps the stream element Employee into just the employee id – 
//which is an Integer – using the getId() mapping function. 
//These ids are still grouped based on the initial character of employee first name.
```
reducing<br>
```java
//reducing() is similar to reduce() – which we explored before. 
//It simply returns a collector which performs a reduction of its input elements:

	Double percentage = 10.0;
	Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
	0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));
//Here reducing() gets the salary increment of each employee and returns the sum.
//reducing() is most useful when used in a multi-level reduction, downstream of groupingBy() or partitioningBy(). 
//To perform a simple reduction on a stream, use reduce() instead.
//For example, let’s see how we can use reducing() with groupingBy():	
	Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);
	Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(
	Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
	Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
```
### Parallel Streams
Using the support for parallel streams, we can perform stream operations in parallel without having to write any boilerplate code; we just have to designate the stream as parallel:<br>
```java
   Employee[] arrayOfEmps = {
      new Employee(1, "Jeff Bezos", 100000.0), 
      new Employee(2, "Bill Gates", 200000.0), 
      new Employee(3, "Mark Zuckerberg", 300000.0)
    };
    List<Employee> empList = Arrays.asList(arrayOfEmps);
    empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));   
```
As is the case with writing multi-threaded code, we need to be aware of few things while using parallel streams:<br>

We need to ensure that the code is thread-safe. Special care needs to be taken if the operations performed in parallel modifies shared data.<br>
We should not use parallel streams if the order in which operations are performed or the order returned in the output stream matters. For example operations like findFirst() may generate the different result in case of parallel streams.<br>
Also, we should ensure that it is worth making the code execute in parallel. Understanding the performance characteristics of the operation in particular, but also of the system as a whole – is naturally very important here.<br>

### Infinite Streams
Sometimes, we might want to perform operations while the elements are still getting generated. We might not know beforehand how many elements we’ll need. Unlike using list or map, where all the elements are already populated, we can use infinite streams, also called as unbounded streams.<br>
There are two ways to generate infinite streams:<br>
1. generate <br>
We provide a Supplier to generate() which gets called whenever new stream elements need to be generated:<br>
```java
Stream.generate(Math::random)
      .limit(5)
      .forEach(System.out::println);
```
Here, we pass Math::random() as a Supplier, which returns the next random number.<br>
With infinite streams, we need to provide a condition to eventually terminate the processing. One common way of doing this is using limit(). In above example, we limit the stream to 5 random numbers and print them as they get generated.<br>
Please note that the Supplier passed to generate() could be stateful and such stream may not produce the same result when used in parallel.<br>
2. iterate<br>
iterate() takes two parameters: an initial value, called seed element and a function which generates next element using the previous value. iterate(), by design, is stateful and hence may not be useful in parallel streams:<br>
```java
    Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
    List<Integer> collect = evenNumStream
      .limit(5)
      .collect(Collectors.toList());
```
Here, we pass 2 as the seed value, which becomes the first element of our stream. This value is passed as input to the lambda, which returns 4. This value, in turn, is passed as input in the next iteration.<br>
This continues until we generate the number of elements specified by limit() which acts as the terminating condition.<br>

### File Operations
1. File Write Operation <br>
```java
   String[] words = {
      "hello", 
      "refer",
      "world",
      "level"
    };
    
    try (PrintWriter pw = new PrintWriter(
      Files.newBufferedWriter(Paths.get(fileName)))) {
        Stream.of(words).forEach(pw::println);
    }
//Here we use forEach() to write each element of the stream into the file by calling PrintWriter.println().    
```
2. File Read Operation <br>
```java
List<String> str = getPalindrome(Files.lines(Paths.get(fileName)), 5);
private List<String> getPalindrome(Stream<String> stream, int length) {
    return stream.filter(s -> s.length() == length)
      .filter(s -> s.compareToIgnoreCase(
        new StringBuilder(s).reverse().toString()) == 0)
      .collect(Collectors.toList());
}
//Here Files.lines() returns the lines from the file as a Stream which is consumed by the getPalindrome() for further processing.
//getPalindrome() works on the stream, completely unaware of how the stream was generated. 
```

## Optional Class
Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
Some Method & Description: 
1. static <T> Optional<T> empty()  = Returns an empty Optional instance.
2. boolean equals(Object obj) = Indicates whether some other object is "equal to" this Optional.
3. T get() = If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
4. void ifPresent(Consumer<? super T> consumer) = If a value is present, it invokes the specified consumer with the value, otherwise does nothing.
5. boolean isPresent() = Returns true if there is a value present, otherwise false.
6. static <T> Optional<T> of(T value) = Returns an Optional with the specified present non-null value.
7. static <T> Optional<T> ofNullable(T value) = Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional etc.
8. T orElse(T other) = Returns the value if present, otherwise returns other.

##  Nashorn JavaScript
With Java 8, Nashorn, a much improved javascript engine is introduced, to replace the existing Rhino. Nashorn provides 2 to 10 times better performance, as it directly compiles the code in memory and passes the bytecode to JVM. Nashorn uses invoke dynamics feature, introduced in Java 7 to improve performance.
### jjs
For Nashorn engine, JAVA 8 introduces a new command line tool, jjs, to execute javascript codes at console.
Command = C:\JAVA>jjs sample.js
Calling JavaScript from Java : Using ScriptEngineManager, JavaScript code can be called and interpreted in Java.
Calling Java from JavaScript : sample.js:
```java
      var BigDecimal = Java.type('java.math.BigDecimal');
      function calculate(amount, percentage) {
         var result = new BigDecimal(amount).multiply(new BigDecimal(percentage)).divide(
            new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);
         return result.toPlainString();
      }
      var result = calculate(568000000000000000023,13.9);
      print(result);
```

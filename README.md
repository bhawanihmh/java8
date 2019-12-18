# java8
Java 8 Examples

## For Java programming, Java SE 8 offers a plethora of features. Some of them are

Lambda expression − Adds functional processing capability to Java.

Method references − Referencing functions by their names instead of invoking them directly. Using functions as parameter.

Default method − Interface to have default method implementation.

New tools − New compiler tools and utilities are added like ‘jdeps’ to figure out dependencies.

Stream API − New stream API to facilitate pipeline processing.

Date Time API − Improved date time API.

Optional − Emphasis on best practices to handle null values properly.

Nashorn, JavaScript Engine − A Java-based engine to execute JavaScript code.

ForEach() Method - In order to iterate over the Collection Framework, Java SE8 offers a new method called forEach which is defined in the Iterable interface. ForEach() loop can be used in a collection class that extends the interface Iterable. Since this method inputs a single parameter, a lambda expression can also be passed as a parameter.

StringJoiner - A new final class StringJoiner has been added to Java 8 in the java. util package. A sequence of characters can be constructed separated by delimiters like comma (,), hyphen (-), etc.

## Security Enhancements
In addition to these features, several other Security Enhancements are also done to Java SE8. They are:

The Public Key Cryptography Standards 11 (PKCS) has been extended to comprise 64-bit supports for the Operating system, Windows.

For UNIX platforms, two new implementations have been presented. It offers blocking and non-blocking behavior.

In SunJCE provider, AES and PBE algorithms such as PBEWithSHA256AndAES_128 and PBEWithSHA512AndAES_256 are also added.

Java SE 8 supports the Server Name Indication (SNI) extension that extends the TLS/SSL protocols to connect during handshaking for supporting server applications.

## Functional interfaces
Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a single method ‘compareTo’ is used for comparison purpose. Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. Following is the list of functional interfaces defined in java.util.Function package.

### Consumer<T>
Represents an operation that accepts a single input argument and returns no result.
### Supplier<T>
Represents a supplier of results.
### Function<T,R>
Represents a function that accepts one argument and produces a result.
### Predicate<T>
Represents a predicate (Boolean-valued function) of one argument.
### BinaryOperator<T>
Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
### UnaryOperator<T>
Represents an operation on a single operand that produces a result of the same type as its operand.

## Default Methods
Java 8 introduces a new concept of default method implementation in interfaces. This capability is added for backward compatibility so that old interfaces can be used to leverage the lambda expression capability of Java 8.

For example, ‘List’ or ‘Collection’ interfaces do not have ‘forEach’ method declaration. Thus, adding such method will simply break the collection framework implementations. Java 8 introduces default method so that List/Collection interface can have a default implementation of forEach method, and the class implementing these interfaces need not implement the same.

Multiple Defaults
With default functions in interfaces, there is a possibility that a class is implementing two interfaces with same default methods. The following code explains how this ambiguity can be resolved.

First solution is to create an own method that overrides the default implementation.

Second solution is to call the default method of the specified interface using super.

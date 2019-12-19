package core.optional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String args[]) {
		OptionalTest java8Tester = new OptionalTest();
		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);
		System.out.println("a = " + a);

		// Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		System.out.println("b = " + b);
		System.out.println(java8Tester.sum(a, b));
		
		// Optional.of - throws NullPointerException if passed parameter is null
		b = Optional.of(value1);
		System.out.println("b = " + b);
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		// Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returns
		// the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}
}

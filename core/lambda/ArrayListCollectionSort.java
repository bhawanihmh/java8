package core.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListCollectionSort {

	public static void main(String[] args) {
		ArrayListCollectionSort tester = new ArrayListCollectionSort();
		List<String> names = new ArrayList<String>();
		names.add("Mahesh ");
		names.add("Suresh ");
		names.add("Ramesh ");
		names.add("Naresh ");
		names.add("Kalpesh ");
		System.out.println(names);
		tester.sortUsingJava8(names);
		System.out.println(names);
	}

	// sort using java 8
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

}

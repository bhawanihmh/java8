package core;

public class ReverseNumber {

	public static void main(String[] args) {
		int n = 123, rev = 0;
		System.out.println("n = " + n);
		System.out.println("rev = " + rev);
		while (n != 0) {
			int letter = n % 10;
			System.out.println("n % 10 = letter = " + letter);
			rev = rev * 10 + letter;
			System.out.println("rev * 10 + letter = rev = " + rev);
			n=n/10;
			System.out.println("n/10 = n = " + n);
			System.out.println(" ===================== ");
			
		}
		System.out.println(rev);
	}

}

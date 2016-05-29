package livAnne;


import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String eingabe = "";
		do {
			eingabe = scanner.next();
			System.out.println(eingabe);
		} while (!"q".equals(eingabe));
		scanner.close();
	}
}

import java.util.Scanner;
public class UVA12577 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x = in.nextLine();
		int z = 1;
		do {
			System.out.println((x.equals("Hajj")) ? ("Case " + z++ + ": Hajj-e-Akbar") : ("Case " + z++ + ": Hajj-e-Asghar"));
			x = in.nextLine();
		} while (!x.equals("*"));
	}
}
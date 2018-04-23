import java.util.Scanner;
public class UVA11727 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			if ((y <= x && x <= z) || (z <= x && x <= y)) System.out.println("Case " + i + ": " + x);
			else if ((x <= y && y <= z) || (z <= y && y <= x)) System.out.println("Case " + i + ": " + y);
			else if ((x <= z && z <= y) || (y <= z && z <= x)) System.out.println("Case " + i + ": " + z);
		}
	}
}
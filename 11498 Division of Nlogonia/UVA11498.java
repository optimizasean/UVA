import java.util.Scanner;

public class UVA11498 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int K = in.nextInt();
			if (K == 0) break;
			int N = in.nextInt();
			int M = in.nextInt();
			while (K-- > 0) {
				int x = in.nextInt();
				int y = in.nextInt();
				if (x == N || y == M) {
					System.out.println("divisa");
				}
				else if (x > N) {
					if (y > M) {
						System.out.println("NE");
					}
					else{
						System.out.println("SE");
					}
				}
				else {
					if (y > M) {
						System.out.println("NO");
					}
					else {
						System.out.println("SO");
					}
				}
			}
		}
	}
}
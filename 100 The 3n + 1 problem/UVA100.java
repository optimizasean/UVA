import java.util.Scanner;
public class UVA100 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			int top, bot;
			if (b > a) {
				top = b;
				bot = a;
			}
			else {
				top = a;
				bot = b;
			}
			int count = 1;
			int max = Integer.MIN_VALUE;
			while (top >= bot) {
				int n = top--;
				//count = 1;
				while (!(n == 1)) {
					if (n % 2 == 0) n = n / 2;
					else n = 3 * n + 1;
					count++;
				}
				max = Math.max(max, count);
				count = 1;
			}
			System.out.println(a + " " + b + " " + max);
		}
	}
}
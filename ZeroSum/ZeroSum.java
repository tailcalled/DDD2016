import java.util.Scanner;

public class ZeroSum {

	private static int n;
	private static char[] chars;
	static boolean ok = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		chars = "1 2 3 4 5 6 7 8 9".substring(0, 2 * n - 1).toCharArray();
		solve(0, 0, 1);
		if (ok) System.out.println(0);
	}

	private static void solve(int i, int sum, int prev) {
		if (i == n - 1) {
			if (sum + prev == 0) {
				System.out.println(chars);
				ok = false;
			}
		}
		else {
			chars[2*i+1] = ' ';
			if (prev < 0) {
				solve(i+1, sum, 10 * prev - i - 2);
			}
			else {
				solve(i+1, sum, 10 * prev + i + 2);
			}
			chars[2*i+1] = '+';
			solve(i+1, sum + prev, i + 2);
			chars[2*i+1] = '-';
			solve(i+1, sum + prev, -i - 2);
		}
	}

}

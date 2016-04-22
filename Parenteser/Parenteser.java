import java.util.Scanner;

/*
4
1 1
1 1
1 1
1 1

JA

3
5 5
3 3
1 1

JA

3
5 5
3 3
2 2

NEJ

3
1 5
1 3
1 1

NEJ
 */
public class Parenteser {

	static int[] lowers;
	static int[] uppers;
	static int[][] cache;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		lowers = new int[in.nextInt()];
		uppers = new int[lowers.length];
		cache = new int[lowers.length][lowers.length + 1];
		for (int i = 0; i < lowers.length; i++) {
			for (int j = 0; j < lowers.length + 1; j++) {
				cache[i][j] = -1;
			}
			lowers[i] = in.nextInt();
			uppers[i] = in.nextInt();
		}
		System.out.println(solve(0, lowers.length) != 0? "JA" : "NEJ");
	}

	private static int solve(int first, int end) {
		if (first == end) return 1;
		if (cache[first][end] == -1) {
			int n = 0;
			for (int open = first + 1; open <= end; open++) {
				int length = 2 * (open - first) - 1;
				if (lowers[first] > length || uppers[first] < length) continue;
				int a = solve(first + 1, open);
				int b = solve(open, end);
				if (a * b == 0) continue;
				if (a * b > 1) {
					n = 2;
					break;
				}
				if (a * b == 1) {
					n++;
					if (n > 1) break;
					continue;
				}
				throw new RuntimeException(a + " " + b);
			}
			cache[first][end] = n;
		}
		if (first == 0 && end == lowers.length)
			System.err.println(cache[first][end]);
		return cache[first][end];
	}

}

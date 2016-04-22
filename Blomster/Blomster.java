import java.util.Scanner;

/*
Input:
3 5
7 23 -5 -24 16
5 21 -4 10 23
-21 5 -4 -20 20

Output:
53
2 4 5
 */
public class Blomster {

	static int[][] table;
	static int[][] worthCache;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int F = in.nextInt(), V = in.nextInt();
		table = new int[F][V];
		worthCache = new int[F][V];
		for (int j = 0; j < F; j++) {
			for (int i = 0; i < V; i++) {
				table[j][i] = in.nextInt();
				worthCache[j][i] = Integer.MIN_VALUE;
			}
		}
		System.out.println(solve(0, 0));
		extract(0, 0);
	}

	private static int solve(int flower, int vase) {
		if (flower == table.length) return 0;
		if (vase == table[0].length) return Integer.MIN_VALUE/2;
		if (worthCache[flower][vase] == Integer.MIN_VALUE) {
			int best = Integer.MIN_VALUE/2;
			for (int v = vase; v < table[0].length; v++) {
				best = Math.max(best, table[flower][v] + solve(flower + 1, v + 1));
			}
			worthCache[flower][vase] = best;
		}
		return worthCache[flower][vase];
	}

	private static void extract(int flower, int vase) {
		int best = 0;
		int bestWorth = Integer.MIN_VALUE;
		for (int v = vase; v < table[0].length; v++) {
			if (bestWorth <= solve(flower, v)) {
				best = v;
				bestWorth = solve(flower, v);
			}
		}
		System.out.print((best + 1) + " ");
		if (best + 1 < table[0].length) {
			extract(flower + 1, best + 1);
		}
	}

}

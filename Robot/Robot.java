import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robot {
	
	static String[] map;
	private static int[][] cache;
	private static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new String[n];
		for (int i = 0; i < n; i++) {
			map[i] = in.readLine();
		}
		cache = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cache[i][j] = -1;
			}
		}
		int solved = solve(0, 0);
		if (solved >= 0)
			System.out.println(solved);
		else
			System.out.println("umuligt");
	}

	private static int solve(int i, int j) {
		if (i == n || j == n) return Integer.MIN_VALUE;
		if (map[i].charAt(j) == 'X') return Integer.MIN_VALUE;
		int p = map[i].charAt(j) == 'P'? 1 : 0;
		if (i == n - 1 && j == n - 1) {
			return p;
		}
		if (cache[i][j] == -1) {
			cache[i][j] = p + solve(i + 1, j);
			cache[i][j] = Math.max(cache[i][j], p + solve(i, j + 1));
		}
		return cache[i][j];
	}

}

import java.util.Scanner;

/*

Input:
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

Output:
30

 */

public class Triangle {
	
	static int[][] tri;
	static int[][] cache;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		tri = new int[n][n]; cache = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col <= row; col++) {
				tri[col][row] = in.nextInt();
				cache[col][row] = -1;
			}
		}
		System.out.println(solve(0, 0));
	}

	private static int solve(int x, int y) {
		if (y == tri.length) return 0;
		if (cache[x][y] == -1) {
			cache[x][y] = tri[x][y] + Math.max(solve(x, y+1), solve(x+1, y+1));
		}
		return cache[x][y];
	}

}

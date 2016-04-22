import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

In:
3 5
10 4
6 2
7 3

Out:
13

 */
public class Knapsack {

	static int S;
	static int[] itemWeight;
	static int[] itemWorth;
	static int[][] cache;
	static int best;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tok.nextToken()); S = Integer.parseInt(tok.nextToken());
		itemWeight = new int[n]; itemWorth = new int[n];
		for (int i = 0; i < n; i++) {
			String[] parts = in.readLine().split(" ");
			itemWorth[i] = Integer.parseInt(parts[0]);
			itemWeight[i] = Integer.parseInt(parts[1]);
		}
		cache = new int[n][S];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < S; j++) {
				cache[i][j] = -1;
			}
		}
		System.out.println(solve(0, 0));
	}

	private static int solve(int curr, int used) {
		if (used > S) return Integer.MIN_VALUE;
		if (used == S) return 0;
		if (curr == itemWeight.length) return 0;
		if (cache[curr][used] == -1) {
			cache[curr][used] = solve(curr+1, used);
			cache[curr][used] = Math.max(cache[curr][used], solve(curr+1, used+itemWeight[curr])+itemWorth[curr]);
		}
		return cache[curr][used];
	}

}

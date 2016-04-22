import java.util.Scanner;

/*

3 1
130

44




3 2
130

4
 */

public class Plusser {
	
	static String number;
	static int k;
	static long[][] cache;
	static long[][] modCache;
	static final long infinity = 100000007;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextInt(); k = in.nextInt();
		number = in.next().trim();
		cache = new long[k+1][number.length()];
		for (int i = 0; i < k+1; i++) {
			for (int j = 0; j < number.length(); j++) {
				cache[i][j] = -1;
			}
		}
		modCache = new long[k+2][number.length()];
		for (int i = 0; i < k+2; i++) {
			for (int j = 0; j < number.length(); j++) {
				modCache[i][j] = -1;
			}
		}
		System.out.println(solve(0, 0));
	}

	private static long solve(int plus, int start) {
		if (cache[plus][start] == -1) {
			if (plus == k) {
				long res = 0;
				for (int i = start; i < number.length(); i++) {
					res *= 10;
					res += number.charAt(i) - '0';
					res %= infinity;
				}
				cache[plus][start] = res;
			}
			else {
				long num = 0;
				long res = 0L;
				boolean ok = false;
				for (int split = start; split < number.length() - 1; split++) {
					num *= 10;
					num += number.charAt(split) - '0';
					num %= infinity;
					long q = solve(plus + 1, split + 1);
					if (q != -2) {
						long x = num * modChoose(k - plus - 1, number.length() - split - 1) % infinity;
						res += (x + q) % infinity;
						res %= infinity;
						ok = true;
					}
				}
				if (ok) cache[plus][start] = res;
				else cache[plus][start] = -2;
			}
		}
		return cache[plus][start] % infinity;
	}

	private static long modChoose(int amount, int from) {
		if (amount == 0) return 1;
		if (from == 0) return 0;
		if (modCache[amount][from] == -1) {
			long ways = 0;
			for (int drop = 1; drop < from; drop++) {
				ways += modChoose(amount - 1, from - drop);
				ways %= infinity;
			}
			modCache[amount][from] = ways;
		}
		return modCache[amount][from] % infinity;
	}

}

import java.util.Scanner;

/*

7 4 3
5
1001110
1110110
1001100
1001110
1000100


16
4
15
3
4
0
 */
public class BarCodes {

	private static int n;
	private static int m;
	private static int k;
	private static long[][][] cacheCBC;
	private static int[] barLength;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		cacheCBC = new long[34][34][34];
		for (int i = 0; i < 34; i++) for (int j = 0; j < 34; j++) for (int k = 0; k < 34; k++) {
			cacheCBC[i][j][k] = -1;
		}
		n = in.nextInt(); k = in.nextInt(); m = in.nextInt();
		System.out.println(cbc(n, k, m));
		int s = in.nextInt();
		barLength = new int[k];
		for (int i = 0; i < s; i++) {
			String bc = in.next();
			char c = '1';
			int l = 0, b = 0;
			for (int j = 0; j < n; j++, l++) {
				if (bc.charAt(j) != c) {
					barLength[b++] = l;
					l = 0;
					c = (char) (1 + '0' - c + '0');
				}
			}
			barLength[b] = l;
			System.out.println(cSFT(0, n));
		}
	}
	
	/*
	 * Cardinality of the set of barcodes before barLength[i:]
	 */
	private static long cSFT(int i, int remaining) {
		if (i == barLength.length) return 0;
		long cSF = 0;
		for (int first = 1; first < barLength[i]; first++) {
			cSF += cbc(remaining - first, k - i - 1, m);
		}
		cSF += cSST(i + 1, remaining - barLength[i]);
		return cSF;
	}

	private static long cSST(int i, int remaining) {
		return cbc(remaining, k - i, m) - 1 - cSFT(i, remaining);
	}

	public static long cbc(int n, int k, int m) {
		if (n < 0) return 0;
		if (k == 0) {
			if (n == 0) return 1;
			else return 0;
		}
		if (cacheCBC[n][k][m] == -1) {
			long q = 0;
			for (int i = 1; i <= m; i++) {
				q += cbc(n - i, k - 1, m);
			}
			cacheCBC[n][k][m] = q;
		}
		return cacheCBC[n][k][m];
	}

}

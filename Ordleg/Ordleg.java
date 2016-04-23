import java.util.Scanner;

public class Ordleg {
	
	static String s1, s2;
	static int[][] cost;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		s1 = in.next(); s2 = in.next();
		int n = in.nextInt();
		cost = new int['z' - 'a' + 1]['z' - 'a' + 1];
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost.length; j++) {
				cost[i][j] = i == j? 0 : -1;
			}
		}
		for (int i = 0; i < n; i++) {
			String c1 = in.next(), c2 = in.next();
			int x = in.nextInt();
			if (cost[c1.charAt(0) - 'a'][c2.charAt(0) - 'a'] == -1 || cost[c1.charAt(0) - 'a'][c2.charAt(0) - 'a'] > x)
				cost[c1.charAt(0) - 'a'][c2.charAt(0) - 'a'] = x;
		}
		for (int i = 0; i < cost.length; i++) {
			int[][] newCost = new int['z' - 'a' + 1]['z' - 'a' + 1];
			for (int j = 0; j < cost.length; j++) {
				for (int k = 0; k < cost.length; k++) {
					int jk = cost[j][k], ji = cost[j][i], ik = cost[i][k];
					if (ji == -1 || ik == -1) {
						newCost[j][k] = jk;
					}
					else if (jk == -1) {
						newCost[j][k] = ji + ik;
					}
					else if (jk < ji + ik) {
						newCost[j][k] = jk;
					}
					else {
						newCost[j][k] = ji + ik;
					}
				}
			}
			cost = newCost;
		}
		char[][] mid = new char['z' - 'a' + 1]['z' - 'a' + 1];
		int[][] midCost = new int['z' - 'a' + 1]['z' - 'a' + 1];
		for (int i = 0; i < mid.length; i++) {
			for (int k = 0; k < mid.length; k++) {
				int best = Integer.MAX_VALUE;
				char bestChar = '\0';
				for (int j = 0; j < mid.length; j++) {
					int j2 = cost[i][j];
					int j3 = cost[k][j];
					if (j2 != -1 && j3 != -1 && best > j2 + j3) {
						best = j2 + j3;
						bestChar = (char) (j + 'a');
					}
				}
				midCost[i][k] = best;
				mid[i][k] = bestChar;
			}
		}
		StringBuilder res = new StringBuilder();
		int c = 0;
		for (int i = 0; i < s1.length(); i++) {
			int best = midCost[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'];
			char bestChar = mid[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'];
			c += best;
			res.append(bestChar);
			if (bestChar == '\0') {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(c);
		System.out.println(res);
	}

}

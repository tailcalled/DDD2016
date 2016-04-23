import java.util.ArrayList;
import java.util.Scanner;

/*
4 3
1 2
2 3
3 1

umuligt

5 4
1 2
2 3
3 4
4 1

jubi
+
-
+
-
+
 */
public class Magneter {

	static ArrayList<Integer>[] neigh;
	static char[] magnets;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		neigh = new ArrayList[n];
		for (int i = 0; i < n; i++) neigh[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1;
			neigh[a].add(b);
			neigh[b].add(a);
		}
		magnets = new char[n];
		for (int i = 0; i < n; i++) {
			if (magnets[i] == '\0' && !good(i, true)) {
				System.out.println("umuligt");
				return;
			}
		}
		System.out.println("jubi");
		for (int i = 0; i < n; i++) System.out.println(magnets[i]);
	}

	private static boolean good(int node, boolean plus) {
		char c = plus? '+' : '-';
		if (magnets[node] == c) return true;
		if (magnets[node] != '\0') return false;
		magnets[node] = c;
		for (int i: neigh[node]) {
			if (!good(i, !plus)) return false;
		}
		return true;
	}

}

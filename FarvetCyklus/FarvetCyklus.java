import java.util.ArrayList;
import java.util.Scanner;

/*

3 3 1
1
1
1
1 2
2 3
3 1

JA

4 4 2
1
2
1
1
1 2
2 3
3 4
4 1

NEJ

 */
public class FarvetCyklus {

	static int n, m, k;
	static ArrayList<Integer>[] nodes;
	static int[] color;
	private static boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		nodes = new ArrayList[n];
		for (int i = 0; i < n; i++) nodes[i] = new ArrayList<>();
		color = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			color[i] = in.nextInt() - 1;
		}
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1;
			nodes[a].add(b);
			nodes[b].add(a);
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[j] && tryAt(j, j)) { System.out.println("JA"); return; }
			}
		}
		System.out.println("NEJ");
	}

	private static boolean tryAt(int current, int previous) {
		visited[current] = true;
		for (int i : nodes[current]) {
			if (i == previous) continue;
			if (color[i] != color[current]) continue;
			if (visited[i]) return true;
			if (tryAt(i, current)) return true;
		}
		return false;
	}

}

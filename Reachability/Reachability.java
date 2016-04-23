import java.util.Scanner;

/*
4 3 1 2
1 3
2 4
3 4

JA


5 4 1 5
1 2
2 3
3 1
4 5

NEJ
 */
public class Reachability {

	static int[] parent;
	
	static int find(int n) {
		if (parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}
	static void union(int a, int b) {
		parent[find(a)] = find(b);
		find(a);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt(), u = in.nextInt(), v = in.nextInt();
		parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) parent[i] = i;
		for (int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt();
			union(a, b);
		}
		if (find(u) == find(v)) System.out.println("JA");
		else System.out.println("NEJ");
	}

}

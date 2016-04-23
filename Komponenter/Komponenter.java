import java.util.ArrayList;
import java.util.Scanner;

/*
6 5
1 2
2 3
1 4
3 4
4 2

3 4


7 4
1 5
5 6
2 3
3 7

3 3
 */
public class Komponenter {

	static ArrayList<Integer>[] edges;
	static boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		edges = new ArrayList[in.nextInt()];
		visited = new boolean[edges.length];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new ArrayList<>();
		}
		int m = in.nextInt();
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1;
			edges[a].add(b);
			edges[b].add(a);	
		}
		int biggest = 0, amount = 0;
		for (int n = 0; n < visited.length; n++) {
			if (!visited[n]) {
				amount++;
				int x = examine(n);
				if (biggest < x) {
					biggest = x;
				}
			}
		}
		System.out.println(amount + " " + biggest);
	}

	private static int examine(int n) {
		if (visited[n]) return 0;
		visited[n] = true;
		int res = 1;
		for (int f: edges[n]) {
			res += examine(f);
		}
		return res;
	}

}

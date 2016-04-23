import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
3 3 1 3
1 2 1
2 3 1
1 3 2

2


5 5 1 5
1 2 3
1 3 4
2 3 1
2 4 2
5 1 1

-1
 */
public class Afstand {
	
	static ArrayList<Integer>[] neigh;
	static ArrayList<Integer>[] weight;
	static int[] dist;
	
	static class Call implements Comparable<Call> {
		
		int node, dist;

		@Override
		public int compareTo(Call o) {
			return Integer.compare(dist, o.dist);
		}
		
	}
	
	static PriorityQueue<Call> calls = new PriorityQueue<Call>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt(), u = in.nextInt(), v = in.nextInt();
		n++;
		neigh = new ArrayList[n]; weight = new ArrayList[n];
		dist = new int[n];
		for (int i = 0; i < n; i++) {
			neigh[i] = new ArrayList<>();
			weight[i] = new ArrayList<>();
			dist[i] = -1;
		}
		for (int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt();
			neigh[a].add(b);
			weight[a].add(in.nextInt());
		}
		Call c = new Call();
		c.dist = 0;
		c.node = u;
		calls.add(c);
		while (!calls.isEmpty()) {
			c = calls.poll();
			int d = c.dist, x = c.node;
			if (dist[x] == -1) {
				dist[x] = d;
				for (int i = 0; i < neigh[x].size(); i++) {
					c = new Call();
					c.dist = d + weight[x].get(i);
					c.node = neigh[x].get(i);
					calls.add(c);
				}
			}
		}
		System.out.println(dist[v]);
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Katapulter {

	static ArrayList<Integer>[] neigh;
	static ArrayList<Integer>[] weight;
	static int[] dist;
	static int[] targets;
	static int[] ranges;
	
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
		int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
		neigh = new ArrayList[n + 1]; weight = new ArrayList[n + 1];
		dist = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			neigh[i] = new ArrayList<>();
			weight[i] = new ArrayList<>();
			dist[i] = -1;
		}
		Call c = new Call();
		c.dist = 0;
		c.node = 1;
		calls.add(c);
		for (int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt(), d = in.nextInt();
			neigh[a].add(b);
			weight[a].add(d);
			neigh[b].add(a);
			weight[b].add(d);
		}
		targets = new int[k];
		ranges = new int[k];
		for (int i = 0; i < k; i++) {
			targets[i] = in.nextInt();
			ranges[i] = in.nextInt();
			c = new Call();
			c.dist = ranges[i];
			c.node = targets[i];
			calls.add(c);
		}
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
		System.err.println(Arrays.toString(dist));
		int removable = 0;
		for (int i = 0; i < k; i++) {
			int x = targets[i];
			int d = dist[x];
			if (d < ranges[i]) {
				removable++;
				continue;
			}
			for (int j = 0; j < neigh[x].size(); j++) {
				if (d == weight[x].get(j) + dist[neigh[x].get(j)]) {
					removable++;
					break;
				}
			}
		}
		System.out.println(removable);
	}

}

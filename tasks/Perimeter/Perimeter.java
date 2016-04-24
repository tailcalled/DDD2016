import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/*

10
1 16 2 2
2 7
10 6
2 3 2 2
1 7
8 3
3 3 2 1
8 2
4
4 8 1 3
3
9 10 5
5 8 3 1
9 10 4
6
6 6 1 2
5
1 10
7 5 2 2
1 2
8 9
8 4 2 2
2 3
7 9
9 5 2 3
7 8
4 5 10
10 10 2 3
1 6
4 9 5


12
 */
public class Perimeter {
	
	static HashSet<Integer>[] side1, side2;
	static int[] length;
	
	static class Call implements Comparable<Call> {
		
		int previous;
		int fence;
		int traversed;
		
		@Override
		public int compareTo(Call o) {
			return Integer.compare(traversed, o.traversed);
		}
		
	}
	
	static PriorityQueue<Call> calls;
	static int[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		length = new int[n];
		side1 = new HashSet[n];
		side2 = new HashSet[n];
		for (int i = 0; i < n; i++) {
			int id = in.nextInt() - 1;
			length[id] = in.nextInt();
			int s1 = in.nextInt(), s2 = in.nextInt();
			side1[id] = new HashSet<>();
			side2[id] = new HashSet<>();
			for (int j = 0; j < s1; j++) side1[id].add(in.nextInt() - 1);
			for (int j = 0; j < s2; j++) side2[id].add(in.nextInt() - 1);
		}
		int best = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			visited = new int[n];
			for (int j = 0; j < n; j++) visited[j] = -1;
			calls = new PriorityQueue<>();
			for (int j: side1[i]) {
				Call c = new Call();
				c.fence = j;
				c.previous = i;
				c.traversed = length[j];
				calls.add(c);
			}
			while (!calls.isEmpty() && visited[i] == -1) {
				Call c = calls.poll();
				int j = c.fence;
				int p = c.previous;
				int d = c.traversed;
				if (visited[j] != -1 && visited[j] >= d) continue;
				visited[j] = d;
				HashSet<Integer> ns = (side1[j].contains(p)? side2[j] : side1[j]);
				for (int x: ns) {
					Call q = new Call();
					q.fence = x;
					q.previous = j;
					q.traversed = d + length[x];
					calls.add(q);
				}
			}
			if (best > visited[i]) {
				best = visited[i];
			}
		}
		System.out.println(best);
	}

}

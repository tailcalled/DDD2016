import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tidsafstand {

	static class Call implements Comparable<Call> {
		
		int arrivalTime;
		int node;
		
		@Override
		public int compareTo(Call o) {
			return Integer.compare(arrivalTime, o.arrivalTime);
		}
		
	}
	
	static int[] lowerClose;
	static int[] upperClose;
	static ArrayList<Integer>[] nis;
	static ArrayList<Integer>[] tis;
	
	static PriorityQueue<Call> calls;
	static int[] res;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt(), u = in.nextInt() - 1, v = in.nextInt() - 1;
		nis = new ArrayList[n];
		tis = new ArrayList[n];
		lowerClose = new int[n];
		upperClose = new int[n];
		res = new int[n];
		for (int i = 0; i < n; i++) {
			nis[i] = new ArrayList<>();
			tis[i] = new ArrayList<>();
			lowerClose[i] = in.nextInt();
			upperClose[i] = in.nextInt();
			res[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1, d = in.nextInt();
			nis[a].add(b);
			tis[a].add(d);
		}
		Call start = new Call();
		start.node = u;
		start.arrivalTime = 0;
		calls = new PriorityQueue<>();
		calls.add(start);
		while(!calls.isEmpty() && res[v] == Integer.MAX_VALUE) {
			Call c = calls.poll();
			int node = c.node;
			int now = c.arrivalTime;
			if (res[node] <= now) continue;
			res[node] = now;
			if (lowerClose[node] <= now) now = Math.max(upperClose[node], now);
			for (int i = 0; i < nis[node].size(); i++) {
				Call rec = new Call();
				rec.node = nis[node].get(i);
				rec.arrivalTime = now + tis[node].get(i);
				calls.add(rec);
			}
		}
		if (res[v] == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(res[v]);
	}

}

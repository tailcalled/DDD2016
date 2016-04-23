import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
17389 27449

3
17489
17449
27449


59359 37813

7
39359
32359
32369
37369
37363
37313
37813
 */
public class Primtal {

	static Queue<Integer> as, bs, cs, ds, es, t;
	static int[][][][][] visited = new int[10][10][10][10][10];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int p1 = input.nextInt(), p2 = input.nextInt();
		for (int[][][][] a: visited) for (int[][][] b: a) for (int[][] c: b) for (int[] d: c) for (int i = 0; i < 10; i++) {
			d[i] = -2;
		}
		as = new LinkedList<>();
		bs = new LinkedList<>();
		cs = new LinkedList<>();
		ds = new LinkedList<>();
		es = new LinkedList<>();
		t = new LinkedList<>();
		int a = p1 % 10, b = (p1 / 10) % 10, c = (p1 / 100) % 10, d = (p1 / 1000) % 10, e = (p1 / 10000) % 10;
		as.add(a); bs.add(b); cs.add(c); ds.add(d); es.add(e); t.add(0);
		int aT = p2 % 10, bT = (p2 / 10) % 10, cT = (p2 / 100) % 10, dT = (p2 / 1000) % 10, eT = (p2 / 10000) % 10;
		while (!as.isEmpty() && visited[aT][bT][cT][dT][eT] == -2) {
			a = as.poll(); b = bs.poll(); c = cs.poll(); d = ds.poll(); e = es.poll();
			int time = t.poll();
			int p = a + b * 10 + c * 100 + d * 1000 + e * 10000;
			if (!isPrime(p)) continue;
			if (visited[a][b][c][d][e] != -2) continue;
			visited[a][b][c][d][e] = time;
			for (int x = 0; x < 10; x++) {
				if (x != 0) {
				as.add(a); bs.add(b); cs.add(c); ds.add(d); es.add(x); t.add(time + 1);
				}
				as.add(a); bs.add(b); cs.add(c); ds.add(x); es.add(e); t.add(time + 1);
				as.add(a); bs.add(b); cs.add(x); ds.add(d); es.add(e); t.add(time + 1);
				as.add(a); bs.add(x); cs.add(c); ds.add(d); es.add(e); t.add(time + 1);
				as.add(x); bs.add(b); cs.add(c); ds.add(d); es.add(e); t.add(time + 1);
			}
		}
		System.out.println(visited[aT][bT][cT][dT][eT]);
		ArrayList<Integer> path = new ArrayList<>();
		loop: while (aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000 != p1) {
			for (int x = 0; x < 10; x++) {
				if (visited[x][bT][cT][dT][eT] + 1 == visited[aT][bT][cT][dT][eT]) {
					path.add(aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000);
					aT = x; continue loop;
				}
				if (visited[aT][x][cT][dT][eT] + 1 == visited[aT][bT][cT][dT][eT]) {
					path.add(aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000);
					bT = x; continue loop;
				}
				if (visited[aT][bT][x][dT][eT] + 1 == visited[aT][bT][cT][dT][eT]) {
					path.add(aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000);
					cT = x; continue loop;
				}
				if (visited[aT][bT][cT][x][eT] + 1 == visited[aT][bT][cT][dT][eT]) {
					path.add(aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000);
					dT = x; continue loop;
				}
				if (visited[aT][bT][cT][dT][x] + 1 == visited[aT][bT][cT][dT][eT]) {
					path.add(aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000);
					eT = x; continue loop;
				}
			}
			throw new RuntimeException((aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000) + "");
		}
//		path.add(aT + bT * 10 + cT * 100 + dT * 1000 + eT * 10000);
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.println(path.get(i));
		}
	}
	
	public static boolean isPrime(int k) {
		for (int i = 2; i * i <= k; i++) {
			if (k % i == 0) return false;
		}
		return true;
	}
	
}

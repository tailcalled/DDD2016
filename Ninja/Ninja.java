import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
1 5
0

4

1 5
1 5

umuligt

2 4
1 2
0

umuligt

5 8
2 7 8
6 1 2 3 8 7 4
3 5 6 7
2 4 3
0

17
 */
public class Ninja {
	
	static int[][] visitedTime;
	static Queue<Integer> pole;
	static Queue<Integer> height;
	static Queue<Integer> time;
	
	static boolean[][] inaccessible;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		inaccessible = new boolean[in.nextInt()][in.nextInt()];
		visitedTime = new int[inaccessible.length][inaccessible[0].length];
		for (int i = 0; i < inaccessible.length; i++) {
			int spike = in.nextInt();
			for (int j = 0; j < spike; j++) {
				inaccessible[i][in.nextInt() - 1] = true;
			}
		}
		for (int[] i: visitedTime) for (int j = 0; j < i.length; j++) i[j] = -1;
		pole = new LinkedList<>(); height = new LinkedList<>(); time = new LinkedList<>();
		pole.add(0);
		height.add(0);
		time.add(0);
		while (!pole.isEmpty()) {
			int p = pole.poll();
			int h = height.poll();
			int t = time.poll();
			if (p < 0 || p >= inaccessible.length) continue;
			if (h < 0 || h >= inaccessible[0].length) continue;
			if (visitedTime[p][h] != -1) continue;
			if (inaccessible[p][h]) continue;
			visitedTime[p][h] = t;
			pole.add(p); height.add(h+1); time.add(t+1);
			pole.add(p); height.add(h-1); time.add(t+1);
			pole.add(p+1); height.add(h-1); time.add(t+1);
			pole.add(p-1); height.add(h-1); time.add(t+1);
		}
		int best = Integer.MAX_VALUE;
		for (int[] pole: visitedTime) {
			if (pole[pole.length - 1] != -1) best = Math.min(best, pole[pole.length - 1]);
		}
		if (best == Integer.MAX_VALUE) {
			System.out.println("umuligt");
		}
		else {
			System.out.println(best);
		}
	}

}

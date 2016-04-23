import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

5 4 1
1 2
2 3
2 4
2 5

3 2

9 8 1
1 2
2 3
2 4
3 4
4 5
4 6
6 7
8 9

2 2
 */
public class Epidemi {

	static ArrayList<Integer>[] friends;
	static Queue<Integer> infectedDay;
	static Queue<Integer> infectedPerson;
	
	static boolean[] infected;
	static int[] dayCount;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt(), z = in.nextInt() - 1;
		friends = new ArrayList[n];
		for (int i = 0; i < n; i++) friends[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1;
			friends[a].add(b);
			friends[b].add(a);
		}
		infected = new boolean[n];
		dayCount = new int[n];
		infectedDay = new LinkedList<>();
		infectedPerson = new LinkedList<>();
		infectedDay.add(0);
		infectedPerson.add(z);
		while (!infectedDay.isEmpty()) {
			int d = infectedDay.poll();
			int p = infectedPerson.poll();
			if (!infected[p]) {
				infected[p] = true;
				for (int f: friends[p]) {
					infectedDay.add(d + 1);
					infectedPerson.add(f);
				}
				dayCount[d]++;
			}
		}
		int max = 0, maxDay = 0;
		for (int i = 0; i < n && dayCount[i] > 0; i++) {
			if (max < dayCount[i]) {
				max = dayCount[i];
				maxDay = i;
			}
		}
		System.out.println(max + " " + maxDay);
	}

}

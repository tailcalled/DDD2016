import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*

300 4
100 60
250 120
120 100
35 20

605

 */

public class Score {

	private static ArrayList<Category> cats;

	static class Category implements Comparable<Category> {
		
		int time; long score;

		@Override
		public int compareTo(Category o) {
			return Long.compare(time * o.score, o.time * score);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt(), n = in.nextInt();
		cats = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Category c = new Category();
			c.score = in.nextLong();
			c.time = in.nextInt();
			cats.add(c);
		}
		Collections.sort(cats);
		long[] scoreByUsedTime = new long[m + 1];
		for (Category c: cats) {
			for (int time = c.time; time <= m; time++) {
				scoreByUsedTime[time] = Math.max(scoreByUsedTime[time], scoreByUsedTime[time - c.time] + c.score);
			}
		}
		long best = 0;
		for (long x: scoreByUsedTime) if (best < x) best = x;
		System.out.println(best);
	}

}

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
		System.out.println(solve(0, m, 0, 0));
	}

	private static long solve(int cat, int time, long score, long bestSoFar) {
		if (cat == cats.size()) return score;
		Category c = cats.get(cat);
		if (score * c.time + time * c.score < bestSoFar * c.time) {
			return 0; //score + time * c.score;
		}
		long best = 0;
		if (time >= c.time) {
			long include = solve(cat, time - c.time, score + c.score, bestSoFar);
			if (best < include) best = include;
		}
		long skip = solve(cat + 1, time, score, Math.max(bestSoFar, best));
		if (best < skip) {
			best = skip;
		}
		return best;
	}

}

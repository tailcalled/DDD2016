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
		
		int time, score;

		@Override
		public int compareTo(Category o) {
			return Integer.compare(time * o.score, o.time * score);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt(), n = in.nextInt();
		cats = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Category c = new Category();
			c.score = in.nextInt();
			c.time = in.nextInt();
			cats.add(c);
		}
		Collections.sort(cats);
		System.out.println(solve(0, m, 0, 0));
	}

	private static int solve(int cat, int time, int score, int bestSoFar) {
		if (cat == cats.size()) return score;
		Category c = cats.get(cat);
		if (score + time * c.score < c.time * bestSoFar) {
			return 0; //score + time * c.score;
		}
		int best = 0;
		if (time >= c.time) {
			int include = solve(cat, time - c.time, score + c.score, bestSoFar);
			if (best < include) best = include;
		}
		int skip = solve(cat + 1, time, score, Math.max(bestSoFar, best));
		if (best < skip) {
			best = skip;
		}
		return best;
	}

}

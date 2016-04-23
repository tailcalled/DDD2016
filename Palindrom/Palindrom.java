import java.util.Scanner;

/*

5
Ab3bd


2

 */
public class Palindrom {

	static String s;
	static int[][] cache;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextInt();
		s = in.next();
		cache = new int[s.length() + 3][s.length() + 3];
		for (int[] i: cache) for (int j = 0; j < i.length; j++) i[j] = -1;
		System.out.println(solve(0, s.length()));
	}

	private static int solve(int start, int end) {
		if (start + 1 == end || start == end) return 0;
		if (cache[start][end] == -1) {
			int res = Integer.MAX_VALUE;
			if (s.charAt(start) == s.charAt(end - 1)) {
				res = Math.min(res, solve(start + 1, end - 1));
			}
			res = Math.min(res, solve(start + 1, end) + 1);
			res = Math.min(res, solve(start, end - 1) + 1);
			cache[start][end] = res;
		}
		return cache[start][end];
	}

}

import java.util.Scanner;

/*

Sample Input:
8 6
Sample Output:
5599888

Sample Input:
4 4
Sample Output:
260

*/

public class Loebere {

	static int n;
	static int k;
	
	public static int code(int x, int y) {
		int a = x - y + 7;
		int b = x + y;
		return 1 << b | 1 << (a + 15);
	}
	public static int x(int field) {
		return field % n;
	}
	public static int y(int field) {
		return field / n;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt(); k = in.nextInt();
		System.out.println(solve(0, 0, 0));
	}
	
	public static long solve(int state, int count, int field) {
		if (count == k) return 1L;
		long res = 0L;
		for (int place = field; place < n*n; place++) {
			int c = code(x(place), y(place));
			if ((c & state) == 0) {
				res += solve(state | c, count + 1, place + 1);
			}
		}
		return res;
	}

}

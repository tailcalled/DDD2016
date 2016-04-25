import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*

8 9
Vancouver
Yellowknife
Edmonton
Calgary
Winnipeg
Toronto
Montreal
Halifax
Vancouver Edmonton
Vancouver Calgary
Calgary Winnipeg
Winnipeg Toronto
Toronto Halifax
Montreal Halifax
Edmonton Montreal
Edmonton Yellowknife
Edmonton Calgary

7

5 5
C1
C2
C3
C4
C5
C5 C4
C2 C3
C3 C1
C4 C1
C5 C2

NO SOLUTION

 */
public class Itinerary {

	static HashMap<String, Integer> nameToNum;
	static String[] numToName;
	static ArrayList<Integer>[] flights;
	static int[][] visits;
	static int n;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		nameToNum = new HashMap<>();
		numToName = new String[n];
		for (int i = 0; i < n; i++) {
			String name = in.next();
			nameToNum.put(name, i);
			numToName[i] = name;
		}
		flights = new ArrayList[n];
		for (int i = 0; i < n; i++) flights[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = nameToNum.get(in.next()), b = nameToNum.get(in.next());
			if (a < b) {
				flights[a].add(b);
			}
			else flights[b].add(a);
		}
		visits = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visits[i][j] = -1;
			}
		}
		System.out.println(n);
		int length = findVisits(0, 0);
		System.out.println(length);
	}

	private static int findVisits(int start, int end) {
		if (start == end && end == n - 1) {
			return 1;
		}
		if (visits[start][end] == -1) {
			int best = -2;
			for (int childA: flights[start]) {
				for (int childB: flights[end]) {
					if (childA == childB && childA != n - 1) continue;
					int visited = findVisits(childA, childB);
					if (visited == -2) continue;
					if (start == end) visited += 1;
					else visited += 2;
					best = Math.max(best, visited);
				}
			}
			visits[start][end] = best;
		}
		return visits[start][end];
	}

}

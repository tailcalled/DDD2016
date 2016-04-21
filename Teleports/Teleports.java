import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/*
Testdata:

4 5
3 5 2 5
4 4 4 1 3

might yield

0110
10110

 */

public class Teleports {

	static int nB, nG;
	static int[] tB, tG;
	static int[] pG;
	static boolean[] sB, sG;
	static Set<Integer> check;
	
	public static void main(String[] args) {
		input();
		solve();
		output();
	}

	private static void input() {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		nB = in.nextInt(); nG = in.nextInt();
		tB = new int[nB]; tG = new int[nG];
		sB = new boolean[nB]; sG = new boolean[nG];
		for (int i = 0; i < nB; i++) {
			tB[i] = in.nextInt() - 1;
			sB[i] = true;
		}
		for (int i = 0; i < nG; i++) {
			tG[i] = in.nextInt() - 1;
			sG[i] = false;
		}
	}

	private static void output() {
		for (int i = 0; i < nB; i++) {
			System.out.print(sB[i]? "1" : "0");
		}
		System.out.println();
		for (int i = 0; i < nG; i++) {
			System.out.print(sG[i]? "1" : "0");
		}
		System.out.println();
	}
	
	private static boolean step() {
		boolean done = true;
		Set<Integer> g = check;
		check = new TreeSet<Integer>();
		for (int i: g) {
			if (!sG[i] && pG[i] == 0) {
				done = false;
				sG[i] = true;
				if (sB[tG[i]]) {
					sB[tG[i]] = false;
					pG[tB[tG[i]]]--;
					check.add(tB[tG[i]]);
				}
			}
		}
		return !done;
	}
	private static void solve() {
		pG = new int[nG];
		check = new TreeSet<Integer>();
		for (int i = 0; i < nB; i++) {
			pG[tB[i]]++;
		}
		for (int i = 0; i < nG; i++) {
			check.add(i);
		}
		while (step());
	}

}

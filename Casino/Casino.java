import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
Testdata:

13 12 8 3
14 13 12 11 10 8 7 4

Might yield:
(not really - the example is broken according to the host)

13
12
8
12 1
11 1
8 4
7 1
8 4 1
7 4 1
13 12 1
13 8 4 1
13 12 8 4 1
12 11 1
12 8 4
12 7 4 1
8 7 1
12 11 1 8 4
8 7 1

 */

public class Casino {
	
	static ArrayList<Integer> hand, table;
	static ArrayList<Integer> cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader lineIn = new BufferedReader(new InputStreamReader(System.in));
		hand = readCards(lineIn);
		table = readCards(lineIn);
		cards = new ArrayList<>(hand); cards.addAll(table);
		for (int i = 0; i < hand.size(); i++) {
			solve(0, i, hand.get(i));
		}
	}
	
	static ArrayList<Integer> chosen = new ArrayList<>();

	private static void solve(int current, int skip, int target) {
		if (target == 0) {
			for (int i: chosen) System.out.print(i + " ");
			System.out.println();
			return;
		}
		else if (current < cards.size()) {
			solve(current + 1, skip, target);
			if (current != skip && target >= cards.get(current)) {
				chosen.add(cards.get(current));
				solve(current + 1, skip, target - cards.get(current));
				chosen.remove(chosen.size() - 1);
			}
		}
	}

	private static ArrayList<Integer> readCards(BufferedReader lineIn) throws IOException {
		Scanner in = new Scanner(lineIn.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		while (in.hasNext()) {
			int i = in.nextInt();
			if (i == 14) i = 1;
			list.add(i);
		}
		return list;
	}

}

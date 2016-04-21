import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Testdata:

13 12 8 3
14 13 12 11 10 8 7 4

Might yield:

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
	static ArrayList<ArrayList<Integer>> combos;
	
	public static void main(String[] args) throws IOException {
		BufferedReader lineIn = new BufferedReader(new InputStreamReader(System.in));
		hand = new ArrayList<>();
		readCards(lineIn, hand);
		table = new ArrayList<>();
		readCards(lineIn, table);
		combos = new ArrayList<>();
		
	}

	private static void readCards(BufferedReader lineIn, ArrayList<Integer> list) throws IOException {
		StringTokenizer in = new StringTokenizer(lineIn.readLine());
		while (in.hasMoreTokens()) {
			String tok = in.nextToken();
			switch (tok) {
			case "A": list.add(null); break;
			case "K": list.add(13); break;
			case "Q": list.add(12); break;
			case "J": list.add(11); break;
			default: list.add(Integer.parseInt(tok)); break;
			}
		}
	}

}

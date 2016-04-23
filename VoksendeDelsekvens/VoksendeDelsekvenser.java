import java.util.Scanner;
import java.util.TreeMap;

/*
5
3 8 5 3 2

3

5
1 1 2 2 2

0
 */
public class VoksendeDelsekvenser {

	private static final int infinity = 1000001;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, Integer> lengthByEndSize = new TreeMap<>();
		lengthByEndSize.put(0, 0);
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int length = lengthByEndSize.floorEntry(x).getValue() + 1;
			lengthByEndSize.put(x, length);
			for (Integer key = lengthByEndSize.higherKey(x); key != null; key = lengthByEndSize.higherKey(key)) {
				if (lengthByEndSize.get(key) <= length) lengthByEndSize.remove(key);
			}
		}
		int top = lengthByEndSize.get(lengthByEndSize.lastKey());
		System.out.println(n - top);
	}

}

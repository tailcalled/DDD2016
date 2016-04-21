import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*

Input:

2
7 3 2
8 2 5
2
1 7 3 5
2 7 1 8 2 10

Output:
14

 */

public class Shop {

	static int[] nameToNumber = new int[1000];
	static int[] target;
	static int[] offers;
	static int[] offerPrice;
	
	public static Integer pack(int[] nums) {
		int res = 0;
		for (int i: nums) {
			if (i < 0 || i > 5) return null;
			res *= 6; res += i;
		}
		return res;
	}
	public static int[] unpack(int packed) {
		int[] res = new int[5];
		for (int i = 4; i >= 0; i--) {
			res[i] = packed % 6;
			packed /= 6;
		}
		return res;
	}
	public static Integer subtract(int basket, int offer) {
		int[] baskets = unpack(basket), offers = unpack(offer);
		for (int i = 0; i < 5; i++) {
			baskets[i] -= offers[i];
		}
		return pack(baskets);
	}
	
	static int[][] price;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("INPUT.TXT"));
		int b = in.nextInt();
		int[] prices = new int[b], amounts = new int[5];
		for (int i = 0; i < b; i++) {
			nameToNumber[in.nextInt()] = i;
			amounts[i] = in.nextInt();
			prices[i] = in.nextInt();
		}
		int basket = pack(amounts);
		in = new Scanner(new File("OFFER.TXT"));
		offers = new int[in.nextInt() + b];
		offerPrice = new int[offers.length];
		for (int i = 0; i < b; i++) {
			int[] primitive = new int[5];
			primitive[i] = 1;
			offers[i] = pack(primitive);
			offerPrice[i] = prices[i];
		}
		for (int i = b; i < offers.length; i++) {
			int nWares = in.nextInt();
			int[] offer = new int[5];
			for (int w = 0; w < nWares; w++) {
				offer[nameToNumber[in.nextInt()]] += in.nextInt();
			}
			offerPrice[i] = in.nextInt();
			offers[i] = pack(offer);
		}
		price = new int[6*6*6*6*6*6][offers.length];
		if (offers.length == 0) System.out.println("0");
		else System.out.println(solve(basket, 0));
	}
	private static int solve(int basket, int offer) {
		if (offer == offers.length) return Integer.MAX_VALUE / 2;
		if (basket == 0) return 0;
		if (price[basket][offer] == 0) {
			int p = solve(basket, offer + 1);
			Integer subbed = subtract(basket, offers[offer]);
			if (subbed != null) {
				p = Math.min(p, offerPrice[offer] + solve(subbed, offer));
			}
			price[basket][offer] = p;
		}
		return price[basket][offer];
	}

}

import java.util.Scanner;

public class Superprimtal {

	static boolean[] nonPrime;
	static int n;
	static int k;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = 1;
		for (int i = 0; i < n; i++) k *= 10;
		nonPrime = new boolean[k];
		nonPrime[1-1] = false;
		for (int p = 2; p < k; p++) {
			if (!nonPrime[p-1]) {
				for (int i = 2; i * p < k; i++) {
					nonPrime[i * p - 1] = true;
				}
			}
		}
	}

}

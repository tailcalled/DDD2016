import java.util.Scanner;

public class Superprimtal {

	static boolean[] superPrime;
	static int n;
	static int k;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = 1;
		for (int i = 0; i < n; i++) k *= 10;
		superPrime = new boolean[k];
		superPrime[1-1] = true;
		for (int p = 2; p < k; p++) {
			if (!superPrime[p-1]) {
				for (int i = 2; i * p < k; i++) {
					superPrime[i * p - 1] = true;
				}
			}
		}
		superPrime[1-1] = false;
		for (int p = 2; p < 10; p++) {
			superPrime[p-1] = !superPrime[p-1];
		}
		for (int p = 10; p < k; p++) {
			superPrime[p-1] = superPrime[(p/10) - 1] && !superPrime[p-1];
		}
		for (int p = k/10; p < k; p++) {
			if (superPrime[p-1]) {
				System.out.println(p);
			}
		}
	}

}

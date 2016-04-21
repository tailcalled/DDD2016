import java.math.BigInteger;
import java.util.Scanner;

public class FarvedeStaenger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt() - 1;
		BigInteger h = BigInteger.ONE, a = BigInteger.valueOf(2);
		for (int i = 0; i < n; i++) {
			BigInteger nH = a, nA = (h.add(a)).multiply(BigInteger.valueOf(2));
			h = nH; a = nA;
		}
		System.out.println(h.add(a));
	}

}

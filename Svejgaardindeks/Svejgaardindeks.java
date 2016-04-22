import java.util.Scanner;

/*
ACMKF19M1XSPZ
HZ1IXBVR

2
 */

public class Svejgaardindeks {
	
	static String l1, l2;
	static int[][] svejgaardcache;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		l1 = in.nextLine();
		l2 = in.nextLine();
		svejgaardcache = new int[l1.length()][l2.length()];
		for (int[] i: svejgaardcache) {
			for (int j = 0; j < i.length; j++) i[j] = -1;
		}
		System.out.println(svejgaard(0, 0));
	}

	private static int svejgaard(int i, int j) {
		if (i == l1.length() || j == l2.length()) return 0;
		if (svejgaardcache[i][j] == -1) {
			svejgaardcache[i][j] = Math.max(svejgaardcache[i][j], svejgaard(i+1, j));
			svejgaardcache[i][j] = Math.max(svejgaardcache[i][j], svejgaard(i, j+1));
			if (l1.charAt(i) == l2.charAt(j))
			svejgaardcache[i][j] = Math.max(svejgaardcache[i][j], svejgaard(i+1, j+1)+1);
		}
		return svejgaardcache[i][j];
	}
	
}

import java.util.Scanner;

/*

3 3
vhh
ono


NEJ

4 5
vhvh
nnono

JA

 */
public class EnsrettedeVeje {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextInt(); in.nextInt();
		String s = in.next();
		char a = s.charAt(0), b = s.charAt(s.length() - 1);
		s = in.next();
		char c = s.charAt(0), d = s.charAt(s.length() - 1);
		if (a == 'v' && b == 'h' && c == 'n' && d == 'o') {
			System.out.println("JA");
		}
		else if (a == 'h' && b == 'v' && c == 'o' && d == 'n') {
			System.out.println("JA");
		}
		else {
			System.out.println("NEJ");
		}
	}

}

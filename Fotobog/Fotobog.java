import java.util.Scanner;

public class Fotobog {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long photos = input.nextLong();
		int pages = 0;
		while (photos > 0) {
			pages++;
			photos--;
			if (photos % 2 == 0) photos /= 2;
		}
		System.out.println(pages);
	}

}

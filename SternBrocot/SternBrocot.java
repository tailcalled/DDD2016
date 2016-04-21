import java.util.Scanner;

/*

Input:
878 323

Output:
RRLRRLRLLLLRLRRR


 */

public class SternBrocot {
	
	public static class Fraction {
		public final long nomin, denom;
		public Fraction(long nom, long den) {
			nomin = nom; denom = den;
		}
		public Fraction sternBrocot(Fraction that) {
			return new Fraction(this.nomin + that.nomin, this.denom + that.denom);
		}
		public boolean le(Fraction that) {
			return this.nomin * that.denom <= that.nomin * this.denom;
		}
		public boolean ne(Fraction that) {
			return !(this.le(that) && that.le(this));
		}
		public static final Fraction Zero = new Fraction(0, 1), One = new Fraction(1, 1), Infinity = new Fraction(1, 0);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction target = new Fraction(in.nextLong(), in.nextLong());
		Fraction low = Fraction.Zero, mid = Fraction.One, high = Fraction.Infinity;
		while (target.ne(mid)) {
			if (target.le(mid)) {
				System.out.print("L");
				high = mid;
				mid = low.sternBrocot(mid);
			}
			else {
				System.out.print("R");
				low = mid;
				mid = mid.sternBrocot(high);
			}
		}
		System.out.println();
	}

}

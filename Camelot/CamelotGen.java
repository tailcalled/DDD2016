public class CamelotGen {
	
	static int[][] dist;
	
	static int pt(int x, int y) {
		return x * 8 + y;
	}
	static int x(int pt) {
		return pt / 8;
	}
	static int y(int pt) {
		return pt % 8;
	}
	
	public static void main(String[] args) {
		dist = new int[8*8][8*8];
		for (int i = 0; i < 8*8; i++) {
			for (int j = 0; j < 8*8; j++) {
				dist[i][j] = Integer.MAX_VALUE/2;
			}
		}
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (x > 0 && y < 8 - 2) dist[pt(x, y)][pt(x - 1, y + 2)] = 1;
				if (y > 0 && x < 8 - 2) dist[pt(x, y)][pt(x + 2, y - 1)] = 1;
				if (x < 8 - 2 && y < 8 - 1) dist[pt(x, y)][pt(x + 2, y + 1)] = 1;
				if (x < 8 - 1 && y < 8 - 2) dist[pt(x, y)][pt(x + 1, y + 2)] = 1;
				if (x == y) dist[pt(x, y)][pt(x, y)] = 0;
			}
		}
		for (int i = 0; i < 8*8; i++) {
			for (int j = 0; j < 8*8; j++) {
				dist[i][j] = Math.min(dist[i][j], dist[j][i]);
			}
		}
		for (int k = 0; k < 8*8; k++) {
			for (int i = 0; i < 8*8; i++) {
				for (int j = 0; j < 8*8; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		System.out.println("{");
		for (int i = 0; i < 8*8; i++) {
			System.out.print("\t{");
			for (int j = 0; j < 8*8; j++) {
				System.out.print(dist[i][j]);
				if (j < 8*8 - 1) System.out.print(",");
			}
			System.out.print("}");
			if (i < 8*8 - 1) System.out.print(",");
			System.out.println();
		}
		System.out.println("}");
	}

}

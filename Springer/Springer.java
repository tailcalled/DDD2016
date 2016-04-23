import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
5 4 2 1 

3 2 1 2 
0 3 2 3 
3 2 1 2 
2 1 4 3 
0 0 0 0 

 */
public class Springer {

	static final int[] dx = {
		-1, -1, -2, -2, 2, 2, 1, 1
	};
	static final int[] dy = {
		2, -2, 1, -1, 1, -1, 2, -2
	};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt(), w = s.nextInt();
		int[][] board = new int[w][h];
		for (int a = 0; a < w; a++) {
			for (int b = 0; b < h; b++) {
				board[a][b] = -1;
			}
		}
		Queue<Integer> xs = new LinkedList<>(), ys = new LinkedList<>(), ms = new LinkedList<>();
		ys.add(s.nextInt() - 1); xs.add(s.nextInt() - 1); ms.add(0);
		while (!xs.isEmpty()) {
			int x = xs.poll();
			int y = ys.poll();
			int m = ms.poll();
			if (x < 0 || x >= w) continue;
			if (y < 0 || y >= h) continue;
			if (board[x][y] != -1) continue;
			board[x][y] = m;
			for (int i = 0; i < dx.length; i++) {
				xs.add(x + dx[i]);
				ys.add(y + dy[i]);
				ms.add(m + 1);
			}
		}
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				System.out.print(board[x][y] + " ");
			}
			System.out.println();
		}
	}

}

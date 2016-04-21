import java.util.Scanner;

/*

4
7
11  6 11  6  3 10  6
 7  9  6 13  5 15  5
 1 10 12  7 13  7  5
13 11 10  8 10 12 13

*/

public class Castle {
	
	static final int West = 1, North = 2, East = 4, South = 8;
	static int w, h;
	static int[][] castle;
	static int[] parent;
	static int[] size;
	
	public static int pt(int x, int y) {
		return x * h + y;
	}
	
	public static int find(int pt) {
		if (parent[pt] == pt) return pt;
		return parent[pt] = find(parent[pt]);
	}
	public static int union(int pt1, int pt2) {
		if ((pt1=find(pt1)) != (pt2=find(pt2))) {
			parent[pt2] = pt1;
			size[pt1] += size[pt2];
		}
		return pt1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		h = in.nextInt(); w = in.nextInt();
		castle = new int[w][h];
		parent = new int[w*h];
		size = new int[w*h];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				castle[x][y] = in.nextInt();
				parent[pt(x, y)] = pt(x, y);
				size[pt(x, y)] = 1;
			}
		}
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (x + 1 < w && (castle[x][y] & East) == 0) {
					union(pt(x, y), pt(x+1, y));
				}
				if (y + 1 < h && (castle[x][y] & South) == 0) {
					union(pt(x, y), pt(x, y+1));
				}
			}
		}
		int nRooms = 0;
		int bigRoom = 0;
		int bigPairX = 0, bigPairY = 0, bigPairDir = 0, bigPair = 0;
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (find(pt(x, y)) == pt(x, y)) {
					nRooms++;
					bigRoom = Math.max(bigRoom, size[find(pt(x, y))]);
				}
				if (x + 1 < w
					&& (castle[x][y] & East) != 0
					&& find(pt(x, y)) != find(pt(x+1, y))
					&& bigPair < size[find(pt(x, y))] + size[find(pt(x+1, y))]) {
					bigPairX = x;
					bigPairY = y;
					bigPairDir = East;
					bigPair = size[find(pt(x, y))] + size[find(pt(x+1, y))];
				}
				if (y + 1 < h
					&& (castle[x][y] & South) != 0
					&& find(pt(x, y)) != find(pt(x, y+1))
					&& bigPair < size[find(pt(x, y))] + size[find(pt(x, y+1))]) {
					bigPairX = x;
					bigPairY = y;
					bigPairDir = South;
					bigPair = size[find(pt(x, y))] + size[find(pt(x, y+1))];
				}
			}
		}
		System.out.println(nRooms);
		System.out.println(bigRoom);
		System.out.println((bigPairY + 1) + " " + (bigPairX + 1) + " " + (bigPairDir == East? "E" : "S"));
	}

}

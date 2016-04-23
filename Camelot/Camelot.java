import java.io.IOException;
import java.util.ArrayList;

/*

D4A3A8H1H8

10

 */
public class Camelot {

	static int[][] data =
		{
				{0,3,2,3,2,3,4,5,3,4,1,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,4,3,4,5,3,4,3,4,3,4,5,4,4,3,4,3,4,5,4,5,5,4,5,4,5,4,5,6},
				{3,2,3,2,3,2,3,4,2,3,2,1,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,4,3,4,4,3,4,3,4,3,4,5,3,4,3,4,3,4,5,4,4,5,4,5,4,5,4,5},
				{2,3,2,3,2,3,2,3,1,2,3,2,1,2,3,4,4,1,2,1,4,3,2,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,4,3,3,4,3,4,3,4,3,4,4,3,4,3,4,3,4,5,5,4,5,4,5,4,5,4},
				{3,2,3,2,3,2,3,2,2,1,2,3,2,1,2,3,3,4,1,2,1,4,3,2,2,3,2,3,2,3,2,3,3,2,3,2,3,2,3,4,4,3,4,3,4,3,4,3,3,4,3,4,3,4,3,4,4,5,4,5,4,5,4,5},
				{2,3,2,3,2,3,2,3,3,2,1,2,3,2,1,2,2,3,4,1,2,1,4,3,3,2,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,4,3,4,3,4,3,4,4,3,4,3,4,3,4,3,5,4,5,4,5,4,5,4},
				{3,2,3,2,3,2,3,2,4,3,2,1,2,3,2,1,3,2,3,4,1,2,1,4,4,3,2,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,4,3,4,3,4,3,5,4,3,4,3,4,3,4,4,5,4,5,4,5,4,5},
				{4,3,2,3,2,3,2,3,3,4,3,2,1,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,4,3,4,3,4,4,5,4,3,4,3,4,3,5,4,5,4,5,4,5,4},
				{5,4,3,2,3,2,3,2,4,3,4,3,2,1,4,3,5,4,3,2,3,4,1,2,4,3,4,3,2,3,2,3,5,4,3,4,3,2,3,2,4,5,4,3,4,3,4,3,5,4,5,4,3,4,3,4,6,5,4,5,4,5,4,5},
				{3,2,1,2,3,4,3,4,2,3,2,3,2,3,4,5,3,2,1,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,4,3,4,5,3,4,3,4,3,4,5,4,4,3,4,3,4,5,4,5},
				{4,3,2,1,2,3,4,3,3,0,3,2,3,2,3,4,2,3,2,1,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,4,3,4,4,3,4,3,4,3,4,5,3,4,3,4,3,4,5,4},
				{1,2,3,2,1,2,3,4,2,3,2,3,2,3,2,3,1,2,3,2,1,2,3,4,4,1,2,1,4,3,2,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,4,3,3,4,3,4,3,4,3,4,4,3,4,3,4,3,4,5},
				{2,1,2,3,2,1,2,3,3,2,3,2,3,2,3,2,2,1,2,3,2,1,2,3,3,4,1,2,1,4,3,2,2,3,2,3,2,3,2,3,3,2,3,2,3,2,3,4,4,3,4,3,4,3,4,3,3,4,3,4,3,4,3,4},
				{3,2,1,2,3,2,1,2,2,3,2,3,2,3,2,3,3,2,1,2,3,2,1,2,2,3,4,1,2,1,4,3,3,2,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,4,3,4,3,4,3,4,4,3,4,3,4,3,4,3},
				{4,3,2,1,2,3,2,1,3,2,3,2,3,2,3,2,4,3,2,1,2,3,2,1,3,2,3,4,1,2,1,4,4,3,2,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,4,3,4,3,4,3,5,4,3,4,3,4,3,4},
				{3,4,3,2,1,2,3,4,4,3,2,3,2,3,2,3,3,4,3,2,1,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,4,3,4,3,4,4,5,4,3,4,3,4,3},
				{4,3,4,3,2,1,2,3,5,4,3,2,3,2,3,2,4,3,4,3,2,1,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,3,2,3,5,4,3,4,3,2,3,2,4,5,4,3,4,3,4,3,5,4,5,4,3,4,3,4},
				{2,1,4,3,2,3,4,5,3,2,1,2,3,4,3,4,2,3,2,3,2,3,4,5,3,2,1,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,4,3,4,5,3,4,3,4,3,4,5,4},
				{1,2,1,4,3,2,3,4,2,3,2,1,2,3,4,3,3,2,3,2,3,2,3,4,2,3,2,1,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,4,3,4,4,3,4,3,4,3,4,5},
				{4,1,2,1,4,3,2,3,1,2,3,2,1,2,3,4,2,3,0,3,2,3,2,3,1,2,3,2,1,2,3,4,4,1,2,1,4,3,2,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,4,3,3,4,3,4,3,4,3,4},
				{3,4,1,2,1,4,3,2,2,1,2,3,2,1,2,3,3,2,3,2,3,2,3,2,2,1,2,3,2,1,2,3,3,4,1,2,1,4,3,2,2,3,2,3,2,3,2,3,3,2,3,2,3,2,3,4,4,3,4,3,4,3,4,3},
				{2,3,4,1,2,1,4,3,3,2,1,2,3,2,1,2,2,3,2,3,2,3,2,3,3,2,1,2,3,2,1,2,2,3,4,1,2,1,4,3,3,2,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,4,3,4,3,4,3,4},
				{3,2,3,4,1,2,1,4,4,3,2,1,2,3,2,1,3,2,3,2,3,2,3,2,4,3,2,1,2,3,2,1,3,2,3,4,1,2,1,4,4,3,2,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,4,3,4,3,4,3},
				{4,3,2,3,4,1,2,1,3,4,3,2,1,2,3,2,4,3,2,3,2,3,2,3,3,4,3,2,1,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,4,3,4,3,4},
				{5,4,3,2,3,4,1,2,4,3,4,3,2,1,2,3,5,4,3,2,3,2,3,2,4,3,4,3,2,1,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,3,2,3,5,4,3,4,3,2,3,2,4,5,4,3,4,3,4,3},
				{3,2,3,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,1,2,3,4,3,4,2,3,2,3,2,3,4,5,3,2,1,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,4,3,4,5},
				{2,3,2,3,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,1,2,3,4,3,3,2,3,2,3,2,3,4,2,3,2,1,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,4,3,4},
				{3,2,3,2,3,2,3,4,4,1,2,1,4,3,2,3,1,2,3,2,1,2,3,4,2,3,2,3,2,3,2,3,1,2,3,2,1,2,3,4,4,1,2,1,4,3,2,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,4,3},
				{2,3,2,3,2,3,2,3,3,4,1,2,1,4,3,2,2,1,2,3,2,1,2,3,3,2,3,0,3,2,3,2,2,1,2,3,2,1,2,3,3,4,1,2,1,4,3,2,2,3,2,3,2,3,2,3,3,2,3,2,3,2,3,4},
				{3,2,3,2,3,2,3,2,2,3,4,1,2,1,4,3,3,2,1,2,3,2,1,2,2,3,2,3,2,3,2,3,3,2,1,2,3,2,1,2,2,3,4,1,2,1,4,3,3,2,3,2,3,2,3,2,4,3,2,3,2,3,2,3},
				{4,3,2,3,2,3,2,3,3,2,3,4,1,2,1,4,4,3,2,1,2,3,2,1,3,2,3,2,3,2,3,2,4,3,2,1,2,3,2,1,3,2,3,4,1,2,1,4,4,3,2,3,2,3,2,3,3,4,3,2,3,2,3,2},
				{3,4,3,2,3,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,1,2,3,2,4,3,2,3,2,3,2,3,3,4,3,2,1,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,3,2,3,2,4,3,4,3,2,3,2,3},
				{4,3,4,3,2,3,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,1,2,3,5,4,3,2,3,2,3,2,4,3,4,3,2,1,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,3,2,3,5,4,3,4,3,2,3,2},
				{2,3,2,3,4,3,4,5,3,2,3,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,1,2,3,4,3,4,2,3,2,3,2,3,4,5,3,2,1,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,3,2,3,4,3,4},
				{3,2,3,2,3,4,3,4,2,3,2,3,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,1,2,3,4,3,3,2,3,2,3,2,3,4,2,3,2,1,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,3,2,3,4,3},
				{2,3,2,3,2,3,4,3,3,2,3,2,3,2,3,4,4,1,2,1,4,3,2,3,1,2,3,2,1,2,3,4,2,3,2,3,2,3,2,3,1,2,3,2,1,2,3,4,4,1,2,1,4,3,2,3,3,2,3,2,3,2,3,4},
				{3,2,3,2,3,2,3,4,2,3,2,3,2,3,2,3,3,4,1,2,1,4,3,2,2,1,2,3,2,1,2,3,3,2,3,2,3,2,3,2,2,1,2,3,2,1,2,3,3,4,1,2,1,4,3,2,2,3,2,3,2,3,2,3},
				{4,3,2,3,2,3,2,3,3,2,3,2,3,2,3,2,2,3,4,1,2,1,4,3,3,2,1,2,3,2,1,2,2,3,2,3,0,3,2,3,3,2,1,2,3,2,1,2,2,3,4,1,2,1,4,3,3,2,3,2,3,2,3,2},
				{3,4,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,2,3,4,1,2,1,4,4,3,2,1,2,3,2,1,3,2,3,2,3,2,3,2,4,3,2,1,2,3,2,1,3,2,3,4,1,2,1,4,4,3,2,3,2,3,2,3},
				{4,3,4,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,1,2,3,2,4,3,2,3,2,3,2,3,3,4,3,2,1,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,3,2,3,2},
				{5,4,3,4,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,1,2,3,5,4,3,2,3,2,3,2,4,3,4,3,2,1,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,3,2,3},
				{3,4,3,4,3,4,5,4,2,3,2,3,4,3,4,5,3,2,3,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,1,2,3,4,3,4,2,3,2,3,2,3,4,5,3,2,1,2,3,4,3,4,2,1,4,3,2,3,4,5},
				{4,3,4,3,4,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,1,2,3,4,3,3,2,3,2,3,2,3,4,2,3,2,1,2,3,4,3,1,2,1,4,3,2,3,4},
				{3,4,3,4,3,4,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,2,3,4,4,1,2,1,4,3,2,3,1,2,3,2,1,2,3,4,2,3,2,3,2,3,2,3,1,2,3,2,1,2,3,4,4,1,2,1,4,3,2,3},
				{4,3,4,3,4,3,4,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,2,3,3,4,1,2,1,4,3,2,2,1,2,3,2,1,2,3,3,2,3,2,3,2,3,2,2,1,2,3,2,1,2,3,3,4,1,2,1,4,3,2},
				{3,4,3,4,3,4,3,4,4,3,2,3,2,3,2,3,3,2,3,2,3,2,3,2,2,3,4,1,2,1,4,3,3,2,1,2,3,2,1,2,2,3,2,3,2,3,2,3,3,2,1,2,3,2,1,2,2,3,4,1,2,1,4,3},
				{4,3,4,3,4,3,4,3,3,4,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,2,3,4,1,2,1,4,4,3,2,1,2,3,2,1,3,2,3,2,3,0,3,2,4,3,2,1,2,3,2,1,3,2,3,4,1,2,1,4},
				{5,4,3,4,3,4,3,4,4,3,4,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,1,2,3,2,4,3,2,3,2,3,2,3,3,4,3,2,1,2,3,2,4,3,2,3,4,1,2,1},
				{4,5,4,3,4,3,4,3,5,4,3,4,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,1,2,3,5,4,3,2,3,2,3,2,4,3,4,3,2,1,2,3,5,4,3,2,3,4,1,2},
				{4,3,4,3,4,5,4,5,3,4,3,4,3,4,5,4,2,3,2,3,4,3,4,5,3,2,3,2,3,4,3,4,2,1,4,3,2,3,4,5,3,2,1,2,3,4,3,4,2,3,2,3,2,3,4,5,3,2,1,2,3,4,3,4},
				{3,4,3,4,3,4,5,4,4,3,4,3,4,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,1,2,3,4,3,3,2,3,2,3,2,3,4,4,3,2,1,2,3,4,3},
				{4,3,4,3,4,3,4,5,3,4,3,4,3,4,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,2,3,4,4,1,2,1,4,3,2,3,1,2,3,2,1,2,3,4,2,3,2,3,2,3,2,3,1,2,3,2,1,2,3,4},
				{3,4,3,4,3,4,3,4,4,3,4,3,4,3,4,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,2,3,3,4,1,2,1,4,3,2,2,1,2,3,2,1,2,3,3,2,3,2,3,2,3,2,2,1,2,3,2,1,2,3},
				{4,3,4,3,4,3,4,3,3,4,3,4,3,4,3,4,4,3,2,3,2,3,2,3,3,2,3,2,3,2,3,2,2,3,4,1,2,1,4,3,3,2,1,2,3,2,1,2,2,3,2,3,2,3,2,3,3,2,1,2,3,2,1,2},
				{5,4,3,4,3,4,3,4,4,3,4,3,4,3,4,3,3,4,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,2,3,4,1,2,1,4,4,3,2,1,2,3,2,1,3,2,3,2,3,2,3,2,4,3,2,1,2,3,2,1},
				{4,5,4,3,4,3,4,3,5,4,3,4,3,4,3,4,4,3,4,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,1,2,3,2,4,3,2,3,2,3,0,3,3,4,3,2,1,2,3,4},
				{5,4,5,4,3,4,3,4,4,5,4,3,4,3,4,3,5,4,3,4,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,1,2,3,5,4,3,2,3,2,3,2,4,3,4,3,2,1,2,3},
				{5,4,5,4,5,4,5,6,4,3,4,3,4,5,4,5,3,4,3,4,3,4,5,4,2,3,2,3,4,3,4,5,3,2,3,2,3,4,3,4,2,1,4,3,2,3,4,5,3,4,1,2,3,4,3,4,2,3,2,3,2,3,4,5},
				{4,5,4,5,4,5,4,5,3,4,3,4,3,4,5,4,4,3,4,3,4,3,4,5,3,2,3,2,3,4,3,4,2,3,2,3,2,3,4,3,1,2,1,4,3,2,3,4,2,3,2,1,2,3,4,3,3,2,3,2,3,2,3,4},
				{5,4,5,4,5,4,5,4,4,3,4,3,4,3,4,5,3,4,3,4,3,4,3,4,2,3,2,3,2,3,4,3,3,2,3,2,3,2,3,4,4,1,2,1,4,3,2,3,1,2,3,2,1,2,3,4,2,3,2,3,2,3,2,3},
				{4,5,4,5,4,5,4,5,3,4,3,4,3,4,3,4,4,3,4,3,4,3,4,3,3,2,3,2,3,2,3,4,2,3,2,3,2,3,2,3,3,4,1,2,1,4,3,2,2,1,2,3,2,1,2,3,3,2,3,2,3,2,3,2},
				{5,4,5,4,5,4,5,4,4,3,4,3,4,3,4,3,3,4,3,4,3,4,3,4,4,3,2,3,2,3,2,3,3,2,3,2,3,2,3,2,2,3,4,1,2,1,4,3,3,2,1,2,3,2,1,2,2,3,2,3,2,3,2,3},
				{4,5,4,5,4,5,4,5,5,4,3,4,3,4,3,4,4,3,4,3,4,3,4,3,3,4,3,2,3,2,3,2,4,3,2,3,2,3,2,3,3,2,3,4,1,2,1,4,4,3,2,1,2,3,2,1,3,2,3,2,3,2,3,2},
				{5,4,5,4,5,4,5,4,4,5,4,3,4,3,4,3,5,4,3,4,3,4,3,4,4,3,4,3,2,3,2,3,3,4,3,2,3,2,3,2,4,3,2,3,4,1,2,1,3,4,3,2,1,2,3,2,4,3,2,3,2,3,2,3},
				{6,5,4,5,4,5,4,5,5,4,5,4,3,4,3,4,4,5,4,3,4,3,4,3,5,4,3,4,3,2,3,2,4,3,4,3,2,3,2,3,5,4,3,2,3,4,1,2,4,3,4,3,2,1,4,3,5,4,3,2,3,2,3,0}
			}

;

	static int pt(int x, int y) {
		return x * 8 + y;
	}
	static int x(int pt) {
		return pt / 8;
	}
	static int y(int pt) {
		return pt % 8;
	}
	
	public static void main(String[] args) throws IOException {
		int kingX, kingY;
		ArrayList<Integer> xs = new ArrayList<Integer>(), ys = new ArrayList<Integer>();
		kingX = System.in.read() - 'A';
		kingY = System.in.read() - '1';
		int ch = '\0';
		while ((ch = System.in.read()) != '\n' && ch != '\r') {
			xs.add(ch - 'A');
			ys.add(System.in.read() - '1');
		}
		int best = Integer.MAX_VALUE;
		for (int pos = 0; pos < 8*8; pos++) {
			int turns = Math.max(Math.abs(kingX - x(pos)), Math.abs(kingY - y(pos)));
			for (int knight = 0; knight < xs.size(); knight++) {
				turns += data[pt(xs.get(knight), ys.get(knight))][pos];
			}
			if (turns < best) {
				best = turns;
			}
		}
		System.out.println(best - 1);
	}

}



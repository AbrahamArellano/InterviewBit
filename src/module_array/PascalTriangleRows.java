package module_array;

import java.util.ArrayList;

/**
 * 
 * 
 * Given numRows, generate the first numRows of Pascal�s triangle.
 * 
 * Pascal�s triangle : To generate A[C] in row R, sum up A�[C] and A�[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Given numRows = 5,
 * 
 * Return
 * 
 * [
 * 
 * [1],
 * 
 * [1,1],
 * 
 * [1,2,1],
 * 
 * [1,3,3,1],
 * 
 * [1,4,6,4,1]
 * 
 * ]
 * 
 * 
 * @author Abraham Arellano
 *
 */
public class PascalTriangleRows {

	public ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();
		if (a == 0) {
			return pascalTriangle;
		}
		if (a >= 1) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(1);
			pascalTriangle.add(row);
		}
		if (a > 1) {
			for (int i = 1; i < a; i++) {
				ArrayList<Integer> row = new ArrayList<>();
				row.add(1);
				ArrayList<Integer> previousRow = pascalTriangle.get(i - 1);
				for (int j = 1; j < i; j++) {
					int newVal = previousRow.get(j) + previousRow.get(j - 1);
					row.add(newVal);
				}
				row.add(1);
				pascalTriangle.add(row);
			}
		}
		return pascalTriangle;
	}

	public static void main(String[] args) {
		PascalTriangleRows r = new PascalTriangleRows();
		final ArrayList<ArrayList<Integer>> generate = r.generate(20);
		System.out.println(generate);
		// System.out.println(
		// "[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10,
		// 10, 5, 1], [1, 6, 15, 20, 15, 6, 1], [1, 7, 21, 35, 35, 21, 7, 1],
		// [1, 8, 28, 56, 70, 56, 28, 8, 1], [1, 9, 36, 84, 126, 126, 84, 36, 9,
		// 1]]");
		System.out.println(
				"[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1], [1, 6, 15, 20, 15, 6, 1], [1, 7, 21, 35, 35, 21, 7, 1], [1, 8, 28, 56, 70, 56, 28, 8, 1], [1, 9, 36, 84, 126, 126, 84, 36, 9, 1], [1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1], [1, 11, 55, 165, 330, 462, 462, 330, 165, 55, 11, 1], [1, 12, 66, 220, 495, 792, 924, 792, 495, 220, 66, 12, 1], [1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1], [1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1], [1, 15, 105, 455, 1365, 3003, 5005, 6435, 6435, 5005, 3003, 1365, 455, 105, 15, 1], [1, 16, 120, 560, 1820, 4368, 8008, 11440, 12870, 11440, 8008, 4368, 1820, 560, 120, 16, 1], [1, 17, 136, 680, 2380, 6188, 12376, 19448, 24310, 24310, 19448, 12376, 6188, 2380, 680, 136, 17, 1], [1, 18, 153, 816, 3060, 8568, 18564, 31824, 43758, 48620, 43758, 31824, 18564, 8568, 3060, 816, 153, 18, 1], [1, 19, 171, 969, 3876, 11628, 27132, 50388, 75582, 92378, 92378, 75582, 50388, 27132, 11628, 3876, 969, 171, 19, 1]]");
	}

}

package module_array;

import java.util.ArrayList;

/**
 * 
 * 
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row
 * and column to 0.
 * 
 * Do it in place.
 * 
 * Example
 * 
 * Given array A as
 * 
 * 1 0 1
 * 
 * 1 1 1
 * 
 * 1 1 1
 * 
 * On returning, the array A should be :
 * 
 * 0 0 0
 * 
 * 1 0 1
 * 
 * 1 0 1
 * 
 * 
 * @author arellaa
 *
 */
public class SetMatrixZeroes {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a == null || a.isEmpty() || a.get(0) == null || a.get(0).isEmpty()) {
			return;
		}

		int m = a.size();
		int n = a.get(0).size();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int flatIdx = (i * n) + j;
				int curr = a.get(i).get(j);
				if (curr == 0) {
					setRowColumnZero(a, i, j, m, n, flatIdx);
				} else if (curr == 2) {
					a.get(i).set(j, 0);
				}
			}
		}
	}

	private void setRowColumnZero(ArrayList<ArrayList<Integer>> a, int i, int j, int m, int n, int currFlatIdx) {
		for (int k = 0; k < m; k++) {
			Integer curr = a.get(k).get(j);
			if (curr == 1) {
				int flatIdx = (k * n) + j;
				if (flatIdx < currFlatIdx) {
					a.get(k).set(j, 0);
				}
				if (flatIdx > currFlatIdx) {
					a.get(k).set(j, 2);
				}
			}
		}
		for (int k = 0; k < n; k++) {
			Integer curr = a.get(i).get(k);
			if (curr == 1) {
				int flatIdx = (i * n) + k;
				if (flatIdx < currFlatIdx) {
					a.get(i).set(k, 0);
				}
				if (flatIdx > currFlatIdx) {
					a.get(i).set(k, 2);
				}
			}
		}
	}

	/*
	 * 
	 * TESTs.
	 */

	public static void main(String[] args) {
		SetMatrixZeroes matrix = new SetMatrixZeroes();
		case1(matrix);
		case2(matrix);
		case3(matrix);
		case4(matrix);
		case5(matrix);
	}

	public static void case1(SetMatrixZeroes matrix) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(1);
		b1.add(1);
		a.add(b1);

		ArrayList<Integer> b2 = new ArrayList<>();
		b2.add(1);
		b2.add(1);
		a.add(b2);

		matrix.setZeroes(a);

		System.out.println("Case 1: " + a);
	}

	public static void case2(SetMatrixZeroes matrix) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(1);
		b1.add(0);
		a.add(b1);

		ArrayList<Integer> b2 = new ArrayList<>();
		b2.add(1);
		b2.add(1);
		a.add(b2);

		matrix.setZeroes(a);

		System.out.println("Case 2: " + a + " - exp: [[0, 0], [1, 0]]");
	}

	public static void case3(SetMatrixZeroes matrix) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(1);
		a.add(b1);
		matrix.setZeroes(a);

		System.out.println("Case 3: " + a);
	}

	public static void case4(SetMatrixZeroes matrix) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(0);
		b1.add(1);
		b1.add(1);
		b1.add(1);
		a.add(b1);

		ArrayList<Integer> b2 = new ArrayList<>();
		b2.add(1);
		b2.add(0);
		b2.add(1);
		b2.add(1);
		a.add(b2);

		ArrayList<Integer> b3 = new ArrayList<>();
		b3.add(1);
		b3.add(1);
		b3.add(0);
		b3.add(1);
		a.add(b3);

		ArrayList<Integer> b4 = new ArrayList<>();
		b4.add(1);
		b4.add(1);
		b4.add(1);
		b4.add(0);
		a.add(b4);

		matrix.setZeroes(a);

		System.out.println("Case 4: " + a + " - exp: [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]");
	}

	public static void case5(SetMatrixZeroes matrix) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(0);
		b1.add(1);
		b1.add(1);
		b1.add(1);
		a.add(b1);

		ArrayList<Integer> b2 = new ArrayList<>();
		b2.add(1);
		b2.add(1);
		b2.add(1);
		b2.add(1);
		a.add(b2);

		ArrayList<Integer> b3 = new ArrayList<>();
		b3.add(1);
		b3.add(1);
		b3.add(1);
		b3.add(1);
		a.add(b3);

		ArrayList<Integer> b4 = new ArrayList<>();
		b4.add(1);
		b4.add(1);
		b4.add(1);
		b4.add(0);
		a.add(b4);

		matrix.setZeroes(a);

		System.out.println("Case 5: " + a + " - exp: [[0, 0, 0, 0], [0, 1, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]]");
	}
}

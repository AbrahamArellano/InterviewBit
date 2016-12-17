package module_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
public class SetMatrixZeroesOptimal {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a == null || a.isEmpty() || a.get(0) == null || a.get(0).isEmpty()) {
			return;
		}

		int m = a.size();
		int n = a.get(0).size();
		Set<Integer> columns = new HashSet<>();
		Set<Integer> rows = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int curr = a.get(i).get(j);
				if (curr == 0) {
					columns.add(j);
					rows.add(i);
				} else {
					if (columns.contains(j) || rows.contains(i)) {
						a.get(i).set(j, 0);
					}
				}
			}
		}

		setRowColumnZero(a, columns, rows, m, n);
	}

	private void setRowColumnZero(ArrayList<ArrayList<Integer>> a, Set<Integer> columns, Set<Integer> rows, int m,
			int n) {
		for (Integer col : columns) {
			for (int k = 0; k < m; k++) {
				a.get(k).set(col, 0);
			}
		}
		for (Integer row : rows) {
			for (int k = 0; k < m; k++) {
				a.get(row).set(k, 0);
			}
		}
	}

	/*
	 * 
	 * TESTs.
	 */

	public static void main(String[] args) {
		SetMatrixZeroesOptimal matrix = new SetMatrixZeroesOptimal();
		// case1(matrix);
		// case2(matrix);
		// case3(matrix);
		// case4(matrix);
		case5(matrix);
	}

	public static void case1(SetMatrixZeroesOptimal matrix) {
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

	public static void case2(SetMatrixZeroesOptimal matrix) {
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

	public static void case3(SetMatrixZeroesOptimal matrix) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(1);
		a.add(b1);
		matrix.setZeroes(a);

		System.out.println("Case 3: " + a);
	}

	public static void case4(SetMatrixZeroesOptimal matrix) {
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

	public static void case5(SetMatrixZeroesOptimal matrix) {
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

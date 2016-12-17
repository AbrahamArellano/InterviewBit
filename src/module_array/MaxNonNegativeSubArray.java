package module_array;

import java.util.ArrayList;

/**
 * Find out the maximum sub-array of non negative numbers from an array. The
 * sub-array should be continuous. That is, a sub-array created by choosing the
 * second and fourth element and skipping the third element is invalid.
 * 
 * Maximum sub-array is defined in terms of the sum of the elements in the
 * sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * 
 * @author arellaa
 *
 */
public class MaxNonNegativeSubArray {

	int i = 0;
	int j = 0;
	double sum = 0;
	int ti = -1;
	int tj = -1;
	double tsum = 0;

	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
		i = 0;
		j = 0;
		sum = 0;
		ti = -1;
		tj = -1;
		tsum = 0;

		ArrayList<Integer> result = new ArrayList<>();
		// base case.
		if (a == null || a.isEmpty() || (a.size() == 1 && a.get(0) < 0)) {
			return result;
		}

		/*
		 * Vars.
		 */
		int k = 0;
		for (k = 0; k < a.size(); k++) {
			// the evaluated number is negative
			if (a.get(k) < 0) {
				tj = k;
				onNegativeOrEnd();
				ti = -1;
				tj = -1;
				tsum = 0;
			} else {
				// first time or after a negative number
				if (ti < 0) {
					ti = k;
				}
				tsum += a.get(k);
			}
		}

		tj = k;

		// last case.
		// new sum >
		onNegativeOrEnd();

		// fill the array
		for (int ls = i; ls < j && ls >= 0 && a.get(ls) >= 0; ls++) {
			result.add(a.get(ls));
		}
		return result;
	}

	/**
	 * 
	 */
	private void onNegativeOrEnd() {
		if (sum < tsum) {
			i = ti;
			j = tj;
			sum = tsum;
		} else if (sum == tsum) {
			// check max length.
			int prevLen = j - i;
			int currLen = tj - ti;
			// new is longer. or . old and new len are the same but ti
			// has smaller index.
			if ((currLen > prevLen) || (currLen == prevLen && ti < i && ti >= 0)) {
				i = ti;
				j = tj;
			}
		}
	}

	public static void main(String[] args) {

		// a.add(3);
		// a.add(4);
		// a.add(0);

		MaxNonNegativeSubArray sub = new MaxNonNegativeSubArray();
		ArrayList<Integer> maxset = sub.maxset(case1());
		System.out.println("Case 1: " + maxset);

		ArrayList<Integer> maxset2 = sub.maxset(case2());
		System.out.println("Case 2: " + maxset2);

		ArrayList<Integer> maxset3 = sub.maxset(case3());
		System.out.println("Case 3: " + maxset3);

		ArrayList<Integer> maxset4 = sub.maxset(case4());
		System.out.println("Case 4: " + maxset4);

		ArrayList<Integer> maxset5 = sub.maxset(case5());
		System.out.println("Case 5: " + maxset5);
	}

	public static ArrayList<Integer> case1() {
		// 1, 2, 5, -7, 2, 5
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(-7);
		a.add(2);
		a.add(5);
		return a;
	}

	public static ArrayList<Integer> case2() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(-1);
		a.add(1);
		a.add(2);
		return a;
	}

	public static ArrayList<Integer> case3() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(0);
		a.add(-1);
		a.add(0);
		a.add(0);
		a.add(0);
		return a;
	}

	public static ArrayList<Integer> case4() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(-1);
		a.add(-1);
		a.add(-1);
		a.add(-1);
		a.add(-1);
		a.add(-1);
		return a;
	}

	// [ 1967513926, 1540383426, -1303455736, -521595368 ]
	public static ArrayList<Integer> case5() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1967513926);
		a.add(1540383426);
		a.add(-1303455736);
		a.add(-521595368);

		return a;
	}
}

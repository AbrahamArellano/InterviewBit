package module_array;

import java.util.ArrayList;

/**
 * Lesson: be aware of parenthesis!!!
 * 
 * 
 * @author Carmen
 *
 */
public class DoubleArray {

	public static void main(String[] args) {

		// A : [5, 10, 2, 1]
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);
		A.add(10);
		A.add(2);
		A.add(1);

		ArrayList<Integer> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
			System.out.print(B.get(i) + " ");
		}

	}

	static ArrayList<Integer> performOps(ArrayList<Integer> A) {
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < 2 * A.size(); i++)
			B.add(0);
		for (int i = 0; i < A.size(); i++) {
			B.set(i, A.get(i));
			B.set(i + A.size(), A.get((A.size() - i) % A.size()));
		}
		return B;
	}
}

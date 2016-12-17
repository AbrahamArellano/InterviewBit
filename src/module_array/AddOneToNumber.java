package module_array;

import java.util.ArrayList;

/**
 * 
 * Given a non-negative number represented as an array of digits,
 * 
 * add 1 to the number ( increment the number represented by the digits ).
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example:
 * 
 * If the vector has [1, 2, 3]
 * 
 * the returned vector should be [1, 2, 4]
 * 
 * as 123 + 1 = 124.
 * 
 * NOTE: Certain things are intentionally left unclear in this question which
 * you should practice asking the interviewer.
 * 
 * For example, for this problem, following are some good questions to ask :
 * 
 * Q : Can the input have 0’s before the most significant digit. Or in other
 * words, is 0 1 2 3 a valid input?
 * 
 * A : For the purpose of this question, YES
 * 
 * Q : Can the output have 0’s before the most significant digit? Or in other
 * words, is 0 1 2 4 a valid output?
 * 
 * A : For the purpose of this question, NO. Even if the input has zeroes before
 * the most significant digit.
 * 
 * @author Carmen
 *
 */
public class AddOneToNumber {

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int carry = 1;

		clearArray(a);

		if (a.isEmpty()) {
			a.add(0);
		}

		int size = a.size();
		for (int i = size - 1; i >= 0; i--) {
			int newVal = a.get(i) + carry;
			int toSet = newVal % 10;
			carry = newVal > 9 ? 1 : 0;
			a.set(i, toSet);
		}

		if (carry > 0) {
			a.add(0, carry);
		}

		return a;
	}

	private void clearArray(ArrayList<Integer> a) {
		while (!a.isEmpty() && (a.get(0) == 0)) {
			a.remove(0);
		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AddOneToNumber addOne = new AddOneToNumber();

		ArrayList<Integer> a = onlyZero();
		System.out.println(addOne.plusOne(a));

		a = zeroesAndOne();
		System.out.println(addOne.plusOne(a));

		a = cien();
		System.out.println(addOne.plusOne(a));

		a = nineHundred();
		System.out.println(addOne.plusOne(a));

		a = fiveSome();
		System.out.println(addOne.plusOne(a));
	}

	/*
	 * HELPER
	 * 
	 */

	private static ArrayList<Integer> onlyZero() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		return a;
	}

	private static ArrayList<Integer> zeroesAndOne() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(0);
		a.add(1);
		return a;
	}

	private static ArrayList<Integer> cien() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(0);
		a.add(0);
		return a;
	}

	private static ArrayList<Integer> nineHundred() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(9);
		a.add(9);
		a.add(9);
		return a;
	}

	private static ArrayList<Integer> fiveSome() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(4);
		a.add(9);
		return a;
	}

}

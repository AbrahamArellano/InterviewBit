package module_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example:
 * 
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * 
 * @author arellaa
 *
 */
public class LargestNumber {

	public String largestNumber(final List<Integer> a) {
		StringBuilder sb = new StringBuilder();

		if (a == null || a.isEmpty()) {
			return sb.toString();
		}
		if (a.size() == 1) {
			return String.valueOf(a.get(0));
		}

		// real logic.
		Collections.sort(a, new LargeNumComparator());

		for (Integer num : a) {
			if (sb.length() == 0 && num == 0) {
				continue;
			}
			sb.append(num);
		}

		if (sb.length() == 0) {
			sb.append("0");
		}

		return sb.toString();
	}

	/**
	 * Comparator.
	 *
	 */
	class LargeNumComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			String num1 = Integer.toString(o1);
			String num2 = Integer.toString(o2);
			if (num1.length() == num2.length()) {
				return o2.compareTo(o1);
			}

			return compareOnRecursion(num1, num2);
		}

		private int compareOnRecursion(String num1, String num2) {
			// base case.
			if ((num1 == null && num2 == null) || (num1.isEmpty() && num2.isEmpty())) {
				return 0;
			}
			if (num1.isEmpty()) {
				return -1;
			}
			if (num2.isEmpty()) {
				return 1;
			}
			if (num1.length() == num2.length()) {
				return Integer.valueOf(num2).compareTo(Integer.valueOf(num1));
			}

			int minLen = Math.min(num1.length(), num2.length());
			int newNum1 = Integer.valueOf(num1.substring(0, minLen));
			int newNum2 = Integer.valueOf(num2.substring(0, minLen));

			int compare = Integer.compare(newNum2, newNum1);
			if (compare == 0) {
				String param1 = num1.length() == minLen ? num1 : num1.substring(minLen);
				String param2 = num2.length() == minLen ? num2 : num2.substring(minLen);

				compare = compareOnRecursion(param1, param2);
			}

			return compare;
		}

	}

	/*
	 * 
	 * Main.
	 */
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		String largestNumber = null;

		largestNumber = ln.largestNumber(case0());
		System.out.println("Case 0: " + largestNumber);

		largestNumber = ln.largestNumber(case1());
		System.out.println("Case 1: " + largestNumber);

		largestNumber = ln.largestNumber(case2());
		System.out.println("Case 2: " + largestNumber);

		largestNumber = ln.largestNumber(case3());
		System.out.println("Case 3: " + largestNumber);

		largestNumber = ln.largestNumber(case4());
		System.out.println("Case 4: " + largestNumber + " - exp: 221");

		largestNumber = ln.largestNumber(case5());
		System.out.println("Case 5: " + largestNumber + " - exp: 232");

		largestNumber = ln.largestNumber(case6());
		System.out.println("Case 6: " + largestNumber + " - exp: 2213");

		largestNumber = ln.largestNumber(case7());
		System.out.println("Case 7: " + largestNumber + " - exp: 2312");

		largestNumber = ln.largestNumber(case8());
		System.out.println("Case 8: " + largestNumber + " - exp: 27271");

		largestNumber = ln.largestNumber(case9());
		System.out.println("Case 9: " + largestNumber + " - exp: 12121");

		// 9534330
		largestNumber = ln.largestNumber(case10());
		System.out.println("Case 10: " + largestNumber + " - exp: 9534330");

		largestNumber = ln.largestNumber(case11());
		System.out.println("Case 11: " + largestNumber + " - exp: 0");

		largestNumber = ln.largestNumber(case12());
		System.out.println("Case 12: " + largestNumber + " - exp: 111111111");
	}

	/*
	 * Cases
	 */

	private static List<Integer> case0() {
		List<Integer> list = new ArrayList<>();
		return list;
	}

	private static List<Integer> case1() {
		List<Integer> list = new ArrayList<>();
		list.add(100);
		return list;
	}

	private static List<Integer> case2() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		return list;
	}

	private static List<Integer> case3() {
		List<Integer> list = new ArrayList<>();
		list.add(599);
		list.add(589);
		list.add(500);
		return list;
	}

	private static List<Integer> case4() {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(21);
		return list;
	}

	private static List<Integer> case5() {
		List<Integer> list = new ArrayList<>();
		list.add(23);
		list.add(2);
		return list;
	}

	private static List<Integer> case6() {
		List<Integer> list = new ArrayList<>();
		list.add(213);
		list.add(2);
		return list;
	}

	private static List<Integer> case7() {
		List<Integer> list = new ArrayList<>();
		list.add(231);
		list.add(2);
		return list;
	}

	private static List<Integer> case8() {
		List<Integer> list = new ArrayList<>();
		list.add(27);
		list.add(271);
		return list;
	}

	// 12121
	private static List<Integer> case9() {
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(121);
		return list;
	}

	// base case
	// [3, 30, 34, 5, 9]
	// 9534330
	private static List<Integer> case10() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(30);
		list.add(34);
		list.add(5);
		list.add(9);
		return list;
	}

	private static List<Integer> case11() {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		return list;
	}

	private static List<Integer> case12() {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(111);
		list.add(1111);
		return list;
	}
}

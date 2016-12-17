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
public class LargestNumberOptimized {

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
			String strNum1 = Integer.toString(o1) + Integer.toString(o2);
			String strNum2 = Integer.toString(o2) + Integer.toString(o1);

			Double num1 = Double.valueOf(strNum1);
			Double num2 = Double.valueOf(strNum2);

			return num2.compareTo(num1);
		}

	}

	/*
	 * 
	 * Main.
	 */
	public static void main(String[] args) {
		LargestNumberOptimized ln = new LargestNumberOptimized();
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

		// 2147483647 --> 2147483647214748364621474836452147483644
		largestNumber = ln.largestNumber(case13());
		System.out.println("Case 13: " + largestNumber + " - exp: 2147483647214748364621474836452147483644");
		System.out.println(largestNumber.equals("2147483647214748364621474836452147483644"));
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

	private static List<Integer> case13() {
		List<Integer> list = new ArrayList<>();
		list.add(Integer.MAX_VALUE - 3);
		list.add(Integer.MAX_VALUE - 2);
		list.add(Integer.MAX_VALUE - 1);
		list.add(Integer.MAX_VALUE);
		return list;
	}
}

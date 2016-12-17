package module_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example:
 * 
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 * 
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * For this problem, return the maximum sum.
 * 
 * 
 * @author arellaa
 *
 */
public class MaxSumContigousSubarray {

	public int maxSubArray(final List<Integer> a) {

		int sum = Integer.MIN_VALUE;
		int last = 0;

		for (Integer num : a) {
			last += num;

			sum = Math.max(last, sum);

			if (last < 0) {
				last = 0;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		MaxSumContigousSubarray cont = new MaxSumContigousSubarray();
		String s = "-120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428, -182, -138, -167, -465, -347, -39, -51, -61, -491, -216, -36, -281, -361, -271, -368, -122, -114, -53, -488, -327, -182, -221, -381, -431, -161, -59, -494, -406, -298, -268, -425, -88, -320, -371, -5, 36, 89, -194, -140, -278, -65, -38, -144, -407, -235, -426, -219, 62, -299, 1, -454, -247, -146, 24, 2, -59, -389, -77, -19, -311, 18, -442, -186, -334, 41, -84, 21, -100, 65, -491, 94, -346, -412, -371, 89, -56, -365, -249, -454, -226, -473, 91, -412, -30, -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429, -215, -102, -63, 80, 65, 63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68, -472, -463, -212, -267, -302, -471, -245, -165, 43, -288, -379, -243, 35, -288, 62, 23, -444, -91, -24, -110, -28, -305, -81, -169, -348, -184, 79, -262, 13, -459, -345, 70, -24, -343, -308, -123, -310, -239, 83, -127, -482, -179, -11, -60, 35, -107, -389, -427, -210, -238, -184, 90, -211, -250, -147, -272, 43, -99, 87, -267, -270, -432, -272, -26, -327, -409, -353, -475, -210, -14, -145, -164, -300, -327, -138, -408, -421, -26, -375, -263, 7, -201, -22, -402, -241, 67, -334, -452, -367, -284, -95, -122, -444, -456, -152, 25, 21, 61, -320, -87, 98, 16, -124, -299, -415, -273, -200, -146, -437, -457, 75, 84, -233, -54, -292, -319, -99, -28, -97, -435, -479, -255, -234, -447, -157, 82, -450, 86, -478, -58, 9, -500, -87, 29, -286, -378, -466, 88, -366, -425, -38, -134, -184, 32, -13, -263, -371, -246, 33, -41, -192, -14, -311, -478, -374, -186, -353, -334, -265, -169, -418, 63, 77, 77, -197, -211, -276, -190, -68, -184, -185, -235, -31, -465, -297, -277, -456, -181, -219, -329, 40, -341, -476, 28, -313, -78, -165, -310, -496, -450, -318, -483, -22, -84, 83, -185, -140, -62, -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2, 81, -326, -339, -56, -123, 10, -463, 41, -458, -409, -314, -125, -495, -256, -388, 75, 40, -37, -449, -485, -487, -376, -262, 57, -321, -364, -246, -330, -36, -473, -482, -94, -63, -414, -159, -200, -13, -405, -268, -455, -293, -298, -416, -222, -207, -473, -377, -167, 56, -488, -447, -206, -215, -176, 76, -304, -163, -28, -210, -18, -484, 45, 10, 79, -441, -197, -16, -145, -422, -124, 79, -464, -60, -214, -457, -400, -36, 47, 8, -151, -489, -327, 85, -297, -395, -258, -31, -56, -500, -61, -18, -474, -426, -162, -79, 25, -361, -88, -241, -225, -367, -440, -200, 38, -248, -429, -284, -23, 19, -220, -105, -81, -269, -488, -204, -28, -138, 39, -389, 40, -263, -297, -400, -158, -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230, -410, -66, 67, -396, -146, -158, -264, -13, -15, -425, 58, -25, -241, 85, -82, -49, -150, -37, -493, -284, -107, 93, -183, -60, -261, -310, -380";
		// String s = "-163, -20";
		// String s = "-2,1,-3,4,-1,2,1,-5,4";
		String sr = s.replaceAll(" ", "");
		String[] sd = sr.split(",");

		List<Integer> a = new ArrayList<>();
		for (String txt : sd) {
			a.add(new Integer(txt));
		}
		// -2,1,-3,4,-1,2,1,-5,4

		// a.add(-2);
		// a.add(1);
		// a.add(-3);
		// a.add(4);
		// a.add(-1);
		// a.add(2);
		// a.add(1);
		// a.add(-5);
		// a.add(4);

		int maxSubArray = cont.maxSubArray(a);
		System.out.println(maxSubArray);
	}

	public int maxSubArrayLinearComplex(final List<Integer> a) {
		if (a == null || a.size() < 1) {
			return 0;
		}
		int size = a.size();
		int partialSum = a.get(0);
		int maxSum = a.get(0);

		if (size < 2) {
			return a.get(0);
		}

		// to fix
		for (int i = 1; i < size; i++) {

			if (((partialSum + a.get(i)) > partialSum || (partialSum + a.get(i)) > 0)
					&& (partialSum + a.get(i)) > a.get(i)) {
				partialSum += a.get(i);
			} else {
				partialSum = a.get(i);
			}
			maxSum = Math.max(maxSum, partialSum);
		}

		return maxSum;
	}
}

/**
 * Sub-optimal
 * 
 * public int maxSubArray(final List<Integer> a) { if (a == null || a.size() <
 * 1) { return 0; } int size = a.size(); int totalSum = 0; int maxSum = 0;
 * 
 * if (size < 2) { return a.get(0); }
 * 
 * for (int i = 0; i < size; i++) { totalSum += a.get(i); maxSum += a.get(i); }
 * 
 * // to fix int accLR = 0; for (int i = 0; i < (size - 1); i++) { accLR +=
 * a.get(i); int accRL = 0;
 * 
 * maxSum = Math.max((totalSum - accLR), maxSum);
 * 
 * for (int j = size - 1; j > 0; j--) { accRL += a.get(j); maxSum =
 * Math.max((totalSum - accRL), maxSum);
 * 
 * if (j > (i + 1)) { maxSum = Math.max((totalSum - (accRL + accLR)), maxSum); }
 * } }
 * 
 * return maxSum; }
 */

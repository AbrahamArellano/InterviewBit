package module_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Lesson: use module to rotate an index.
 * 
 * 
 * @author Carmen
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		Solution sol = new Solution();
		ArrayList<Integer> rotateArray = sol.rotateArray(list, 5);
		print(rotateArray);

	}

	private static void print(List<Integer> list) {
		System.out.println("\n---");
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println("\n---");
	}

}

class Solution {
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			int pos = i + B;
			pos = pos % A.size();
			ret.add(A.get(pos));
		}
		return ret;
	}
}

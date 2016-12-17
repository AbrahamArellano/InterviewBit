package module_array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers, sort the array into a wave like array and return
 * it, In other words, arrange the elements into a sequence such that a1 >= a2
 * <= a3 >= a4 <= a5.....
 * 
 * Example
 * 
 * Given [1, 2, 3, 4]
 * 
 * One possible answer : [2, 1, 4, 3] Another possible answer : [4, 1, 3, 2]
 * NOTE : If there are multiple answers possible, return the one thats
 * lexicographically smallest. So, in example case, you will return [2, 1, 4, 3]
 * 
 * @author arellaa
 *
 */
public class WaveArrays {

	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		Collections.sort(a);
		int size = a.size();

		for (int i = 0; i < size; i = i + 2) {
			swap(a, i, i + 1);
		}
		return a;
	}

	/**
	 * Perform swap if index are in valid range.
	 * 
	 * @param a
	 * @param pos1
	 * @param pos2
	 */
	private void swap(ArrayList<Integer> a, int pos1, int pos2) {
		if (pos1 < a.size() && pos2 < a.size()) {
			Integer aux = a.get(pos1);
			a.set(pos1, a.get(pos2));
			a.set(pos2, aux);
		}
	}

	/**
	 * Main class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WaveArrays wave = new WaveArrays();
		ArrayList<Integer> a = new ArrayList<>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		a.add(50);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);

		System.out.println(wave.wave(a));
	}

}

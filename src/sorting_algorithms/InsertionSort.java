package sorting_algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

	public List<Integer> sortByInsertion(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			// hole
			int hole = i;
			// value
			int value = list.get(i);

			// the left size object is bigger than the value.
			// so shift to the right
			while (hole > 0 && list.get(hole - 1) > value) {
				list.set(hole, list.get(hole - 1));
				hole--;
			}
			list.set(hole, value);
		}

		return list;
	}

	public static void main(String[] args) {
		List<Integer> unsorted = new ArrayList<Integer>();
		unsorted.add(3);
		unsorted.add(9);
		unsorted.add(11);
		unsorted.add(21);
		unsorted.add(1);
		unsorted.add(4);
		unsorted.add(17);

		InsertionSort sorting = new InsertionSort();
		sorting.sortByInsertion(unsorted);

		for (int i : unsorted) {
			System.out.print(i + " ");
		}
	}

}

package sorting_algorithms;

/**
 * Merge sort support class.
 * 
 * @author Abraham
 *
 */
public class MergeSort {

	/**
	 * Merge sort algorithm.
	 * 
	 * @param a
	 */
	public void mergeSort(int[] a) {
		int n = a.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		// left is filled with 0 - (mid -1)
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		// right is filled with mid - (n-1)
		for (int i = mid; i < n; i++) {
			right[i - mid] = a[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
	}

	/**
	 * Merge 2 arrays in a sorted order into the array a.
	 * 
	 * @param left
	 * @param right
	 * @param a
	 */
	private void merge(int[] left, int[] right, int[] a) {
		// i - left
		// j - right
		// k - original
		int i = 0, j = 0, k = 0;
		int sL = left.length;
		int sR = right.length;

		while (i < sL && j < sR) {
			if (left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < sL) {
			a[k] = left[i];
			k++;
			i++;
		}
		while (j < sR) {
			a[k] = right[j];
			k++;
			j++;
		}
	}

	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 11, 3, 14, 8, 4, 21, 9, 17, 1, 0, 2, 19, 6 };
		MergeSort sort = new MergeSort();
		sort.mergeSort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}

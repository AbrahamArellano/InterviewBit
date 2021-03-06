package module_array;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in
 * [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 * 
 * 
 * @author arellaa
 *
 */
public class MergeIntervals {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		swapInterval(newInterval);

		ArrayList<Interval> newIntervals = new ArrayList<>();
		boolean added = false;

		for (Interval interval : intervals) {
			swapInterval(newInterval);

			if (!areOverlapping(interval, newInterval)) {
				newIntervals.add(interval);
			} else {
				if (!added) {
					newIntervals.add(newInterval);
					added = true;
				}

				if (isStartOverlapping(interval, newInterval)) {
					if (interval.start < newInterval.start) {
						newInterval.start = interval.start;
					}
				}
				if (isEndOverlapping(interval, newInterval)) {
					if (interval.end > newInterval.end) {
						newInterval.end = interval.end;
					}
				}
			}
		}

		if (!added) {
			if (newIntervals.isEmpty()) {
				newIntervals.add(newInterval);
			} else {
				for (int i = 0; i < newIntervals.size(); i++) {
					if (newIntervals.get(i).start > newInterval.end) {
						newIntervals.add(i, newInterval);
						added = true;
						break;
					}
				}
				if (!added) {
					newIntervals.add(newInterval);
				}
			}
		}
		return newIntervals;
	}

	/**
	 * @param newInterval
	 */
	private void swapInterval(Interval newInterval) {
		if (newInterval.start > newInterval.end) {
			int temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}
	}

	private boolean areOverlapping(Interval i1, Interval i2) {
		boolean overlap = false;
		if (isStartOverlapping(i1, i2)) {
			overlap = true;
		}
		if (isEndOverlapping(i1, i2)) {
			overlap = true;
		}
		return overlap;
	}

	private boolean isStartOverlapping(Interval i1, Interval i2) {
		boolean overlap = false;
		if (i1.start <= i2.start && i1.end >= i2.start) {
			overlap = true;
		}
		if (i2.start <= i1.start && i2.end >= i1.start) {
			overlap = true;
		}
		return overlap;
	}

	private boolean isEndOverlapping(Interval i1, Interval i2) {
		boolean overlap = false;
		if (i1.start <= i2.end && i1.end >= i2.end) {
			overlap = true;
		}
		if (i2.start <= i1.end && i2.end >= i1.end) {
			overlap = true;
		}
		return overlap;
	}

	public static void main(String[] args) {
		// Interval i1 = new Interval(1, 3);
		// Interval i2 = new Interval(6, 9);
		//
		// Interval inew = new Interval(2, 5);

		// Interval i1 = new Interval(1, 2);
		// Interval i2 = new Interval(3, 5);
		// Interval i3 = new Interval(6, 7);
		// Interval i4 = new Interval(8, 10);
		// Interval i5 = new Interval(12, 16);
		//
		// Interval inew = new Interval(4, 9);

		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 6);
		Interval i3 = new Interval(15, 20);

		Interval inew = new Interval(10, 8);

		ArrayList<Interval> ins = new ArrayList<>();
		ins.add(i1);
		ins.add(i2);
		// ins.add(i3);
		// ins.add(i3);
		// ins.add(i4);
		// ins.add(i5);

		MergeIntervals mi = new MergeIntervals();
		ArrayList<Interval> insert = mi.insert(ins, inew);
		System.out.println(insert);
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "[" + start + "," + end + "]";
	}
}

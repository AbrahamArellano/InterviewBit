package module_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example:
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 * 
 * Make sure the returned intervals are sorted.
 * 
 * @author arellaa
 *
 */
public class MergeOverlappingIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		int size = intervals.size();
		int ii = 0;
		int ei = 1;

		for (int i = 0; i < size; i++) {
			swapInterval(intervals.get(i));
		}

		Collections.sort(intervals, new IntervalComparator());

		while (ii < size && ei < size) {
			// swapInterval(intervals.get(ii));
			// swapInterval(intervals.get(ei));

			if (areOverlapping(intervals.get(ii), intervals.get(ei))) {
				intervals.get(ii).start = Math.min(intervals.get(ii).start, intervals.get(ei).start);
				intervals.get(ii).end = Math.max(intervals.get(ii).end, intervals.get(ei).end);
				intervals.remove(ei);
				size--;
			} else {
				ii = ei;
				ei++;
			}
		}

		return intervals;
	}

	private boolean areOverlapping(Interval interval, Interval interval2) {
		boolean overlap = false;
		if (startOverlap(interval, interval2) || endOverlap(interval, interval2)) {
			overlap = true;
		}

		return overlap;
	}

	private boolean startOverlap(Interval interval, Interval interval2) {
		boolean overlap = false;
		if ((interval.start <= interval2.start && interval.end >= interval2.start)
				|| interval2.start <= interval.start && interval2.end >= interval.start) {
			overlap = true;
		}
		return overlap;
	}

	private boolean endOverlap(Interval interval, Interval interval2) {
		boolean overlap = false;
		if ((interval.start <= interval2.end && interval.end >= interval2.end)
				|| interval2.start <= interval.end && interval2.end >= interval.end) {
			overlap = true;
		}
		return overlap;
	}

	/**
	 * Start < End
	 * 
	 * @param interval
	 */
	private void swapInterval(Interval interval) {
		if (interval.end < interval.start) {
			int temp = interval.start;
			interval.start = interval.end;
			interval.end = temp;
		}
	}

	class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			return Integer.compare(o1.start, o2.start);
		}

	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MergeOverlappingIntervals overlap = new MergeOverlappingIntervals();
		ArrayList<Interval> intervals = basic();
		System.out.println(overlap.merge(intervals));

		intervals = zero();
		System.out.println(overlap.merge(intervals));

		intervals = one();
		System.out.println(overlap.merge(intervals));

		intervals = multiples();
		System.out.println(overlap.merge(intervals));

		intervals = reverseMultiples();
		System.out.println(overlap.merge(intervals));

		intervals = strangeCase();
		System.out.println(overlap.merge(intervals));
	}

	/**
	 * @return
	 */
	private static ArrayList<Interval> basic() {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(5, 6));
		return intervals;
	}

	/**
	 * @return
	 */
	private static ArrayList<Interval> zero() {
		ArrayList<Interval> intervals = new ArrayList<>();
		return intervals;
	}

	/**
	 * @return
	 */
	private static ArrayList<Interval> one() {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		return intervals;
	}

	/**
	 * @return
	 */
	private static ArrayList<Interval> multiples() {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(5, 8));
		intervals.add(new Interval(6, 9));
		intervals.add(new Interval(5, 13));
		intervals.add(new Interval(9, 11));
		intervals.add(new Interval(1, 9));
		return intervals;
	}

	/**
	 * @return
	 */
	private static ArrayList<Interval> reverseMultiples() {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(3, 1));
		intervals.add(new Interval(4, 2));
		intervals.add(new Interval(8, 5));
		intervals.add(new Interval(9, 6));
		intervals.add(new Interval(13, 5));
		intervals.add(new Interval(11, 9));
		intervals.add(new Interval(9, 1));
		return intervals;
	}

	private static ArrayList<Interval> strangeCase() {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(9, 0));
		return intervals;
	}

}

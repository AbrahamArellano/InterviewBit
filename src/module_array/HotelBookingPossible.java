package module_array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A hotel manager has to process N advance bookings of rooms for the next
 * season.
 * 
 * His hotel has K rooms. Bookings contain an arrival date and a departure date.
 * He wants to find out whether there are enough rooms in the hotel to satisfy
 * the demand.
 * 
 * Write a program that solves this problem in time O(N log N) .
 * 
 * @author arellaa
 *
 */
public class HotelBookingPossible {

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		if (K == 0) {
			return false;
		}
		if (arrive.isEmpty() && depart.isEmpty()) {
			return true;
		}

		int size = arrive.size();
		if (size == 1 && arrive.get(0) == depart.get(0)) {
			return true;
		}

		Interval[] intervals = new Interval[size];

		for (int i = 0; i < size; i++) {
			Interval interval = new Interval();
			interval.start = arrive.get(i);
			interval.end = depart.get(i);
			intervals[i] = interval;
		}

		Arrays.sort(intervals);

		return collisions(intervals, K);

	}

	public boolean collisions(Interval[] intervals, int k) {
		Interval overlap = new Interval();
		overlap.start = intervals[0].start;
		overlap.end = intervals[0].end;
		int roomsOccupied = 0;
		int startIdx = 0;

		for (int i = 1; i < intervals.length; i++) {
			Interval interval = intervals[i];
			if (interval.start == interval.end) {
				intervals[i] = null;
				continue;
			}

			boolean overLapStart = overlap.start <= interval.start && overlap.end > interval.start;
			boolean overLapEnd = overlap.start < interval.end && overlap.end >= interval.end;
			boolean overInterStart = interval.start <= overlap.start && interval.end > overlap.start;
			boolean overInterEnd = interval.start < overlap.end && interval.end >= overlap.end;

			if (overLapStart || overLapEnd || overInterStart || overInterEnd) {
				if (roomsOccupied == 0) {
					roomsOccupied++;
				}
				roomsOccupied++;
				// if (overlap.start > interval.start) {
				overlap.start = interval.start;
				// }
				if (overlap.end < interval.end) {
					overlap.end = interval.end;
				}

				// check remove previous collisions
				for (int m = startIdx; m < i; m++) {
					Interval intervalRem = intervals[m];
					if (intervals[m] != null && (intervalRem.end <= overlap.start)) {
						roomsOccupied--;
						intervals[m] = null;
					}
				}

				if (roomsOccupied > k) {
					return false;
				}

			} else {
				overlap.start = interval.start;
				overlap.end = interval.end;
				roomsOccupied = 0;
				startIdx = i;
			}
		}

		return true;
	}

	class Interval implements Comparable<Interval> {
		int start = 0;
		int end = 0;

		@Override
		public int compareTo(Interval o) {
			return Integer.compare(this.start, o.start);
		}

		public String toString() {
			return "(" + start + ", " + end + ")";
		}

	}

	/*
	 * 
	 * 
	 * TEST
	 */
	public static void main(String[] args) {
		HotelBookingPossible book = new HotelBookingPossible();
		case1(book);
		case2(book);
		case3(book);
		case4(book);
		case5(book);
		case6(book);
		case7(book);
		case8(book);
		case9(book);
		case10(book);
	}

	private static void case1(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(1);
		int K = 1;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 1: " + hotel + " - exp: true");
	}

	private static void case2(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(2);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(2);
		depart.add(3);
		int K = 1;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 2: " + hotel + " - exp: true");
	}

	private static void case3(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(3);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(4);
		depart.add(5);
		int K = 1;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 3: " + hotel + " - exp: false");
	}

	private static void case4(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(3);
		arrive.add(5);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(2);
		depart.add(6);
		depart.add(8);
		int K = 1;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 4: " + hotel + " - exp: false");
	}

	private static void case5(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(2);
		arrive.add(6);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(5);
		depart.add(8);
		depart.add(9);
		int K = 2;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 5: " + hotel + " - exp: true");
	}

	private static void case6(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(3);
		arrive.add(4);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(6);
		depart.add(5);
		depart.add(8);
		int K = 2;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 6: " + hotel + " - exp: false");
	}

	private static void case7(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(1);
		arrive.add(3);
		arrive.add(4);
		arrive.add(7);
		arrive.add(8);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(9);
		depart.add(5);
		depart.add(8);
		depart.add(10);
		depart.add(11);
		int K = 3;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 7: " + hotel + " - exp: true");
	}

	// [ 17, 0, 45, 11, 16, 43, 15, 42, 2, 41, 0, 27, 37, 25, 17, 42, 24, 23,
	// 11, 4, 29, 39, 6, 10, 42, 16, 17, 39, 1 ]
	private static void case8(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		String[] s = "17, 0, 45, 11, 16, 43, 15, 42, 2, 41, 0, 27, 37, 25, 17, 42, 24, 23, 11, 4, 29, 39, 6, 10, 42, 16, 17, 39, 1"
				.replace(" ", "").split(",");
		for (int i = 0; i < s.length; i++) {
			arrive.add(Integer.valueOf(s[i]));
		}

		ArrayList<Integer> depart = new ArrayList<>();
		s = "25, 24, 52, 51, 26, 46, 25, 45, 9, 51, 49, 48, 51, 66, 65, 57, 69, 43, 50, 9, 32, 55, 10, 58, 62, 46, 19, 87, 12"
				.replace(" ", "").split(",");
		for (int i = 0; i < s.length; i++) {
			depart.add(Integer.valueOf(s[i]));
		}
		int K = 16;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 8: " + hotel + " - exp: false");
	}

	private static void case9(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		arrive.add(40);
		arrive.add(18);
		ArrayList<Integer> depart = new ArrayList<>();
		depart.add(40);
		depart.add(43);
		int K = 1;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 9: " + hotel + " - exp: true");
	}

	private static void case10(HotelBookingPossible book) {
		ArrayList<Integer> arrive = new ArrayList<>();
		String[] s = "33, 9 , 9, 32, 4, 31, 28, 44, 45, 10, 23, 19, 31, 46, 20 ,10".replace(" ", "").split(",");
		for (int i = 0; i < s.length; i++) {
			arrive.add(Integer.valueOf(s[i]));
		}

		ArrayList<Integer> depart = new ArrayList<>();
		s = "48, 37, 20, 80, 44, 51, 29 , 63, 64, 32, 48, 19, 74, 65, 64, 52".replace(" ", "").split(",");
		for (int i = 0; i < s.length; i++) {
			depart.add(Integer.valueOf(s[i]));
		}
		int K = 9;
		boolean hotel = book.hotel(arrive, depart, K);
		System.out.println("Case 10: " + hotel + " - exp: false");
	}
}

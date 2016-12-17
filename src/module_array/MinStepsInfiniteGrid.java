package module_array;

import java.util.ArrayList;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions
 * :
 * 
 * (x,y) to (x+1, y), (x - 1, y), (x, y+1), (x, y-1), (x-1, y-1), (x+1,y+1),
 * (x-1,y+1), (x+1,y-1) You are given a sequence of points and the order in
 * which you need to cover the points. Give the minimum number of steps in which
 * you can achieve it. You start from the first point.
 * 
 * Example :
 * 
 * Input : [(0, 0), (1, 1), (1, 2)] Output : 2 It takes 1 step to move from (0,
 * 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * 
 * This question is intentionally left slightly vague. Clarify the question by
 * trying out a few cases in the “See Expected Output” section.
 * 
 * @author Carmen
 *
 */
public class MinStepsInfiniteGrid {

	// X and Y co-ordinates of the points in order.
	// Each point is represented by (X.get(i), Y.get(i))
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int amount = 0;

		if (X == null || Y == null) {
			return 0;
		}

		if (X.size() != Y.size()) {
			return -1;
		}

		if (X.size() < 2 || Y.size() < 2) {
			return 0;
		}

		int length = X.size();

		// get current point.
		int currentX = X.get(0);
		int currentY = Y.get(0);

		// compare with others
		for (int i = 1; i < length; i++) {
			int nextX = X.get(i);
			int nextY = Y.get(i);

			int distX = Math.abs(currentX - nextX);
			int distY = Math.abs(currentY - nextY);

			amount += Math.max(distX, distY);

			// new current.
			currentX = nextX;
			currentY = nextY;
		}

		return amount;
	}

	public static void main(String[] a) {
		MinStepsInfiniteGrid grid = new MinStepsInfiniteGrid();
		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();

		/*
		 * 4 8 -7 -5 -13 9 -7 8 4 -15 -10 -3 -13 12 8 -8
		 * 
		 * 108
		 */

		X.add(4);
		X.add(8);
		X.add(-7);
		X.add(-5);
		X.add(-13);
		X.add(9);
		X.add(-7);
		X.add(8);

		Y.add(4);
		Y.add(-15);
		Y.add(-10);
		Y.add(-3);
		Y.add(-13);
		Y.add(12);
		Y.add(8);
		Y.add(-8);
		int coverPoints = grid.coverPoints(X, Y);
		System.out.println(coverPoints);
	}
}

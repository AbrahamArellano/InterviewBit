/**
 * 
 */
package module_array;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Input : k = 3
 * 
 * Return : [1,3,3,1]
 * 
 * 
 * @author Abraham Arellano
 *
 */
public class KthRowPascalTriangle {

	public ArrayList<Integer> getRow(int a) {
		ArrayList<Integer> row = new ArrayList<>();

		if (a >= 0) {
			row.add(1);
		}
		if (a == 1) {
			row.add(1);
		}
		if (a > 1) {
			calculatePascal(row, a);
		}

		return row;
	}

	private void calculatePascal(ArrayList<Integer> row, int n) {
		for (int k = 0; k < n - 1; k++) {
			final BigInteger mult = BigInteger.valueOf(row.get(k)).multiply(BigInteger.valueOf(n - k));
			BigInteger c = mult.divide(BigInteger.valueOf(k + 1));
			row.add(c.intValue());
		}
		row.add(1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KthRowPascalTriangle pt = new KthRowPascalTriangle();
		final ArrayList<Integer> row = pt.getRow(5);
		System.out.println(row);
	}

}

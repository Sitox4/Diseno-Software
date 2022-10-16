package e1;

import java.util.*;

public class MatrixFunctions {
        // Returns the maximun value of a matrix
	public static int max(int[][] a) {
		int mayor = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > mayor) {
					mayor = a[i][j];
				}
			}
		}
		return mayor;
	}

        // Returns the sum of the values of a given row
	public static int rowSum(int[][] a, int row) {
		int sum = 0;
		for (int i = 0; i < a[row].length; i++) {
			sum += a[row][i];
		}
		return sum;
	}

        // Returns the sum of the values of a given column
	public static int columnSum(int[][] a, int colum) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length > colum) {
				sum += a[i][colum];
			}
		}
		return sum;
	}

        // Sums the value of each row and returns the results in an array .
	public static int[] allRowSums(int[][] a) {
		int[] rowSum = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			rowSum[i] = 0;
			for (int j = 0; j < a[i].length; j++) {
				rowSum[i] += a[i][j];
			}
		}
		return rowSum;
	}

        // Sums the value of each column and returns the results in an array .
        // If a position does not exist because the array is " ragged " that position
        // is considered a zero value .
	public static int[] allColumnSums(int[][] a) {
		int numColumnas = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length > numColumnas) {
				numColumnas = a[i].length;
			}
		}
		int[] columnSum = new int[numColumnas];
		for (int i = 0; i < numColumnas; i++) {
			columnSum[i] = columnSum(a, i);
		}
		return columnSum;
	}

        // Checks if an array is "row - magic ", that is , if all its rows have the same
        // sum of all its values .
	public static boolean isRowMagic(int[][] a) {
		int[] sum;
		sum = allRowSums(a);
		for (int i = 0; i < (sum.length - 1); i++) {
			if (sum[i] != sum[i + 1]) {
				return false;
			}
		}
		return true;
	}

        // Checks if an array is " column - magic ", that is , if all its columns have
        // the same sum of all its values .
	public static boolean isColumnMagic(int[][] a) {
		int[] sum;
		sum = allColumnSums(a);
		for (int i = 0; i < (sum.length - 1); i++) {
			if (sum[i] != sum[i + 1]) {
				return false;
			}
		}
		return true;
	}

        // Checks that a matrix is square , that is , it has the same number of rows
        // as columns and all rows have the same length .
	public static boolean isSquare(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			if (a.length != a[i].length) {
				return false;
			}
		}
		return true;
	}

        // Check if the matrix is a magic square . A matrix is magic square if it is
        // square , all the rows add up to the same , all the columns add up to the
        // same and the two main diagonals add up to the same . Also all these sums
        // are the same .
	public static boolean isMagic(int[][] a) {
		boolean resultado = false;
		int d1 = 0;
		int d2 = 0;
		int columnas[];
		columnas = allColumnSums(a);
		if (isSquare(a) && isRowMagic(a) && isColumnMagic(a)) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if ((i + j) == (a.length - 1)) {
						d2 += a[i][j];
					}
					if (i == j) {
						d1 += a[i][j];
					}
				}
			}
			if ((d1 == d2) && (d2 == columnSum(a, 0)) && (rowSum(a, 0) == columnSum(a, 0))) {
				resultado = true;
			}
		}
		return resultado;
	}

        // Checks if the given matrix forms a sequence , that is , it is square
        // (of order n) and contains all the digits from 1 to n * n, regardless of
        // their order .
	public static boolean isSequence(int[][] a) {
		if (isSquare(a)) {
			int rowSum[];
			int sum = 0;
			int sum2 = 0;
			rowSum = allRowSums(a);
			for (int i = 0; i < rowSum.length; i++) {
				sum = sum + rowSum[i];
			}
			for (int i = (a.length * a.length); i > 0; i--) {
				sum2 = sum2 + i;
			}
			if (sum == sum2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
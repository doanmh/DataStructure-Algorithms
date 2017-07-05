package ctci.chapter01.question08_ZeroMatrix;

public class Question08Answer {
	public static void zeroMatrix(int[][] matrix) {
	    boolean firstRowZero = false;
	    boolean firstColZero = false;

	    for (int j = 0; j < matrix[0].length; j++) {
	        if (matrix[0][j] == 0) {
	            firstRowZero = true;
	            break;
	        }
	    }

	    for (int i = 0; i < matrix.length; i++) {
	        if (matrix[i][0] == 0) {
	            firstColZero = true;
	            break;
	        }
	    }

	    for (int i = 1; i < matrix.length; i++) {
	        for (int j = 1; j < matrix[0].length; j++) {
	            if (matrix[i][j] == 0) {
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	                break;
	            }
	        }
	    }    

	    for (int i = 1; i < matrix.length; i++) {
	        if (matrix[i][0] == 0) {
	            zeroRow(matrix, i);
	        }
	    }

	    for (int j = 1; j < matrix[0].length; j++) {
	        if (matrix[0][j] == 0) {
	            zeroCol(matrix, j);
	        }
	    }

	    if (firstRowZero) {
	        zeroRow(matrix, 0);
	    }

	    if (firstColZero) {
	        zeroCol(matrix, 0);
	    }
	}

	public static void zeroRow(int[][] matrix, int row) {
	    for (int j = 0; j < matrix[0].length; j++) {
	        matrix[row][j] = 0;
	    }
	}

	public static void zeroCol(int[][] matrix, int col) {
	    for (int i = 0; i < matrix.length; i++) {
	        matrix[i][col] = 0;
	    }
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,0,4},
							{5,0,7,8},
							{9,10,0,12},
							{13,14,15,16}};
		zeroMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
}
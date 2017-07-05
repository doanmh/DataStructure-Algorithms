package ctci.chapter01.question07_RotateMatrix;

public class Question07Answer {
	public static void rotate(int[][] matrix) {
	    if (matrix.length == 0 || matrix.length != matrix[0].length) {
	        return;
	    } 
	    int n = matrix.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i; j < n - i - 1; j++) {
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][n - i - 1];
	            matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
	            matrix[n - i - 1][n - j - 1] = matrix[n - j - 1][i];
	            matrix[n - j - 1][i] = temp;
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4, 5, 6},
				 {7, 8, 9, 10, 11, 12},
				 {13, 14, 15, 16, 17, 18},
				 {19, 20, 21, 22, 23, 24},
				 {25, 26, 27, 28, 29, 30},
				 {31, 32, 33, 34, 35, 36}};
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
}

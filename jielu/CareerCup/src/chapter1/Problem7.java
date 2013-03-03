package chapter1;

/**
 * From Cracking the code interview
 * Problem 1.7: Write an algorithm such that if an element in an M*N matrix is 0,
 * its entire row and column is set to 0.
 * Finished on 3/2/2013
 * @author jielu
 *
 */
public class Problem7 {
	public static void setZeros(int[][] matrix){
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int[] rows = new int[rowSize];
		int[] cols = new int[colSize];
		
		int i=0, j=0;
		for( i=0; i<rowSize; i++){
			for(j=0; j<colSize; j++){
				if(matrix[i][j] == 0){
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		
		for( i=0; i<rowSize; i++)
			for(j=0; j<colSize; j++){
				if(rows[i] == 1 || cols[j] == 1)
					matrix[i][j] = 0;
			}
			
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

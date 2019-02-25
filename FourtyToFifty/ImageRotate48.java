package FourtyToFifty;

public class ImageRotate48 {
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length ==0) return;
        int top = 0;
        int left = 0;
        int right = matrix.length - 1;
        int bot =matrix.length - 1;
        int n = matrix.length - 1;
        while(n > 0) {
        	for(int i = 0; i < n; i++) {
        		int tmp = matrix[top][left + i];
        		matrix[top][left + i] = matrix[bot - i][left];
        		matrix[bot - i][left] = matrix[bot][right - i];
        		matrix[bot][right - i] = matrix[top + i][right];
        		matrix[top + i][right] = tmp;
        	
        	}
        top++;
        left++;
        right--;
        bot--;
        n = n - 2;
        }
    }
}

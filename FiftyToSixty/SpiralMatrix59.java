package FiftyToSixty;

public class SpiralMatrix59 {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n <= 0) return res;
        int top = 0, bot = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        while(top < bot && left < right) {
        	for(int i = left; i < right; i++) {//i是从left开始，而不是从0开始
        		res[top][i] = num;
        		num++;
        	}
        	for(int i = top; i < bot; i++) {//i是从top开始，而不是从0开始
        		res[i][right] = num;
        		num++;
        	}
        	for(int i = right; i > left; i--) {
        		res[bot][i] = num;
        		num++;
        	}
        	for(int i = bot; i > top; i--) {
        		res[i][left] = num;
        		num++;
        	}
        	top++;
        	right--;
        	bot--;
        	left++;
        }
        if(n % 2 == 1) res[n/2][n/2] = num;
        return res;
    }
}

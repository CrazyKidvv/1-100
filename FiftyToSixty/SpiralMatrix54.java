package FiftyToSixty;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0, bot = matrix.length - 1;
        int right = matrix.length - 1, left = 0;
        while(top < bot && left < right) {
        	for(int i = left; i < right; i++) {
        		res.add(matrix[top][i]);
        	}
        	for(int i = top; i < bot; i++) res.add(matrix[i][right]);
        	for(int i = right ; i > left; i--) res.add(matrix[bot][i]);
        	for(int i = bot; i > top; i--) res.add(matrix[i][left]);   
        	left++;
        	right--;
        	top++;
        	bot--;
        }
        if(top == bot) {
        	for(int i = left; i <= right; i++) {
        		res.add(matrix[top][i]);
        	}
        }else if(left == right) {
        	for(int i = top; i <= bot; i++) {
        		res.add(matrix[i][left]);
        	}
        }
        return res;
    }
}

package SeventyTo80;

import javax.sound.midi.MidiChannel;
import javax.swing.RowFilter;

public class Search2Dmatrix {
	public static void main(String[] args) {
		int[][] matrix = {{-9,-8,-8},{-5,-3,-2},{0,2,2},{4,6,8}};
		int target = 2;
		System.out.println(searchMatrix2(matrix, target));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null) return false;
		if(matrix[0][0] > target) return false;
        int row = 0;
        boolean res = false;
        int a = matrix.length;
        if(a == 0) return false;
        int b = matrix[0].length;
        if(b == 0 ) return false;
        for(int i = 0; i < a; i++) {
        	if(matrix[i][0] < target) {
        		row++;
        	}else if(matrix[i][0] > target) {
        		row--;
        		break;
        	}else if(matrix[i][0] == target) {
        		return true;
        	}
        }
        if(row > a - 1) row--;
        int start = 0;
        int end = b - 1;
        while(start + 1 < end) {
        	int mid = start + (end - start)/2;
        	if(matrix[row][mid] < target) {
        		start = mid;
        	}else if(matrix[row][mid] == target) {
        		res = true;
        		break;
        	}else if(matrix[row][mid] > target) {
        		end = mid;
        	}
        }
        return res;
    }
	public static boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int endrow = matrix.length - 1;
		int endcol = matrix[0].length - 1;
		int start = 0;
		int row = 0;
		boolean res = false;
		while(start + 1 < endrow) {//二分法找到在哪一行
			int mid = start + (endrow - start)/2;
			if(matrix[mid][endcol] == target) row = mid;//可有可无
			if(matrix[mid][endcol] > target) {
				endrow = mid;
			}else start = mid;			
		}
		if(matrix[start][endcol] >= target) {
			row = start;
		}else if(matrix[endrow][endcol] >= target) {
			row = endrow;
		}else {
			row = endrow;
		}
//		}else {
//			row = 0;
//		}
		
		int start2 = 0;
		while(start2 + 1 <endcol) {//二分法找在哪一列
			int mid = start2 + (endcol - start2)/2;
			if(matrix[row][mid] == target) return true;//可有可无
			if(matrix[row][mid] > target) {
				endcol = mid;
			}else start2 = mid;
		}
		if(matrix[row][start2] == target || matrix[row][endcol] == target) return true;
		return res;
	}
}

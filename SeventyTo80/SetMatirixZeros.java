package SeventyTo80;

import java.util.ArrayList;

import org.omg.PortableInterceptor.IORInterceptor;

public class SetMatirixZeros {
	public void setZeroes(int[][] matrix) {
		int a = matrix.length;
		int b = matrix[0].length;
		ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> indexs = new ArrayList<>();
        for(int i = 0; i < a; i++) {//遍历整个矩阵，找到0所在位置的坐标
        	for(int j = 0; j < b; j++) {
        		if(matrix[i][j] == 0) {
        			index.add(i);//新建两个arraylist存储0的纵横左边
        			indexs.add(j);
        		}
        	}
        }
        int c = index.size();
        for(int j = 0; j < c; j++) {//遍历每个0所在的位置，将其纵横赋为0
        	for(int i = 0; i < a; i++) {
            	//matrix[index.get(j)][i] = 0;
            	matrix[i][indexs.get(j)] = 0;
        	}
        	for(int z = 0; z < b; z++) {
            //	matrix[z][indexs.get(j)] = 0;
            	matrix[index.get(j)][z] = 0;
            }
        }
    }
	public void setZeroes2(int[][] matrix) {
		boolean firstrowzero = false;
		boolean firstcolumzero = false;
		int a = matrix.length;
		int b = matrix[0].length;
		for(int j = 0; j < b; j++) {
			if(matrix[0][j] == 0) {
				firstrowzero = true; 
				break;	
			}
		}
		for(int j = 0; j < a; j++) {
			if(matrix[j][0] == 0) {
				firstcolumzero = true; 
				break;
			}
		}
		for(int i = 1; i < a; i++) {
			for(int j = 1; j < b; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
//		for(int i = 1; i < b; i++) {//遍历（1，1）之后的所有点，
//			for(int j = 1; j < a; j++) {
//				if(matrix[j][i] == 0) {
//					matrix[i][0] = 0;//有0就给最左边的横坐标赋0
//					matrix[0][j] = 0;//给最上面的横坐标赋0
//				}
//			}
//		}
		for(int i = 1; i < b; i++) {//若最上有0，则将一数列赋为0
			if(matrix[0][i] == 0) {
				for(int j = 1; j < a; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		for(int i = 1; i < a; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 1; j < b; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		if(firstcolumzero == true) {
			for(int i = 0; i < a; i++) {
				matrix[i][0] = 0;
			}
		}
		if(firstrowzero == true) {
			for(int i = 0; i < b; i++) {
				matrix[0][i] = 0;
			}
		}
	}
}

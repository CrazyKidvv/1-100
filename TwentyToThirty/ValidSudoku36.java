package TwentyToThirty;

import java.util.HashMap;

public class ValidSudoku36 {
	public boolean isValidSudoku(char[][] board) {
		//判断每一行是否有重复
		for(int i = 0; i < 9; i++) {
			if(!isValidRows(board[i])) {
				return false;
			}
		}
		//判断每一列是否有重复
		for(int i = 0; i < 9; i++) {
			if(!isValidCol(i, board)) {
				return false;
			}
		}
		//判断小棋盘里是否有重复
		for(int i = 0; i < 9; i = i + 3) {
			for(int j = 0; j < 9; j = j + 3) {
				if(!isValidSmall(i, j, board)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValidRows(char[] board) {//a[0]即可代表一整行
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hashMap = new HashMap<>();//hashmap<key,value>，key不能重复，value可以重复
		for(char c : board) {
			if(c != '.') {
				if(hashMap.getOrDefault(c, 0) != 0) {//判断字符c是否在hashmap里，默认值为0，所不在,value是默认值，若在，value已被赋为1
					return false;
				}else {
					hashMap.put(c, 1);//将每一个遍历到的字符放进hashmap里，并将其value赋为1
				}
			}
		}
		return true;
		}
	
	public boolean isValidCol(int col, char[][] board) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for(int j = 0; j < 9; j++) {
			char c = board[j][col];//【1，0】，【2，0】，【3，0】为列的坐标，判断每一列
			if(c != '.') {
				if(hashMap.getOrDefault(c, 0) != 0) {
					return false;
				}else {
					hashMap.put(c, 1);
				}
			}
		}
		return true;
	}

	public boolean isValidSmall(int row, int col, char[][] board) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				char c = board[row + i][col + j];
				if(c != '.') {
					if(hashMap.getOrDefault(c, 0)!= 0) {
						return false;
					}else {
						hashMap.put(c, 1);
					}
				}
			}
		}
		return true;
	}
}

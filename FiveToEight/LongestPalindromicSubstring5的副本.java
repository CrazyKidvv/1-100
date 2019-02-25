package FiveToEight;

public class LongestPalindromicSubstring5 {//最长回文序列

	public static void main(String[] args) {
		String str1 = "abcdc";
		//String aString = LongestPalindromicSubstring3(str1);
		String aString = longestPalindrome(str1);
		System.out.println(aString);
	}
	
	//方法一：brute force
	public static String LongestPalindromicSubstring(String s) {//brute force
		int n = s.length();
		String res = null;
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i +1 ;j < n; j++) {
				int len = j - 1;
				String curr;
				curr = s.substring(i, j+1);
				if(checkPalindromic(curr)) {
					if(len > max) {
						max = len;
						res = curr;
					}					
				}
			}
		}
		return res;
	}
	private static boolean checkPalindromic(String s) {
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;//一旦有不满足的，则返回假。return true和return false不能换位置，否则，则是一旦满足就返回真，不能全部遍历之后得到答案
			}
		}
		return true;
	}
	//方法二：
	public static String LongestPalindromicSubstring2(String s) {
		if(s == null || s.length() == 1) return s;
		String res = null;
		int max =0;
		boolean [][] dp= new boolean[s.length()][s.length()];//dp[i][j]：从i到j是回文的
		for(int j = 0; j < s.length(); j++) {
			for(int i = 0; i <= j; i++) {
				if(s.charAt(j) == s.charAt(i)) {	
//第一个if是为啥？
					if(j-i<=2 || dp[i+1][j-1]) {
						dp[i][j] = true;
					}
				}
				if(dp[i][j]) {
					if(j-i+1>max) {
						max = j-i+1;
						res = s.substring(i, j+1);//subString结束与j+1-1
					}
				}
				}
			}	
		return res;
		}
	
	//方法三：找到中心向两边拓展，中心是1个数或中心为两个数
	static String res = null;
	public static String LongestPalindromicSubstring3(String s) {
		for(int i = 0;i < s.length();i++) {
			helper(s,i,i);//回文序列由奇数个数组成
			helper(s,i,i+1);//回文序列由偶数个组成
		}
		return res;
	}
	private static void helper(String s, int left, int right) {
		while(left >= 0 && right < s.length()) {
			if(s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
		}
		String cur = s.substring(left+1, right);//返回right-1到left+1的序列，因为之前等的时候将左右指针移动了，实际这两个数不回文
		if(cur.length() > s.length()) {
			res = cur;
		}
	}
	
	public static String longestPalindrome(String s) {
	    String res = "";
	    int max = 0;
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    for(int j = 0; j < s.length(); j++){
	        for(int i = 0; i <= j; i++){
	            if(s.charAt(i) == s.charAt(j)){
	                if(dp[i+1][j-1]){
	                    dp[i][j] = true;
	                }
	            }
	            if(dp[i][j]){
	                if(j - i > max){
	                    max = j - i;
	                    res = s.substring(i,j+1);
	                }
	            }
	        }
	    }
	    return res;
	}
}


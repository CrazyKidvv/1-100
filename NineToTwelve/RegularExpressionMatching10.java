package NineToTwelve;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
		String s = "ab";
		String p = "a.";
		System.out.println(isMatch(s, p));

	}
	
	//dp[i][j]表示0-i,0-j是否匹配
	public static boolean isMatch(String s, String p) {
		if(s == null || p == null) return false;
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;//因为00为初始化值，所以dp大小为length+1;
		for(int i = 0; i < p.length(); i++) {//aab c*aab将该情况c*删除，将当前状态设为初始
			if(p.charAt(i) == '*' && dp[0][i-1]) {
				dp[0][i+1] = true;
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < p.length(); j++) {
				if(p.charAt(j) == s.charAt(i)) {//Situation 1: aa与aa匹配
					dp[i+1][j+1] = dp[i][j];
				}
				if(p.charAt(j) == '.'){ //Situation 2: aa与a.匹配 
					dp[i+1][j+1] = dp[i][j];
				}
				if(p.charAt(j) == '*') {
					if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//Situation 3: aab与c*aab匹配,*代表0
						dp[i+1][j+1] = dp[i+1][j-1];
					}else {//aa与a*，
						dp[i+1][j+1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1] );//Situation 4: aa与a*（* represents a single a）; aaa a*(multiple a);
					}
				}
			}
		}return dp[s.length()][p.length()];//最后一位为什么则是什么
	} 

}

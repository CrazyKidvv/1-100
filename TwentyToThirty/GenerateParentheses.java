package TwentyToThirty;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 3;
		List<String> aList = generateParenthesis(n);
		System.out.println(aList);
	}
	
	public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {//判断现在是否是有效答案
            ans.add(cur);
            return;
        }

        if (open < max)//左括号不足，可以继续添加
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)//添加右括号
            backtrack(ans, cur+")", open, close+1, max);
    }
}

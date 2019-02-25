package SeventeenToTwenty;

import java.util.Stack;

public class ValidParentheses20 {

	public static void main(String[] args) {
		String s = "(";
		System.out.println(isValid2(s));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray()) {
			if(ch == '(') {
				stack.push(')');
			}else if(ch == '{') {
				stack.push('}');
			}else if(ch == '[') {
				stack.push(']');
			}else {
				if(stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static boolean isValid2(String s) {
        if(s.length() == 0 || s == null) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch =='['){
                stack.push(']');
            }else{
                if(stack.pop() != ch) {
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
}
}

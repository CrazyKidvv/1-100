package SeventyTo80;

import java.util.Stack;

public class SimplfyPath71 {//路径问题大多用stack做
	public static void main(String[] args) {
		String path = "home/";
		System.out.println(simplifyPath(path));
	}
	public static String simplifyPath(String path) {
		if(path.length() <=1 ) return path;
        String[] each = path.split("/");//split之后是“”和“home”
        Stack<String> stack = new Stack<String>();
        for(String curr : each) {
        	if(curr.equals("..")) {
        		if(!stack.isEmpty()) {
        			stack.pop();
        		}
        	}else if(!curr.equals(".") && !curr.isEmpty()){
   //     	}else if(!curr.equals(".") ) {//如果没有后面的条件的话，“”也会被push进栈
        		//之后出栈时会多一个“/”
        		stack.push(curr);
        	}
        }
        String result = "";
        if(stack.empty()) return "/";
        //stack的empty方法和isEmpty方法的区别：stack自己有的方法时empty，isEmpty是
        //stack从vetor中继承下来的，用法上没有区别
        while(!stack.empty()) {
        	String nowpop = stack.pop();
        	result = "/" + nowpop + result;
        }
        return result;
    }
}

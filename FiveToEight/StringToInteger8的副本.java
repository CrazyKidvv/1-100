package FiveToEight;

public class StringToInteger8 {//String to Integer

	public static void main(String[] args) {
		String aString = "42";
		int a = myAtoi(aString);
		System.out.println(a);
	}
	
	public static int myAtoi(String str) {//判断正负，判断是否数字，不是越界，
		if(str == null || str.length() == 0) return 0;
		str = str.trim();//去掉两端的空格
		char firstChar = str.charAt(0);
		int sign = 1;
		int start = 0;	
		long res = 0;
		if(firstChar == '+') {
			sign = 1;
			start++;
		}else if(firstChar == '-') {
			sign = -1;
			start++;
		}
		for(int i = start; i < str.length(); i++) {//如果有不是数字的值出现，输出之前的数字
			if(!Character.isDigit(str.charAt(i))) {
				return (int) res * sign;
			}
			res = res * 10 + str.charAt(i) -'0' ;//-0将char转换成int
			if(sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if(sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
		}
		return (int) res * sign;
	}

}

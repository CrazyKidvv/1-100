package ThirteenToSixteen;

public class RomanToInteger13 {

	public static void main(String[] args) {
		String s = "III";
		System.out.println(romanToInt(s));

	}

	public static int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = toNumber(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {//当右边大于左边，值 = 右 - 左
        	if(toNumber(s.charAt(i)) > toNumber(s.charAt(i-1))) {
        		res += toNumber(s.charAt(i)) -  2 * toNumber(s.charAt(i-1));
        	}else {
        		res += toNumber(s.charAt(i));
        	}
        }
        return res;
    }
	
	public static int toNumber(char c) {
		int res = 0;
		switch (c) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		}
		return res;
	}
	
	public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
                while(strs[i].indexOf(res) != 0 ){
                    res = res.substring(0,strs[i].length()-1);
                }
            }
        return res;
    }
}

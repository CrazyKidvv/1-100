package ThirteenToSixteen;

public class LongestCommonPrefix14 {

	public static void main(String[] args) {
		String [] aStrings = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(aStrings));
	}
	
	//方法一：Horizontal scanning：取出第一个数和第二个数的公共部分，以此类推
	public static String longestCommonPrefix1(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {//indexOf返回flower（prefix）在flow(strs[i])的第几位出现,没出现则返回-1
	            prefix = prefix.substring(0, prefix.length() - 1);//没有出现则不断把flower截短
	            if (prefix.isEmpty()) return "";//如果一直没有出现，截短为空是证明没重复部分
	        }        
	    return prefix;
	}

	//方法二：Vertical scanning:将第一个数的每一位和之后的数的每一位比较
	public static String longestCommonPrefix2(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)//若遍历完了某个数
	                return strs[0].substring(0, i);   //某一个数的第i位和第一个数不同，则返回这一位之前的数          
	        }
	    }
	    return strs[0];
	}
	
	//方法三： Divide and Conquer
	public static String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private static String longestCommonPrefix(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix(strs, l , mid);
	        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	static String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}
}

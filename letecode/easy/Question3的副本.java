package letecode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question3 {

	public static void main(String[] args) {
		String teString = "abccba";
		int a;
		a = lengthOfLongestSubstring21(teString);
		System.out.println(a);
	}
	
	//方法一：brute force
	    public static int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        int ans = 0;
	        for (int i = 0; i < n; i++)
	            for (int j = i + 1; j <= n; j++)
	            //    if (allUnique(s, i, j)) {
	               if (allUnique2(s, i, j)){
	                	ans = Math.max(ans, j - i);
	                }
	             // }
	        return ans;
	    }

	    public static boolean allUnique(String s, int start, int end) {//当传入的字串不重复的时候，返回真，ans取最大值
	        HashMap<Character,Character> map = new HashMap<>();//Hashmap
	        for (int i = start; i < end; i++) {
	            Character ch = s.charAt(i);//遍历取出第i个字符
	            if (map.containsKey(ch)) {//判断第i个字符是否在set里
	            	return false;//若有重复，返回假，该i，j的组合搭配不需要计算ans
	            }
	            map.put(ch,ch);//不管字符在不在字符里，将遍历过的字符加入到set里，以便之后查找重复
	        }
	        return true;
	    }

	    public static boolean allUnique2(String s, int start, int end) {
	        Set<Character> set = new HashSet<>();
	        for (int i = start; i < end; i++) {
	            Character ch = s.charAt(i);
	            if (set.contains(ch)) {
	            	return false;
	            }
	            set.add(ch);
	        }
	        return true;
	    }
	
	  //方法2：sliding window
	    public static int lengthOfLongestSubstring2(String s) {//自己修改的不带ans变量
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	//        int ans = 0;
	        int i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(i))){//如果set里不包含i，将该值添加进去后j+1，继续移动窗口
	                set.add(s.charAt(j));
	                j++;
	   //             ans = Math.max(ans, j - i);
	                int ans = j-i;
	            }
	            else {//如果set里包含i,则将窗口右移，将原有的i从窗口中删去
	                set.remove(s.charAt(i));
	                i++;
	            }
	        }
	        return j-i;
	    }
	    
	    public static int lengthOfLongestSubstring21(String s) {//letecode答案
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
	    
	    //方法三：进阶版sliding window
	    public static int lengthOfLongestSubstring3(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {//若该值存在，则直接完全跳转到新的substring
            //    i = Math.max(map.get(s.charAt(j)), i);//取max：重复出现之前出现过的字符时，若不取最大，有可能序列会往前重新取
                i = map.get(s.charAt(j));
	            }
	            ans = Math.max(ans, j - i + 1);//返回当前所遍历到的最长子串，如果i被重新赋值，则返回了ans
	            map.put(s.charAt(j), j + 1);//将当前遍历得到的值和当时位置存储在hashmap里
	            System.out.println(map.get(s.charAt(j)));
	        }
	        return ans;
	    }
	    
	    public static int lengthOfLongestSubstring32(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {//若该值存在，则直接完全跳转到新的substring
	                i = Math.max(map.get(s.charAt(j))+1, i);//为什么要max，而不是直接取j所在位置
	       //         i = map.get(s.charAt(j));
	            }
	            ans = Math.max(ans, j - i + 1);//返回当前所遍历到的最长子串，如果i被重新赋值，则返回了ans
	            map.put(s.charAt(j), j);//将当前遍历得到的值和当时位置存储在hashmap:key为字符，value为位置
//?
	        }
	        return ans;
	    }
	    
	    public static int lengthOfLongestSubstring4(String s) {
	        int i = 0;
	        int j = 0;
	        int ans = 0;
	        Set<Character> set = new HashSet<>();
	        while(i < s.length() && j < s.length()){
	            if(set.contains(s.charAt(j))){
	                set.remove(s.charAt(i));
	                i++;
	            }else{
	                set.add(s.charAt(j));
	                ans = Math.max(ans, j-i);
	                j++;
	            }
	        }
	        return ans;
	    }
	}

//Hashset:
//set.contains(ch);      判断set中是否有ch，含有为真
//set.add(ch);           将ch元素添加进set中
//set.remove(s.charAt(i)); 从set中删除元素

//Hashmap有key,value对应关系，hashset只有单个值:
//map.containsKey(ch)
// map.put(ch,ch)

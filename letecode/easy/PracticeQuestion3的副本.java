package letecode.easy;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PracticeQuestion3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "abcdcba";
		//int a = LongestSubstring(aString);
		int a = LongestSubstring3(aString);
		System.out.println(a);
		
	}
	
	public static int LongestSubstring(String s) {
		int max = 0;
		for(int i = 0; i < s.length();i++) {
			for(int j = i+1; j <= s.length(); j++) {//j的取值范围写错
				if(Equals(s,i,j)) {//不重复的时候，返回真
					max = Math.max(max, j-i);
				}
			}
		}return max;
	}

	private static boolean Equals(String s, int start, int end) {
		// TODO Auto-generated method stub
		Set<Character> set = new HashSet<>();
		for(int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if(set.contains(ch)) {
				return false;
			}
			set.add(ch);//这一句没有加上
		}
		return true;
	}
	
	public static int LongestSubstring2(String s) {
		int i = 0; int j = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		while(i < s.length() && j < s.length()) {
			if(set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			}else {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, j-i);
			}
		}
		return max;
	}
	
	public static int LongestSubstring3(String string) {
		int max = 0;
		HashMap<Character,Integer> map = new HashMap();
		for(int i = 0, j = 0; j< string.length();j++) {
			if(map.containsKey(string.charAt(j))) {
				i = Math.max(i, map.get(string.charAt(j))+1);
			}
			max = Math.max(max, j-i+1);
			map.put(string.charAt(j), j);
		}
		return max;
	}
}

package FourtyToFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrmas {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs.length == 0 || strs == null) return res;
    	HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
        	char[] cur = strs[i].toCharArray();//将字符串转换成一个字符数组
        	Arrays.sort(cur);//将各个字符按自然顺序排序
        	String key = String.valueOf(cur);//因为map的key value存储类型，把字符数组转化成字符串
        	if(!map.containsKey(key)) {//这个顺序不存在
        		map.put(key, new ArrayList<>());//把该顺序放入map中，为他新建value的list
        	}
        	map.get(key).add(strs[i]);//取的key值的value list，将同类的添加进去，并且添加该值因为无论if执行与否这句代码都会执行
        }
        return new ArrayList<List<String>>(map.values());//返回map里的value
    }
}

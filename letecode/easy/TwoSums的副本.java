package letecode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
	public static void main(String args[]) {
		int[] nums2 = {2,7,11,15};
		int target = 17;
		int[] result = twoPassSum(nums2, target);
		for(int i=0; i < result.length; i++) {
			System.out.print(result[i]);
		}
//		System.out.println(result[0] + "" + result[1]);
	}
	public static int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] == target - nums[j]) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	
	public static int[] twoPassSum(int[] nums2, int target) {
		Map<Integer, Integer> hashmap = new HashMap<>();	//新建一个hashmap对象	
		for(int i = 0; i < nums2.length; i++) {
			int complement = target - nums2[i];
			if(hashmap.containsKey(complement)){//如果hashmap里有这个值
				return new int[] {i,hashmap.get(complement)};//返回这一对数
			}
			hashmap.put(nums2[i], i);//value,key  ???
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
//containsKey(Object key)                   如果此映射包含指定键的映射关系，则返回 true。           
//containsValue(Object value)               如果此映射将一个或多个键映射到指定值，则返回 true。   
//put(K key, V value)                       将指定的值与此映射中的指定键关联（可选操作）。

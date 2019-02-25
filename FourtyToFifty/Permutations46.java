package FourtyToFifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations46 {
	 public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}
	 public static List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 if(nums == null || nums.length == 0) return list;
		 backtrack(list, new ArrayList<>(), nums, new HashSet<Integer>());
	//	 backtrack2(list, new ArrayList<>(),nums);
		 return list;
	    }

	private static void backtrack2(List<List<Integer>> list, List<Integer> templist, int[] nums) {
		// TODO Auto-generated method stub
		if(templist.size() == nums.length) {
			list.add(new ArrayList<>(templist));
		}else {
			for(int i = 0; i < nums.length; i++) {
				if(templist.contains(nums[i])) {
					continue;
				}
				templist.add(nums[i]);
				backtrack2(list, templist, nums);
				templist.remove(templist.size() - 1);
			}	
		
		}
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> cList, int[] nums,
			HashSet<Integer> hashSet) {
		// TODO Auto-generated method stub
		if(cList.size() == nums.length) {
			list.add(new ArrayList<>(cList));
		}else {
			for(int i = 0; i < nums.length; i++) {
				if(!hashSet.contains(nums[i])) {
					cList.add(nums[i]);
					int last = cList.size() - 1;
					hashSet.add(nums[i]);
					backtrack(list, cList, nums, hashSet);
					hashSet.remove(nums[i]);// 这里为什么不是last：因为hashset添加数的时候不是按照顺序添加的，所以移除的时候只能用i为指针而不是最后一个
					cList.remove(last);
				}
			}
		}
	}
	
	

}

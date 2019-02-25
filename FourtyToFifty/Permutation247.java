package FourtyToFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation247 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		backtrack(res, new ArrayList<>(),new boolean[nums.length], nums);
		return res;  
	}

	private void backtrack(List<List<Integer>> res, List<Integer> list, boolean[] used, int[] nums) {
		// TODO Auto-generated method stub
		if(list.size() == nums.length) {
			res.add(new ArrayList<>(list));
		}else {
			int preNum = nums[0] - 1;//每次循环都将其初始化为一个无效的数字：prenum定义该数字在之前有无重复被使用过，去重
			for(int i = 0; i < nums.length; i++) {
				if(used[i] == false && (nums[i] != preNum)) {//
					preNum = nums[i];
					list.add(nums[i]);
					used[i] = true;//boolean判断给定nums中的数有无被用过，不能用set，因为给定数组中有重复数字
					backtrack(res, list, used, nums);
					used[i] = false;
					list.remove(list.size() - 1);
				}
			}
		}
	}
}

package ThirtyToFourty;

public class SearchInRotated33 {
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		int start = 0;
		int end = nums.length - 1;
		while(start + 1 < end) {//至少有三个数，否则无法计算mid
			int mid = (end - start) / 2 + start;//二分法
			if(nums[mid] == target) return mid;//三个数一个start 一个end 一个mid，若等于target,则都赋过值
			if(nums[start] < nums[mid]) {//判断前半段是不是递增的：是递增的情况执行以下
				if(nums[start] <= target && nums[mid] >= target) {//target在前半段，向前缩短
					end = mid;
				}else {
					start = mid;
				}
			}else {//前半段不是递增的，则在后半段找
				if(target <= nums[end] && nums[mid]  <= target) {//target在后半段，向后缩短
					start = mid;
				}else {
					end = mid;//否则在前半段找
				}
			}
	}
		if(nums[start] == target) return start;
		if(nums[end] == target)  return end;
		return -1;
	}
}

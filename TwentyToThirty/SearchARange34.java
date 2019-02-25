package TwentyToThirty;

public class SearchARange34 {
	public int[] searchRange(int[] nums, int target) {//暴力解
        int start = -1;
        int end = -1;
        int num = 0;
        int[] res = new int[2];
        for(int i = 0 ; i <= nums.length - 1; i++){
            if(nums[i] == target){
                end = i;
                num++;
            }
        }
        if(end == -1) {
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        start = end - num + 1;
        res[0] = start;
        res[1] = end;
        return res;        
    }
	
	public int[] searchRange2(int[] nums, int target) {//从左或从右各遍历一遍找出左右坐标
		int start = -1;
		int end = -1;
		int[] res = new int[2];
		for(int i = 0; i <= nums.length - 1; i++) {
			if(nums[i] == target) {
				start = i;
				break;
			}
		}
		if(start == -1) {
			res[0] = -1;
        	res[1] = -1;
        	return res;
		} 
		for(int i =nums.length - 1; i >= 0 ; i--) {
			if(nums[i] == target) {
				end = i;
				break;
			}
		}
		
	res[0] = start;
	res[1] = end;
	return res;
	}
	
	public int[] searchRange3(int[] nums, int target) {
		if(nums == null || nums.length == 0) return new int[] {-1,-1};
		int start = findFirst(nums, target);
		if(start == -1) return new int[] {-1,-1};
		int end = findLast(nums, target);
		return new int[] {start,end};
	}
	
	public static int findFirst(int[] nums, int target) {//binary search
		int start = 0;
		int end = nums.length - 1;
		while(start + 1 < end) {
			int mid = (start + end) / 2 + start;
			if(nums[mid] < target) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(nums[start] == target) return start;
		if(nums[end] == target) return end;
		return -1;		
	}
	public static int findLast(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = (start + end) / 2 + start;
		while(start + 1 < end) {
			if(nums[mid] > target) {
				end = mid;
			}else {
				start = mid;
			}
		}
		if(nums[end] == target) return end;
		if(nums[start] == target) return start;
		return -1;
	}
}

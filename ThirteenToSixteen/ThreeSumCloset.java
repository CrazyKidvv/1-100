package ThirteenToSixteen;

import java.util.Arrays;

public class ThreeSumCloset {

	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(threeSumClosest2(nums,target));
	}

	 public static int threeSumClosest2(int[] nums, int target) {
	        int res = 0;
	        Arrays.sort(nums);
	        for(int i = 0; i < nums.length - 2; i++) {
	        	res = nums[i];
	        	int low = i + 1, high = nums.length - 1, a = 0, dif = 0, b = 0;
	        	while(low < high) {
	        		res += nums[low] + nums[high];
	        		dif = res - target;
	        		if(dif < target) {
	        			low++;
	        		}else if(dif > target) {
	        			high--;
	        		}else {
	        			return res;
	        		}
	        	}	        	
	        }
	        return res;
	    }
	 
	 public static int threeSumClosest(int[] nums, int target) {
		 Arrays.sort(nums);
		 int res = nums[0] + nums[1] + nums[nums.length - 1];
		 for(int i = 0; i < nums.length - 2; i++) {
			 int start = i + 1, end = nums.length - 1;
			 int max = nums[i] + nums[start] + nums[end];
			 while(start < end) {
				 if(max > target) {
					 end--;
				 }else {
					 start++;
				 }
				 if(Math.abs(max - target) < Math.abs(res - target)) {
					 res = max;
				 }
			 }
		 }
		 return res;
	 }
}

package ThirtyToFourty;

import java.rmi.UnmarshalException;

public class NextPermutation31 {
	   public void nextPermutation(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int FirstSmall = -1;
		for(int i = nums.length - 2; i >= 0; i--) {
			if(nums[i] < nums[i+1]) {
				FirstSmall = i;
				break;
			}
		}
		if(FirstSmall == -1) {
			reverse(nums, 0, nums.length - 1);
            return;
		}
		
		int FirstLarge = -1;
		for(int i = nums.length - 1; i > FirstSmall; i--) {
			if(nums[i] > nums[FirstSmall]) {
				FirstLarge = i;
				break;
			}
		}
		
		swap(nums, FirstSmall, FirstLarge);
		reverse(nums, FirstSmall + 1, nums.length - 1);
        return;
	}	
		
		
		
		public static void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
	public static void reverse(int[] nums, int i, int j) {
			while(i < j) {
				swap(nums, i, j);
                i++;
                j--;
			}
		}
	}


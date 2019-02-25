package SeventeenToTwenty;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.Highlighter.Highlight;

public class FourSums {

	public static void main(String[] args) {
		int[] sums = {-1, 0, 1, 2, -1, -4};
		int target = -2;
		System.out.println(fourSum(sums, target));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++) {
        	if(i > 0 && nums[i] == nums[i-1]) continue;
        	for(int j = i + 1;j < nums.length - 2; j++) {
        		if(j > i + 1 && nums[j] == nums[j-1]) continue;
        		int left = j + 1, right = nums.length - 1;
        		while(left < right) {
            		if(nums[i] + nums[j] + nums[left] + nums[right] == target) {
            			ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            			while(left < right && nums[left] == nums[left + 1]) left++;
            			while(left < right && nums[right] == nums[right - 1]) right--;
            			left++;
            			right--;
                	}else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                		right--;
                	}else {
                		left++;
                	}
        		}	
        	}
        }
        return ret;
    }
}

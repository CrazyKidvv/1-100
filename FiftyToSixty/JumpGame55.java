package FiftyToSixty;

public class JumpGame55 {
	public boolean canJump(int[] nums) {		
        if(nums == null || nums.length == 0) return false;
        int reach = 0;
        for(int i = 0; i < nums.length && i <= reach; i++) {//保证所遍历的数是数组可以达到的
        	reach = Math.max(nums[i] + i, reach);
        	if(reach >= nums.length - 1) {
        		 return true;
        	}
        }
        return false;
    }
}

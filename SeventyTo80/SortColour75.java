package SeventyTo80;

public class SortColour75 {
	public void sortColors(int[] nums) {//Two Pass数每个数组出现几次，然后将数字再填进nums中
		int NumZero = 0;
		int NumOne = 0;
		int NumTwo = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0) {
        		NumZero++;
        	}else if(nums[i] == 1) {
        		NumOne++;
        	}else {
        		NumTwo++;
        	}
        }
        int i = 0;
        	while(NumZero != 0) {
        		nums[i] = 0;
        		i++;
        		NumZero --;
        	}
        	while(NumOne != 0) {
        		nums[i] = 1;
        		i++;
        		NumOne--;
        	}
        	while(NumTwo != 0) {
        		nums[i] = 2;
        		i++;
        		NumTwo--;
        	}
        }
	 	public void sortColors2(int[] nums) {//one pass: first和last指针
	 		int First = 0;//左边都是0
	 		int Last = nums.length - 1;//右边都是1
	 		while(First < nums.length && nums[First] == 0) {//初始化指针，以防给定数组里最左和最有有0或2
	 			First++;
	 		}
	 		while(Last > 0 && nums[Last] == 2) {
	 			Last--;
	 		}
	 		
	 		int index = First;//指现在遍历到哪里了
	 		while(index <= Last) {
	 			if(nums[index] == 1) {
	 				index++;
	 			}else if(nums[index] == 0) {
	 				switchposition( nums, First, index);
	 				index++;
	 				First++;
	 			}else if(nums[index] == 2) {
	 				switchposition(nums, Last, index);
	 				Last--;
	 			}
	 		}
	 	}
		private void switchposition(int[] nums, int first, int index) {
			// TODO Auto-generated method stub
			int mid = nums[first];
			nums[first] = nums[index];
			nums[index] = mid;
		}
	 	
    }

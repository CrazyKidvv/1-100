package ThirteenToSixteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

	public static void main(String[] args) {
		int[] sums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum2(sums));

	}

	public static List<List<Integer>> threeSumw(int[] nums) {
		int sum = 0;
		List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	List<Integer> res = new ArrayList<>();
        	sum = sum + nums[i];
        	for(int j = 1; j < nums.length; j++) {
        		sum += nums[j];
        		for(int z =  2; z < nums.length; z++) {
        			sum += nums[z];
        			if(sum == 0) {
        				res.add(nums[i]);
        				res.add(nums[j]);
        				res.add(nums[z]);
        				ret.add(res);
        				List<Integer> a = new ArrayList<>();
        			}
        		}
        	}
        }
		return ret;
    }
	
	//标准写法
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue;//去重：跳出这个循环,i+1
//			if(nums[i] == nums[i + 1]) continue;这样会使【-1，-1，2】被跳过
			int ini = nums[i];
			int low = i + 1, high = nums.length - 1, sum = 0 - ini;  
			while(low < high) {
				if(nums[low] + nums[high] == sum) {
					ret.add(Arrays.asList(nums[i], nums[low], nums[high]));
					while(nums[low] == nums[low + 1]) low++;//去重：当下一个与这个相同的时候，跳过这种一样的组合
					while(nums[high] == nums[high - 1]) high--;
					low++;	
					high--;
				}else if(nums[low] + nums[high] < sum) {
					low++;	
				}else {
					high--;
				}
			}
		}
		return ret;
	}
	
	//自己的错误写法：不能套三个for循环，因为循环里有++，--的操作，使for循环中的i++失效
	public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int val = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;    
            val = 0 - nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = nums.length -1; k > j; k--){
                    if(nums[j] + nums[k] == val){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(nums[j] == nums[j + 1]) j++;
                        while(nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    }else if(nums[j] + nums[k] > val){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return res;
    }
}

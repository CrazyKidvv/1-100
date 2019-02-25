package ThirtyToFourty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40题题意：candidates里的数不能重复使用，但candidates里有重复的数则可都用到
public class CombinationSum39 {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(candidates);//先排序后break，加快程序运行
	    backtrack(list, new ArrayList<>(), candidates, target, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] candidates, int target, int start){
	    if(target < 0) return;
	    else if(target == 0) list.add(new ArrayList<>(tempList));//新建一个arraylist保存一个有效值，因为之后的templist还是会不断变化的
	    else{ 
	        for(int i = start; i < candidates.length; i++){//从第一个数字开始遍历
	        	if(candidates[i] > target) break;
	        	//if(i != start && candidates[i] == candidates[i-1]) continue; 去重：不去candidates中重复加入的，去掉重复起始的
	            tempList.add(candidates[i]);//先把该数字加在结果中
	            backtrack(list, tempList, candidates, target - candidates[i], i); 
	        //  backtrack(list, tempList, candidates, target - candidates[i], i + 1);
	            //找到了一个解或者 remain < 0 了，将当前数字移除，然后继续尝试
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}


}

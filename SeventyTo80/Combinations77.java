package SeventyTo80;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();
		if(n <= 0 || k <= 0) return results;
		combineHelper(n, k, 1, results, new ArrayList<Integer>());
		return results;
    }
		private void combineHelper(int n, int k, int st, List<List<Integer>> results, List<Integer> cur) {
			if(k == 0) results.add(new ArrayList<Integer>(cur));
			else {
				for(int i = st; i <= n; i++) {
					cur.add(i);
					combineHelper(n, k-1, i+1, results, cur);
					cur.remove(cur.size() - 1);
				}
			}
		}
}

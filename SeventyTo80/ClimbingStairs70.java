package SeventyTo80;

public class ClimbingStairs70 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(climbStairs2(n));
	}
	public static int climbStairs(int n) {//动态规划
		//记录状态的变量
		int[] state = new int[n + 1];
		//初始化
		state[0] = 1;
		state[1] = 1;
		//转移方程
		for(int i = 2; i <= n; i++) {
			state[i] = state[i-1] + state[i - 2];
		}
		return state[n];
	}
	
	public static int climbStairs2(int n) {//优化
		//可以发现当求n时，只需知道n-1和n-2，即我们不需要一个int数组来存储结果，只需不断更新n-1和n-2
		int pre = 1;
		int cur = 1;
		for (int i = 2; i <= n; i++) {
			cur = cur + pre;
			pre = cur - pre;//此时要把pre变成还未进行上步操作的cur，但是cur已经发生变化了，所以相减得到我们需要的
		}
		return cur;
	}
}

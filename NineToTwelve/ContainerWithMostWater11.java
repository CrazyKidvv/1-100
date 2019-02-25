package NineToTwelve;

public class ContainerWithMostWater11 {

	public static void main(String[] args) {
		int[] a = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea2(a));
	}

	public static int maxArea(int[] height) {
		int max = 0;
		int res = 0;
		for(int i = 0; i < height.length; i++) {
			for(int j = 0; j < i; j++) {
				res = (i-j) * Math.min(height[i], height[j]);
				if(res > max) {
					max = res;
				}
			}
		}
		return max;
	}
	
	public static int maxArea2(int[] height) {
		int res = 0;
		int r = 0, l = height.length - 1; 
		while(r < l) {
			res = Math.max(res, Math.min(height[r], height[l]) * (l - r));
			if(height[r] > height[l]) {
				l--;
			}else {
				r++;
			}
		}
		return res;
	}
}

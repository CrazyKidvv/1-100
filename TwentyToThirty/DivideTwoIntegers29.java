package TwentyToThirty;

public class DivideTwoIntegers29 {
	public static void main(String args[]) {
		int dividend = 10;
		int divisor = 2;
		int ans = divide(dividend, divisor);
		System.out.println("ans = " + ans);
	}
	
	public static int divide(int dividend, int divisor) {//带操作符的问题需要考虑的问题
		int sign = 1;//1.符号：结果默认为正
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ) {
			sign = -1;//若除数或被除数其中一个为负，则结果为负
		}
		long ldividend = Math.abs((long) dividend);//2.越界：一般设为long型，由于已经考虑过符号，所以直接取绝对值计算
		long ldivisor = Math.abs((long) divisor);
		if(ldividend == 0 || ldividend < ldivisor) return 0;//被除数为0或者被除数小于除数的情况，直接返回0，不用后续计算
		long lres = divide(ldividend, ldivisor);//
		int res = 0;
		if(lres > Integer.MAX_VALUE) {//越界时，赋int范围内最大与最小值
			res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}else {
			res = (int)(sign * lres);
		}
		return res;
	}

	private static long divide(long ldividend, long ldivisor) {
		// TODO Auto-generated method stub
		if(ldividend < ldivisor) return 0;//不可少，此处的判断跟18行的判断不同：嵌套在递归中，终止递归
		long sum = ldivisor;
		long multiple = 1;
			while((sum + sum) < ldividend) {
		//可加可不加等号：加等号，不需要多次递归：空间复杂度小于logn，不加等号，空间复杂度等于logn
		//注意是while循环，不是if（自己写错的点）
				sum += sum;
				multiple += multiple;
			}
		return multiple + divide(ldividend - sum, ldivisor);
	}
}

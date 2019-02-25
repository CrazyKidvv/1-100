package FourtyToFifty;

import javax.print.attribute.standard.NumberUpSupported;

public class Pow50 {
	public static void main(String[] args) {
		double x = 1.72777;
		int n = 7;
		double a = myPow(x,n);
		System.out.println(a);
	}
	public static double myPow(double x, int n) {
		double res = 1;
		double num = x;
		int pow = (int)n;
        if(x == 0) return 0;
        if(x == 1 || n == 0) return 1;
        if(n < 0) {
        	//先加1再乘上：因为直接取负对integer.MIN_VALUE并没有用
        	res =  1/(num * myPow(x, -(n + 1)));//不能-1然后把num乘在括号外面：当n是MIN_INTEGER再-1会出现越界
            return res;
        }
        while(pow > 1) {
        	if(pow % 2 ==1) {
        		res = res * num;
        		num = num * num;
        		pow = pow / 2;
        	}else if(pow % 2 == 0) {
        		num = num * num;
        		pow = pow / 2;
        	}
        }
        res = res * num;
        return res;
    }
}

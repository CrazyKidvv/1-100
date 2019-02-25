package FiveToEight;

public class ReverseInteger7 {

	public static void main(String[] args) {
		int x = 123;
		System.out.println(reserve2(x));

	}

	private static int reserve(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }
	
	public static int reserve2(int x) {
		long rev = 0;
		while(x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
			if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;//corner case：越界。数反过来之后超出了整数定义的范围
		}
		return (int)rev;		
		}	
	}


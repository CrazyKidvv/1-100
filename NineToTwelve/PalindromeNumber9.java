package NineToTwelve;

public class PalindromeNumber9 {

	public static void main(String[] args) {
		int a = 12321;
		System.out.println(IsPalindrome2(a));
	}

	public static boolean IsPalindrome(int a) {//没考虑越界
		if(a < 10) return false;
		int rev = 0;
		int b = a;
		while(b != 0) {
			rev = rev * 10 + b % 10;
			b = b / 10;
		}
		if(rev != a) return false;
		return true;
	}
	
	public static boolean IsPalindrome2(int x) {//考虑越界之比较一半
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
 //       return x == revertedNumber || x == revertedNumber/10;
        if(x == revertedNumber || x == revertedNumber/10){
        	return true;
        }
		return false;
    }
}

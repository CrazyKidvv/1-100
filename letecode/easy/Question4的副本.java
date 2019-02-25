package letecode.easy;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {3,5,8,9};
		int[] arr2 = {1,2,7,10,11,12};
		double b = findMedianSortedArrays(arr1, arr2);
		System.out.println(b);
	}
	
	    public static double findMedianSortedArrays(int[] A, int[] B) {
	        int m = A.length;
	        int n = B.length;
	        if (m > n) { // to ensure m<=n 为保证A数组长度较小，因为知道A从哪儿切，用总长度/2-A的长度即为B的长度，算法复杂度为O(log(min(m,n))),为取min，则如果不满足，交换数组A和B的位置
	            int[] temp = A; A = B; B = temp;//将数组A和B交换
	            int tmp = m; m = n; n = tmp;//将两个长度交换
	        }
	        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
	        while (iMin <= iMax) {//使用二分法寻找切数组A的点i
	            int i = (iMin + iMax) / 2;//i为有多少元素在A数组所切点的左边
	            int j = halfLen - i;//j为有多少元素在B数组所切点的左边
	            if (i < iMax && B[j-1] > A[i]){//右移切割点，则需判断还有没有可以右移的空间
	                iMin = i + 1; // i is too small
	            }
	            else if (i > iMin && A[i-1] > B[j]) {
	                iMax = i - 1; // i is too big
	            }
	            else { // i is perfect
	                int maxLeft = 0;
	                if (i == 0) { maxLeft = B[j-1]; }//A没有左边，即A中所有数都在最后数组C切割点的右边，那么，C切割点左边的数都由数组B切割点的左边组成，则C左边最大数为B【】
	                else if (j == 0) {maxLeft = A[i-1];}
	                else { maxLeft = Math.max(A[i-1], B[j-1]);}//A、B都被切了
	                if ( (m + n) % 2 == 1 ) { 
	                	return maxLeft; }//当C为奇数时，返回A、B左边大的那个，自己找规律所得
	                int minRight = 0;//当C为偶数时，需要求出左边最大和右边最小的平均数
	                if (i == m) { minRight = B[j]; }//A没有右边，即A中所有数都在C的左边，所以C的右边最小为B的右边最小
	                else if (j == n) { minRight = A[i]; }
	                else { minRight = Math.min(B[j], A[i]); }

	                return (maxLeft + minRight) / 2.0;
	            }
	        }
	        return 0.0;
	    }
	}


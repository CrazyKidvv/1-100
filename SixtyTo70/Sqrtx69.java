package SixtyTo70;

import javax.sound.midi.MidiChannel;
import javax.xml.stream.events.EndDocument;

public class Sqrtx69 {
	public int mySqrt(int x) {//time limit exceed
		if(x == 0 || x == 1) return x;
		int i = 1;
		while(i * i < x) {
			i++;
			if(i * i == x) {
				return i;
			}
		}
		return i - 1;
	}
	
	public int mySqrt2(int x) {//二分法
		//if(x == 0 || x == 1) return x;
		if(x <=0 ) return x;
		int N = (int)Math.sqrt(Integer.MAX_VALUE);
		int start = 1, end = N;
		while(start + 1 < end) {//二分法模版，一般都适用
			//当start和end相邻时，退出循环
			int mid = start + (end - start)/2;
			if(mid * mid == x) return mid;
			if(mid * mid < x) start = mid;
			if(mid * mid > x) end = mid;
			}
		if(end * end <= x) return end;//当start和mid指针相邻了，循环退出了，但是mid * mid不是
		//正好等于x，判断此时start和end改取哪一个值
		else return start;		
	}
	
	public int mySqrt3(int x) {
		if(x <= 0) return x;
		int cur = 0;
		int res = 1;
		int add = 0;
		while(cur <= x) {
			if(cur + add > Integer.MAX_VALUE) {//如果溢出的话，cur + add变为负数，
				//永远不可能大于MAXvalue
				return res;
			}
			cur = cur + add;
			res++;
			add = add + 2;
		}
		return res;
	}
}

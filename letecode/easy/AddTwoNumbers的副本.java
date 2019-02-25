package letecode.easy;

public class AddTwoNumbers {
	public static void main(String args[]) {
		ListNode LN1 = new ListNode(2);
		ListNode LN2 = new ListNode(4);
		ListNode LN3 = new ListNode(3);
		LN1.next = LN2;
		LN1.next.next = LN3;
//		System.out.println(LN1);
		
		ListNode LNb1 = new ListNode(5);
		ListNode LNb2 = new ListNode(6);
		ListNode LNb3 = new ListNode(4);
		LNb1.next = LNb2;
		LNb1.next.next = LNb3;
		ListNode aListNode = addTwoNumbers(LN1, LNb1);
		System.out.println(aListNode.val);//打印出地址？
//		System.out.println(addTwoNumbers(LN1,LNb1).val);
//		System.out.println(addTwoNumbers(LN1.next, LNb1.next).val);
//		System.out.println(addTwoNumbers(LN1.next.next, LNb1.next.next).val);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {//取模得到位数的值，取余得到进位
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2;//为了程序进展到最后不改变l1,l2结点
	    ListNode curr = dummyHead;//新计算出的ListNode存储地
	    int carry = 0;//进位
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;//carry是整数，不够进位为0，够进位为1
	        curr.next = new ListNode(sum % 10);//加法最后在每一位的值由取模得到
	        curr = curr.next;//移位
	        System.out.println(curr.val);
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {//若最后一位有进位，需要在结果最前加1:23+86
	        curr.next = new ListNode(carry);
	    }
//	    System.out.println(dummyHead.next.val);
	    return dummyHead.next;	 //这是return了个啥？
	 
	}
}

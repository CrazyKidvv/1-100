package letecode.easy;

public class AddTwoNumbers2 {
	public static void main(String args[]) {
		ListNode LN1 = new ListNode(2);
		ListNode LN2 = new ListNode(4);
		ListNode LN3 = new ListNode(3);
		LN1.next = LN2;
		LN1.next.next = LN3;
//		System.out.println(LN1);
		
		ListNode LNb1 = new ListNode(5);
		ListNode LNb2 = new ListNode(6);
		ListNode LNb3 = new ListNode(6);
		LNb1.next = LNb2;
		LNb1.next.next = LNb3;
		addTwoNumbers(LN1, LNb1);
//		System.out.println(aListNode);//打印出地址？
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    int carry = 0;//进位
	    while (l1 != null || l2 != null) {
	        int x = (l1 != null) ? l1.val : 0;
	        int y = (l2 != null) ? l2.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;//carry是整数，不够进位为0，够进位为1
	        dummyHead.next = new ListNode(sum % 10);//加法最后在每一位的值由取模得到
	        dummyHead = dummyHead.next;//移位
	        System.out.println(dummyHead.val);
	        if (l1 != null) l1 = l1.next;
	        if (l2 != null) l2 = l2.next;
	    }
	    if (carry > 0) {
	    	dummyHead.next = new ListNode(carry);
	    	System.out.println(dummyHead.next.val);
	    }
//	    System.out.println(dummyHead.next.val);
	    return dummyHead.next;	 
	 
	}
}

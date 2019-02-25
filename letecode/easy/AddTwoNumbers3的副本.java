package letecode.easy;

import java.security.Signature;

import org.omg.CORBA.portable.ValueBase;

public class AddTwoNumbers3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		int sum = 0;
		while(l1 != null || l2 != null) {
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
		sum = sum/10;
		dummyHead.next = new ListNode(sum % 10);
		dummyHead = dummyHead.next;
		}
		if(sum == 1) {
			dummyHead.next = new ListNode(sum);
		}
		return dummyHead.next;
	}

}

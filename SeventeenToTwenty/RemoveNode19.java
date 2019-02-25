package SeventeenToTwenty;

import letecode.easy.ListNode;

public class RemoveNode19 {

	public static void main(String[] args) {
		Listnode LN1 = new Listnode(1);
		Listnode LN2 = new Listnode(2);
		Listnode LN3 = new Listnode(3);
		Listnode LN4 = new Listnode(4);
		Listnode LN5 = new Listnode(5);
		LN1.next = LN2;
		System.out.println("LN1= " + LN1.val);
		LN2.next = LN3;
		LN3.next = LN4;
		LN4.next = LN5;
		int n = 2;
		System.out.println(removeNthFromEnd(LN1, n).val);
	}
	
	 public static Listnode removeNthFromEnd(Listnode head, int n) {
		 Listnode dummy = new Listnode(0);
		 Listnode fast = dummy;
		 Listnode slow = dummy;
		 dummy.next = head;
		 for(int i = 0; i <= n; i++) {
			 fast = fast.next;
		 }
		 while(fast != null) {
			 fast = fast.next;
			 slow = slow.next;
		 }
		 slow.next = slow.next.next;
		 return dummy.next;
	 }
	       
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null && l2 != null){
            p.next = new ListNode((carry + l1.val + l2.val) % 10);
            carry = (carry + l1.val + l2.val)/10;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            p.next = new ListNode((carry + l1.val) % 10);
            carry = (carry + l1.val)/10;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null){
            p.next = new ListNode((carry + l2.val) % 10);
            carry = (carry + l2.val)/10;
            p = p.next;
            l2 = l2.next;
        }
        if(carry != 0){
            p.next = new ListNode(carry);
        }
       // return dummy.next;
    }
}
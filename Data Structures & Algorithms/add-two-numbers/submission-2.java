/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode s = new ListNode(0);
        ListNode dummy = s;
        Integer carry = null;
        while(a != null && b != null) {
            int c = (carry != null) ? carry : 0;
            int sum = a.val + b.val + c;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = null;
            }
            s.next = new ListNode(sum);
            s = s.next;
            a = a.next;
            b = b.next;
        }
        while(a != null) {
            int c = (carry != null) ? carry : 0;
            int sum = a.val + c;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = null;
            }
            s.next = new ListNode(sum);
            s = s.next;
            a = a.next;
        }
        while(b != null) {
            int c = (carry != null) ? carry : 0;
            int sum = b.val + c;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = null;
            }
            s.next = new ListNode(sum);
            s = s.next;
            b = b.next;
        }
        if(carry != null) {
            s.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

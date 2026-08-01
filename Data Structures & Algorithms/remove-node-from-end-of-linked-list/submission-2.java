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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0,head);
        ListNode last = start.next;
        ListNode dummy = start;

        while(n > 0) {
            n--;
            last = last.next;
        }
        while(last != null) {
            last = last.next;
            start = start.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}

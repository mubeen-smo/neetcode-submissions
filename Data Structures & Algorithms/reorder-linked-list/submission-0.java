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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        int n = 0;
        while(curr != null) {
            n++;
            curr = curr.next;
        }
        n++;
        curr = head;
        int count = 0;
        while(count < (n/2)-1) {
            curr = curr.next;
            count++;
        }
        ListNode yHead = curr.next;
        curr.next = null;
        print(head);
        print(yHead);
        ListNode yReversed = reverse(yHead);
        print(yReversed);
        ListNode xCurr = head;
        ListNode yCurr = yReversed;
        while(xCurr != null && yCurr != null) {
            ListNode xTemp = xCurr.next;
            xCurr.next = yCurr;
            ListNode yTemp = yCurr.next;
            yCurr.next = xTemp;
            xCurr = xTemp;
            yCurr = yTemp;
        }
    }

    public ListNode reverse(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    private void print(ListNode n) {
        while(n != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println("");
    }
}

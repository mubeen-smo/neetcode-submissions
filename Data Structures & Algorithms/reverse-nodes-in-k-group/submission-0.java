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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy; 
        ListNode curr = head;
        ListNode tempHead = head;
        int i = 1;

        while(curr != null) {
            if(i == k) {
                ListNode temp = curr.next;
                curr.next = null; 

                ListNode oldTail = tempHead; 
                ListNode reversedHead = reverse(tempHead);

                prevGroupTail.next = reversedHead;
                curr = temp;
                oldTail.next = curr;

                prevGroupTail = oldTail;
                tempHead = curr;
                i = 0; 
            } else {
                curr = curr.next;
            }
            i++;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next; 
            curr.next = prev; 
            prev = curr;
            curr = temp; 
        }
        return prev; 
    }
}

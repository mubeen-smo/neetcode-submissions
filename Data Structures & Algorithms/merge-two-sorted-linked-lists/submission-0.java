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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode newNode = new ListNode();
        ListNode start = newNode;

        while(curr1 != null && curr2 != null) {
            if(curr1.val < curr2.val) {
                newNode.next = curr1;
                curr1 = curr1.next;
            } 
            else {
                newNode.next = curr2;
                curr2 = curr2.next;
            }
            newNode = newNode.next;
        }
        if(curr1 != null) newNode.next = curr1;
        if(curr2 != null) newNode.next = curr2;
        return start.next;
    }
}
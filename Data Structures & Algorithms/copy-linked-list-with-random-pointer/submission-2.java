/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> nodeMap = new HashMap<>();
        Node oldCurr = head; 
        Node newCurr = new Node(0);
        Node newDummy = newCurr;
        print(newCurr);
        while(oldCurr != null) {
            newCurr.next = new Node(oldCurr.val);
            newCurr = newCurr.next;
            nodeMap.put(oldCurr,newCurr);
            oldCurr = oldCurr.next;
        }
        print(newDummy);
        oldCurr = head;
        newCurr = newDummy.next;
        while(oldCurr != null) {
            if(oldCurr.random != null) {
                newCurr.random = nodeMap.get(oldCurr.random);
            } else {
                newCurr.random = null;
            }
            oldCurr = oldCurr.next;
            newCurr = newCurr.next;
        }
        return newDummy.next;

    }

    private void print(Node n) {
        while( n != null) {
            System.out.print(n.val + "-> ");
            n = n.next;
        }
        System.out.println("");
    }
}

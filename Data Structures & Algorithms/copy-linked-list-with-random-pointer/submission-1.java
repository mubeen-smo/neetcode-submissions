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
        Node oldCurrent = head;
        Node newCurrent = new Node(0);
        Node newHeadDummy = newCurrent;
        Map<Node, Node> nodesMap = new HashMap<>();
        while(oldCurrent != null) {
            newCurrent.next = getDeepCopy(oldCurrent);
            nodesMap.put(oldCurrent, newCurrent.next);
            oldCurrent = oldCurrent.next;
            newCurrent = newCurrent.next;
        }
        newCurrent.next = null;
        oldCurrent = head;
        newCurrent = newHeadDummy.next;
        while(oldCurrent != null) {
            Node random = oldCurrent.random;
            if( random != null) {
                 newCurrent.random = nodesMap.get(random);
            } else {
                newCurrent.random = null;
            }
            newCurrent = newCurrent.next;
            oldCurrent = oldCurrent.next;
        }
        return newHeadDummy.next;
    }

    private Node getDeepCopy(Node old) {
        Node newOne = new Node(old.val);
        return newOne;
    }

}

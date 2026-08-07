/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // Loop runs as long as we have nodes to process
        while (curr != null || !stack.isEmpty()) {
            
            // 1. GO LEFT: Push all left ancestors to the stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. PROCESS: Pop the smallest available node
            curr = stack.pop();
            k--; // We just "visited" a node in sorted order
            
            // 3. EARLY STOP: If k hits 0, this is our answer!
            if (k == 0) {
                return curr.val; 
            }

            // 4. GO RIGHT: Move to the right subtree
            curr = curr.right;
        }

        return -1; // Fallback
    }
}


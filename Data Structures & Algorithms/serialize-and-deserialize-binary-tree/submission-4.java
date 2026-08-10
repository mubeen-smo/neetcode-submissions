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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializer(root,sb);
        System.out.println(sb);
        return sb.toString();
    }

    private void serializer(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializer(node.left,sb);
        serializer(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        String[] nodesList = data.split(",");
        System.out.println(nodesList);
        root = deserializer(nodesList, new int[]{0});
        return root;
    }

    private TreeNode deserializer(String[] strings, int[] index) {
        if(index[0] >= strings.length) {
            return null;
        }
        String curr = strings[index[0]++];
        if(curr.isEmpty() || curr.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(curr));
        node.left = (deserializer(strings, index));
        node.right = (deserializer(strings,index));
        return node;
    }
}

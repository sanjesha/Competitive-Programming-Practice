package LeetCode;

public class TreeFromPreOrder {
    public TreeNode recoverFromPreorder(String traversal) {
        //
        return new TreeNode();
    }

}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

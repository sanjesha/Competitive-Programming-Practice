package DP;

public class BinaryTreeMaxPathSum {


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

    class NewTreeNode {
        TreeNode tn;
        int maxPathSum;
        int destMaxPathSum;

        public NewTreeNode(TreeNode tn, int maxPathSum, int destMaxPathSum) {
            this.tn = tn;
            this.maxPathSum = maxPathSum;
            this.destMaxPathSum = destMaxPathSum;
        }

    }

    public int maxPathSum(TreeNode root) {
        NewTreeNode ntn = new NewTreeNode( root, 0, 0);
        maxSum(ntn);

        return ntn.maxPathSum;

    }

    private void maxSum(NewTreeNode root) {
        if(root == null) {
            root = nullNode();
            return;
        }

        NewTreeNode leftNode = new NewTreeNode(root.tn.left, 0,0);
        NewTreeNode rightNode = new NewTreeNode(root.tn.right, 0,0);
        maxSum(leftNode);
        maxSum(rightNode);

        int maxPathSum = leftNode.destMaxPathSum + root.tn.val + rightNode.destMaxPathSum;
        if(maxPathSum < leftNode.maxPathSum)
            maxPathSum = leftNode.maxPathSum;
        if(maxPathSum < rightNode.maxPathSum)
            maxPathSum = rightNode.maxPathSum;

        int maxDestSum = root.tn.val;
        if (maxDestSum < leftNode.destMaxPathSum + root.tn.val)
            maxDestSum = leftNode.destMaxPathSum + root.tn.val;
        if (maxDestSum < rightNode.destMaxPathSum + root.tn.val)
            maxDestSum = rightNode.destMaxPathSum + root.tn.val;

        if(maxPathSum < maxDestSum)
            maxPathSum = maxDestSum;

        root.maxPathSum =  maxPathSum;
        root.destMaxPathSum = maxDestSum;

    }

    private NewTreeNode nullNode() {
        TreeNode tn = new TreeNode(0);
        NewTreeNode ntn = new NewTreeNode(tn, Integer.MIN_VALUE, Integer.MIN_VALUE);
        return null;
    }

    private int maxSum1(TreeNode root) {
        if(root == null)
            return -2000;


    int maxL= maxSum1(root.left);
    int maxR = maxSum1(root.right);

    int maxDestSum = root.val;
    int maxPathSum =  root.val;
        if(root.left != null && root.left.val > 0){
        maxPathSum += root.left.val;
        maxDestSum +=  root.left.val;
    }

        if(root.right != null && root.right.val > 0){
        maxPathSum += root.right.val;
        maxDestSum += root.right.val;
    }

        if(maxPathSum < maxL)
    maxPathSum = maxL;
        if(maxPathSum < maxR)
    maxPathSum = maxR;

        if(maxPathSum < maxDestSum)
    maxPathSum = maxDestSum;

    root.val = maxDestSum;
        return maxPathSum;
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

package Practice;

import java.util.*;

public class MaxBinTreeWidth {
    class NewTreeNode {
        public TreeNode node;
        public int index;

        public NewTreeNode(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;

        Queue<NewTreeNode> queue = new LinkedList<>();
        queue.add(new NewTreeNode(root, 1));
        int maxWidth = 1;
        while(!queue.isEmpty()) {
           // queue = getNodesInNextLevel(queue);
            NewTreeNode tn = queue.remove();
            if(tn.node.left != null){
                queue.add(new NewTreeNode(tn.node.left , tn.index*2));
            }
            if(tn.node.right != null){
                queue.add(new NewTreeNode(tn.node.right , tn.index*2+1));
            }

            int currentLevel = (int)(Math.log(tn.index)/Math.log(2.0));
            int entriesTillPrevLevel = (int)(Math.pow(2.0,currentLevel) - 1);
            int entriesInCurrentLevel = tn.index - entriesTillPrevLevel;

            maxWidth = Math.max(maxWidth,entriesInCurrentLevel);
        }

        return maxWidth;

    }

    private Queue<TreeNode> getNodesInNextLevel(Queue<TreeNode> queue) {
        TreeNode nullNode = new TreeNode();
        Queue<TreeNode> newQueue = new LinkedList<>();
        int nonNullNodeCount = 0;
        int nodeCount = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left !=null && node.left != nullNode){
                newQueue.add(node.left);
                nodeCount++;
            } else {
                newQueue.add(nullNode);
            }

            if(node.right !=null && node.right != nullNode ) {
                queue.add(node.right);
            } else {
                newQueue.add(nullNode);
            }
        }

        return newQueue;
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

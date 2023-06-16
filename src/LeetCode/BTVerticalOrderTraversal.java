package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class BTVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<TreeNodeOrder> queue = new LinkedList<>();
        TreeNodeOrder t = new TreeNodeOrder(root,0);
        queue.add(t);
        levelOrderTraverseTree(queue, map);

       // List<Integer> keyset = map.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> keyset = new ArrayList<Integer>(map.keySet());
        int min = Collections.min(keyset);
        int max = Collections.max(keyset);
        for(int i = min; i<=max; i++){
            ans.add(map.get(i));
        }
      //  Collections.sort(keyset);
      //  for(Integer order : keyset){
      //      ans.add(map.get(order));
       // }
        return ans;
    }

    class TreeNodeOrder {
        TreeNode node;
        int order;

        public TreeNodeOrder(TreeNode node, int order) {
            this.node = node;
            this.order = order;
        }
    }
    private void levelOrderTraverseTree(Queue<TreeNodeOrder> queue, Map<Integer, List<Integer>> map) {
        while(!queue.isEmpty()){
            TreeNodeOrder t = queue.remove();
            if(map.containsKey(t.order)) {
                List<Integer> list = map.get(t.order);
                list.add(t.node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(t.node.val);
                map.put(t.order, list);
            }
            if(t.node.left != null){
                TreeNodeOrder tl = new TreeNodeOrder(t.node.left, t.order-1);
                queue.add(tl);

            }
            if(t.node.right != null){
                TreeNodeOrder tr = new TreeNodeOrder(t.node.right, t.order+1);
                queue.add(tr);
            }
        }
    }


    private void preTraverseTree(TreeNode root, int order, Map<Integer, List<Integer>> map) {
        if(root != null){
            if(map.containsKey(order)) {
                List<Integer> list = map.get(order);
                list.add(root.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.put(order, list);
            }
            preTraverseTree(root.left, order-1,map);
            preTraverseTree(root.right, order+1,map);
        }
    }

    private void inorderTraverseTree(TreeNode root, int order, Map<Integer, List<Integer>> map) {
        if(root != null){
            inorderTraverseTree(root.left, order-1,map);
            if(map.containsKey(order)) {
                List<Integer> list = map.get(order);
                list.add(root.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.put(order, list);
            }
            inorderTraverseTree(root.right, order+1,map);
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
}

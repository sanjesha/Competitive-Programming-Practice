package Practice;


import java.util.*;

public class SmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> solList = new ArrayList<>(nums.length);
        Integer[] solution = new Integer[nums.length];
        TreeNode root=null;
        for (int i=nums.length-1; i>=0; i--) {
            TreeNode node = new TreeNode(nums[i],i);
            if(root == null){
                root = node;
            } else {
                addNode(root, node);
            }
        }

        fillSolutionList(root, solution);

//        for(int i: solution){
//            solList.add(i);
//        }
        return Arrays.asList(solution);

    }

    private void fillSolutionList(TreeNode root, Integer[] solution) {
        if(root !=null){
            solution[root.index] = root.numSmallerAfterSelf;
            fillSolutionList(root.left, solution);
            fillSolutionList(root.right, solution);
        }
    }

    private void addNode(TreeNode root, TreeNode node) {


        if(node.val <= root.val){
            root.numLeftNodes++;
            if(root.left == null){
                root.left = node;
            } else {
                addNode(root.left, node);
            }
        } else {
            node.numSmallerAfterSelf += root.numLeftNodes + 1;
            if(root.right == null){
                root.right = node;
            } else {
                addNode(root.right, node);
            }
        }

    }

    //Definition for a binary tree node.
    class TreeNode {
        int val;
        int index;
        int numLeftNodes;
        int numSmallerAfterSelf;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val, int index) {
            this.val = val;
            this.index = index;
            this.numSmallerAfterSelf = 0;
            this.numLeftNodes = 0;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        int k;
        int v;
        Pair(int k, int v){
            this.k = k;
            this.v = v;
        }
    }

    class PairComp implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {


            return o1.k - o2.k;
        }
    }

    public List<Integer> countSmaller1(int[] nums) {
        TreeMap<Pair, Integer> tmap = new TreeMap<>(new PairComp());

        for (int i = nums.length - 1; i >= 0; i--) {
            Pair p = new Pair(nums[i], i);
            Map.Entry<Pair, Integer> entry = tmap.lowerEntry(p);
            if(entry==null){
                tmap.put(p, 0);
            } else {
                tmap.put(p, entry.getValue() + 1);
            }
        }

        Integer[] solution = new Integer[nums.length];
        for(Map.Entry<Pair, Integer> entry : tmap.entrySet()){
            solution[entry.getKey().v] = entry.getValue();
        }

        return Arrays.asList(solution);

    }

    public List<Integer> countSmaller2(int[] nums) {
        TreeMap<Integer, Node> tmap = new TreeMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            Node node = new Node(i);
            Map.Entry<Integer, Node> entry = tmap.floorEntry(nums[i]);
            if(entry==null){
                tmap.put(nums[i], node);
            } else if (entry.getKey() == nums[i]){
                Node n = entry.getValue();
                n.indices.add(i);
                tmap.put( nums[i], n);
            } else {
                node.count = entry.getValue().count + 1;
                tmap.put(nums[i], node);
            }
        }

        Integer[] solution = new Integer[nums.length];
        for(Map.Entry<Integer, Node> entry : tmap.entrySet()){
            for(Integer i : entry.getValue().indices) {
                solution[i] = entry.getValue().count;
            }
        }

        return Arrays.asList(solution);

    }

    class Node {
        List<Integer> indices = new ArrayList<>();
        int count;

        public Node(int i) {
            indices.add(i);
            count = 0;
        }
    }
}

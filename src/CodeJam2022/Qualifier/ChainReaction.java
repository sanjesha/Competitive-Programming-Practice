package CodeJam2022.Qualifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChainReaction {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int n = sc.nextInt();
            int[] F = new int[n];
            int[] P = new int[n];

            for (int i=0; i<n; i++){
                F[i] =  sc.nextInt();
            }

            for (int i=0; i<n; i++){
                P[i] =  sc.nextInt();
            }

            long maxFun = getMaxFun(F, P);

            System.out.println("Case #" + (testCase + 1) + ": " + maxFun);

        }
    }

    private static long getMaxFun(int[] F, int[] P) {
        Node[] nodes = new Node[F.length+1];
        nodes[0] = new Node(0);
        for(int i=0; i< F.length; i++) {
            nodes[i+1] = new Node(F[i]);
            nodes[P[i]].children.add(nodes[i+1]);
        }

        long maxFun = 0;
        for(Node node : nodes[0].children){
            getMax(node);
            maxFun += node.funScoreExcludingNode + node.funScoreIncludingNode;
        }
        return maxFun;
    }

    private static void getMax(Node node) {
        if(node.children.isEmpty()){
            node.funScoreExcludingNode = 0;
            node.funScoreIncludingNode = node.fun;
        }
        
        long minFunScoreIncludingNode = Long.MAX_VALUE;
        Node minNode = null;
        long sumFunScoreExcludingMinNode = 0;
        for(Node child : node.children){
            getMax(child);
            if(minFunScoreIncludingNode > child.funScoreIncludingNode){
                minFunScoreIncludingNode =  child.funScoreIncludingNode;
                minNode = child;
            }
            sumFunScoreExcludingMinNode += (child.funScoreExcludingNode + child.funScoreIncludingNode);
        }
        node.funScoreIncludingNode = node.fun;
        if(minNode != null) {
            sumFunScoreExcludingMinNode -= minNode.funScoreIncludingNode;
            node.funScoreIncludingNode = Math.max(node.funScoreIncludingNode, minNode.funScoreIncludingNode);
        }

        node.funScoreExcludingNode = sumFunScoreExcludingMinNode;

    }

    static class Node {
        int fun;
        List<Node> children = new ArrayList<>();
        long funScoreIncludingNode = Long.MAX_VALUE;
        long funScoreExcludingNode;

        public Node(int fun) {
            this.fun = fun;
        }
    }


}

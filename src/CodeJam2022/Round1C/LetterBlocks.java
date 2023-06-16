package CodeJam2022.Round1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LetterBlocks {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int n = sc.nextInt();
            String[] words = new String[n];

            for(int i=0; i<n; i++){
                words[i] = sc.next();
            }

            String megaBlock = getMegaBlock(n, words);

            System.out.println("Case #" + (testCase + 1) + ": " + megaBlock);

        }
    }

    private static String getMegaBlock(int n, String[] words) {

        HashMap<Character, Node> startsWithMap = new HashMap<>();
        HashMap<Character, Node> endsWithMap = new HashMap<>();
        HashMap<Character,Node> sameCharBlocks = new HashMap<>();
        Set<Node> nodeSet = new HashSet<>();

        for(int i =0; i<n; i++){
            char[] ca = words[i].toCharArray();
            Node node = new Node(words[i]);
            nodeSet.add(node);
            if(ca[0] == ca[ca.length-1] ) {
                if (sameCharBlock(ca)) {
                    if (sameCharBlocks.containsKey(ca[0])) {
                        Node node1 = sameCharBlocks.get(ca[0]);
                        node.next = node1.next;
                        node1.next = node;
                        node.prev = node1;
                    } else {
                        sameCharBlocks.put(ca[0], node);
                    }

                    continue;
                } else {
                    return "IMPOSSIBLE";
                }
            }

            if(startsWithMap.containsKey(ca[0]) || endsWithMap.containsKey(ca[ca.length-1])){
                return "IMPOSSIBLE";
            }

            startsWithMap.put(ca[0],node);
            endsWithMap.put(ca[ca.length-1],node);

            if(endsWithMap.containsKey(ca[0])){
                Node node1 = endsWithMap.get(ca[0]);
                node.next = node1.next;
                if(node.next!=null)
                    node.next.prev = node;
                node1.next = node;
                node.prev = node1;
            }

            if(startsWithMap.containsKey(ca[ca.length-1])){
                Node node1 = startsWithMap.get(ca[ca.length-1]);
                node.prev = node1.prev;
                if(node.prev !=null)
                    node.prev.next = node;
                node1.prev = node;
                node.next = node1;
            }


        }

        for(Map.Entry<Character,Node> e : sameCharBlocks.entrySet()){
            Node initNode = e.getValue();
            Node endNode = initNode;
            while(endNode.next !=null)
                endNode = endNode.next;

            if(endsWithMap.containsKey(e.getKey())){
                Node node1 = endsWithMap.get(e.getKey());
                endNode.next = node1.next;
                node1.next = initNode;
                initNode.prev = node1;
            }

        }

        Node ll = new Node();
        Node currentNode = ll;
        for(Map.Entry<Character,Node> e : endsWithMap.entrySet()){
            Node initNode = e.getValue();
            if(nodeSet.contains(initNode)){
                nodeSet.remove(initNode);
            } else {
                continue;
            }
            Node endNode = initNode;
            while(endNode.next !=null) {
                endNode = endNode.next;
                nodeSet.remove(endNode);
            }
            while(initNode.prev !=null){
                initNode = initNode.prev;
                nodeSet.remove(initNode);
            }

            currentNode.next = initNode;
            currentNode = endNode;

        }

        StringBuilder megaBlock = new StringBuilder();
        while(ll.next != null){
            megaBlock.append(ll.word);
            ll = ll.next;
        }
        megaBlock.append(ll.word);
        String str = megaBlock.toString();
        if(validBlock(str))
            return str;
        else
            return "IMPOSSIBLE";
    }

    private static boolean validBlock(String str) {
        Set<Character> set = new HashSet<>();
        char[] ca = str.toCharArray();
        char prev = ca[0];
        for(int j=1; j< ca.length; j++){
            if(ca[j] != prev ){
                if(set.contains(ca[j]))
                    return false;
                set.add(prev);
                prev = ca[j];
            }
        }
        return true;
    }

    private static boolean sameCharBlock(char[] ca) {
        char prev = ca[0];
        for(int i=1; i<ca.length;i++){
            if(ca[i] != prev)
                return false;
        }
        return true;
    }

    static class Node {
        String word;
        Node next;
        Node prev;

        public Node(String word) {
            this.word = word;
            this.next = null;
            this.prev =null;
        }

        public Node() {
            this.word = "";
            this.next = null;
            this.prev =null;
        }
    }

}

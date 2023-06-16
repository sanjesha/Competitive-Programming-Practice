package Practice;

import java.util.*;

public class RussianDollEnvelope {
    public int maxEnvelopes1(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, Comparator.comparingInt(i -> i[0]));
       // Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0] );
        int[] len = new int[envelopes.length];

        int maxlen = 0;

        for(int i=0; i<envelopes.length; i++){
            len[i] = 1;
            for(int j=0; j<i; j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    len[i] = Math.max(len[i], len[j]+1);
                }
            }
            maxlen = Math.max(maxlen, len[i]);
        }

        return maxlen;
    }


    private int LIS1(int[][] a) {
        TreeMap<Pair, Integer> L = new TreeMap<>();
        List<List<Pair>> cover = new ArrayList<>();
        Arrays.stream(a).sequential().forEach(t -> addCover1(t, cover, L) );
        return L.size();
    }

    private void addCover1(int[] x, List<List<Pair>> cover, TreeMap<Pair,Integer> L) {
        Pair p = new Pair(x[0], x[1]);
        Map.Entry<Pair,Integer> index = L.ceilingEntry(p);
        if(index == null) {
            L.put(p, L.size());
            List<Pair> list = new ArrayList<>();
            list.add(p);
            cover.add(list);
        } else {
            cover.get(index.getValue()).add(p);
            L.remove(index.getKey());
            L.put(p,index.getValue());
        }

    }


    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        //    Arrays.sort(envelopes, Comparator.comparingInt(i -> i[0]));
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0] );

        int maxLen = LIS(envelopes);
        return maxLen;
    }

    private int LIS(int[][] a) {
        TreeMap<Integer, Integer> L = new TreeMap<>();
        List<List<Integer>> cover = new ArrayList<>();
        Arrays.stream(a).sequential().forEach(t -> addCover(t, cover, L) );
        return L.size();
    }

    private void addCover(int[] x, List<List<Integer>> cover, TreeMap<Integer,Integer> L) {
       // Pair p = new Pair(x[0], x[1]);
        Map.Entry<Integer,Integer> index = L.ceilingEntry(x[1]);
        if(index == null) {
            L.put(x[1], L.size());
            List<Integer> list = new ArrayList<>();
            list.add(x[1]);
          //  cover.add(list);
        } else {
         //   cover.get(index.getValue()).add(x[1]);
            L.remove(index.getKey());
            L.put(x[1],index.getValue());
        }

    }

    private class Pair implements Comparable {
        public Integer i;
        public Integer j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            Pair t = (Pair) o;
            if(this.i > t.i && this.j > t.j){
                return 1;
            } else if(this.i == t.i && this.j == t.j){
                return 0;
            } else {
                return -1;
            }
        }
    }
}

package DivideAndConquer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClosestPoints {

    public int[][] closestPoints(int[][] points){

        int len = points.length;
        int[][] X = new int[len][2];
        int[][] Y = new int[len][2];

        //int[][] copy = Arrays.stream(points).map(int[]::clone).toArray(int[][]::new);
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points[0].length; j++){
                X[i][j] = points[i][j];
                Y[i][j] = points[i][j];
            }
        }

        Arrays.sort(X, (a,b) -> a[0] - b[0]);
        Arrays.sort(Y, (a,b) -> a[1] - b[1]);


        return closestPoints(X, Y, 0, points.length-1);
    }

    private int[][] closestPoints(int[][] X, int[][] Y, int low, int high) {
        if(high-low <= 2){
            int[][] cp = getBruteForceClosestPoints(X,low,high);
            return cp;
        }


        int mid = (low + high)/2;
        int[][] YL = new int[mid - low + 1][2];
        int[][] YR = new int[high - mid][2];

        splitY(X, Y, low, high, mid, YL, YR);

        int[][] cpL = closestPoints(X, YL, low, mid);
        int[][] cpR = closestPoints(X, YR, mid+1, high);

        int minDistL = getManhattanDist(cpL[0], cpL[1]) ;
        int minDistR = getManhattanDist(cpR[0], cpR[1]) ;;

        int[][] min;
        int minDist = 0;

        if(minDistL < minDistR){
            minDist = minDistL;
            min = cpL;
        } else {
            minDist = minDistR;
            min =cpR;
        }

        int[][] yDelta = new int[Y.length][2];
        double midX = (X[mid][0] + X[mid+1][0])/2.0;
        int n = mergeY(midX, yDelta, YL,YR, minDist);

        closestPointsAcross(yDelta, minDist, min, n);


        return min;
    }

    private void splitY(int[][] X, int[][] Y, int low, int high, int mid, int[][] YL, int[][] YR) {
        Set<int[]> PL = new HashSet<>();
        Set<int[]> PR = new HashSet<>();

        for (int i = low; i<= mid; i++){
            PL.add(X[i]);
        }

        for (int i = mid +1; i<= high; i++){
            PR.add(X[i]);
        }
            int left =0;
            int right = 0;
            for(int i=0; i<Y.length;i++){
                if(PL.contains(Y[i])){
                    YL[left++] = Y[i];
                } else {
                    YR[right++] = Y[i];
                }
            }

    }

    private int[][] getBruteForceClosestPoints(int[][] x, int low, int high) {
        int n = high - low +1;
        int[][] cp = new int[2][2];
        int min = getManhattanDist(x[low], x[low+1]);
        cp[0] = x[low];
        cp[1] = x[low+1];

        if(n>2){
            int min1 = getManhattanDist(x[low], x[high]);
            if(min1 < min){
                min = min1;
                cp[0] = x[low];
                cp[1] = x[high];
            }

            int min2 = getManhattanDist(x[low+1], x[high]);
            if(min2 < min){
                min = min2;
                cp[0] = x[low+1];
                cp[1] = x[high];
            }
        }

        return cp;
    }

    private int getManhattanDist(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    private int mergeY(double midX, int[][] Y, int[][] YL, int[][] YR, int minDist) {
        int index =0;
        for(int i=0; i<YL.length;i++){
            if(YL[i][0] <= midX && YL[i][0] >= midX - minDist){
                Y[index++] = YL[i];
            }
        }
        for(int i=0; i<YR.length;i++){
            if(YR[i][0] >= midX && YR[i][0] <= midX + minDist){
                Y[index++] = YR[i];
            }
        }
        return index;
    }

    private void closestPointsAcross(int[][] yDelta, int minDist, int[][] min, int n) {
        for(int i=0; i<n; i++){
            for(int j= i+1; j<=i+7 && j<n; j++){
                int dist = getManhattanDist(yDelta[i], yDelta[j]);
                if(dist<minDist){
                    minDist = dist;
                    min[0][0] = yDelta[i][0];
                    min[0][1] = yDelta[i][1];
                    min[1][0] = yDelta[j][0];
                    min[1][1] = yDelta[j][1];
                }
            }
        }

    }






}

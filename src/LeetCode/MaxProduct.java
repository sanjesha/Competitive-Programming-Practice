package LeetCode;

public class MaxProduct {
    public int maxProduct(int[] a){
        return getMaxProd(a,0,a.length-1);
    }

    private int getProdAcrossSubArrays(int[] a, int low, int mid, int high) {
        int prod = 1;
        int maxLeftProd = Integer.MIN_VALUE;
        int minLeftProd = Integer.MAX_VALUE;
        for(int i =mid; i>=low; i--){
            prod *= a[i];
            maxLeftProd = Math.max(maxLeftProd, prod);
            minLeftProd = Math.min(minLeftProd, prod);
        }

        prod =1;
        int maxRightProd = Integer.MIN_VALUE;
        int minRightProd = Integer.MAX_VALUE;
        for(int i=mid+1; i<=high; i++){
            prod *= a[i];
            maxRightProd = Math.max(maxRightProd, prod);
            minRightProd = Math.min(minRightProd, prod);
        }

        int prod1 =  maxLeftProd * maxRightProd;
        int prod2 = minLeftProd * minRightProd;

        return Math.max(prod1, prod2);
    }

    private int getMaxProd(int[] a, int low, int high) {
        if(low<high){
            int mid = low + (high-low)/2;
            int prod1 = getMaxProd(a,low,mid);
            int prod2 = getMaxProd(a,mid+1,high);
            int prod3 = getProdAcrossSubArrays(a,low,mid,high);
            return Math.max(Math.max(prod1, prod2), prod3);
        }
        return a[low];
    }


}

package LeetCode;

public class MaxSubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] a, int k) {
        int prod = 1;
        int subarrayCount = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < a.length && p2 < a.length) {
            if (p2 < p1)
                p2 = p1;
            while (p2 < a.length && (prod * a[p2]) < k) {
                prod *= a[p2];
                subarrayCount++;
                p2++;
            }
            if (p2 == a.length) {
                int t = a.length - p1 - 1;
                subarrayCount += t * (t + 1) / 2;
            } else if (prod * a[p2] >= k) {
                if (p2 > p1) {
                    prod = prod / a[p1];
                    subarrayCount += p2 - p1 - 1;
                }
                p1++;
            }

        }

        return subarrayCount;

    }

    public int numSubarrayProductLessThanK1(int[] a, int k) {
        int prod = 1;
        int subarrayCount = 0;
        int left = 0;
        for(int right=0; right < a.length; right++){
            prod *= a[right];
            while(prod >= k){
                prod = prod / a[left++];
            }
            subarrayCount += right - left +1;
        }

        return subarrayCount;
    }
}

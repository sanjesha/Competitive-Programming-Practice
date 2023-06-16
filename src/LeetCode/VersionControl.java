package LeetCode;

public class VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        int min = n;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                high = mid -1;
                if(mid < min)
                    min = mid;
            } else {
                low = mid+1;
            }
        }

        return min;

    }

    private boolean isBadVersion(int n) {
        if(n>=2126753390)
            return true;

        return false;
    }
}

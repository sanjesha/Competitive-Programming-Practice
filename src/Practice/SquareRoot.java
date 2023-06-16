package Practice;

public class SquareRoot {

    public double sqrt(int A) {
        double low = 0.0;
        double high = A*1.0;
        double mid = (low+high)/2.0;
        int count =0;
        while( Double.compare(mid*mid, A) != 0 && count < 100){
            if(mid*mid > A){
                high = mid;
            } else if(mid*mid < A){
                low = mid;
            }
            mid = (low+high)/2;
            count++;
        }

        return mid;
    }
}

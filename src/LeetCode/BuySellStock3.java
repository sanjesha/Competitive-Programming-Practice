package LeetCode;

public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit1 = 0;
        int profit2 = 0;
        for(int i=0; i< prices.length; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=i+1; j< prices.length; j++){
                if(j-1 == i || prices[j] > prices[j-1]) {
                    profit1 = getMaxProfit(prices, i, j);
                }
                if(j == i+1 || (j <  prices.length-1 && prices[j+1] > prices[j])) {
                    profit2 = getMaxProfit(prices, j + 1, prices.length - 1);
                }
                maxProfit = Math.max(maxProfit, profit1+profit2);
            }
        }
        return maxProfit;
    }

    private int getMaxProfit(int[] prices, int i, int j) {
        if(i>=prices.length){
            return 0;
        }
        int min = prices[i];
        int[] profit = new int[prices.length];
        int maxProfit = 0;
        for(int k=i; k <= j ; k++){
            profit[k] = prices[k] - min;
            maxProfit = Math.max(maxProfit, profit[k]);
            min = Math.min(min,prices[k]);
        }

        return maxProfit;
    }
}

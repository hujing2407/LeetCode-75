package Easy;
public class BestTimetoBuySellStock {
    public int maxProfitForMulti(int[] prices) {
        int low = prices[0];
        int high = prices[0];
        int max = 0;
        int i =0;
        while (i<prices.length-1) {
            if (prices[i]>=prices[i+1]) {
                i++;
                continue;}
            low = prices[i];
            while (i<prices.length-1 && prices[i]<=prices[i+1]) {
                i++;
            }
            high =  prices[i];
            max += high-low;
            i++;
        }

        return max;
    }
    public int maxProfit(int[] prices) {
        int left = Integer.MAX_VALUE;
        int currProfit = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<left) {
                left = prices[i];
            }
            currProfit = prices[i]-left;
            if (profit<currProfit) {
                profit = currProfit;
            }

        }

        return profit;
    }
}

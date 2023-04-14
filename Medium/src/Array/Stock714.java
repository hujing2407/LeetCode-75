package Array;

/**
 * @author Jing Hu
 * @date Mar 16 2021
 */
public class Stock714 {
    public int maxProfit(int[] prices, int fee) {

        int profit = 0;
        if (prices.length < 2) return 0;
        int buy = 0;
        int suposeSell = 0;
        int pre = 0, cur = 0, next = 1;
        int day = 0;
        boolean flag = false;
        while (next< prices.length) {
            if (!flag && next < prices.length) {
                if (prices[cur] < prices[next]) {
                    buy = prices[cur];
                    suposeSell = buy;
                    flag = true;
                }
            }
            if (flag && next < prices.length) {
                suposeSell = Math.max(suposeSell, prices[cur]);
                if (suposeSell - prices[next] > fee && prices[cur] > prices[next]-fee) {
                    profit += (suposeSell - buy - fee);
                    flag = false;
                }
            }
            cur++;
            next++;
        }

        if (flag && Math.max(prices[cur-1], prices[cur]) - buy - fee > 0) {
            profit += (Math.max(prices[cur-1], prices[cur]) - buy - fee);
        }

        return profit;
    }
}

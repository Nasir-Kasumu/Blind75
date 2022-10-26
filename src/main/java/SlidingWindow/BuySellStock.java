package SlidingWindow;
/*
globalMax = 0
localMax = 0

[7,1,5,3,6,4]
   b
           s
 localMax = (sell - buy) = 5
 globalMax = 5

left = right
right++;

if x is greater than something?

sliding window (buy and sell pointer)

if sell is less than buy
 buy = sell
 sell++
if buy - sell > global max
global max = buy - sell
sell++
*/
public class BuySellStock {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int globalMax = 0;
        int localMax = 0;

        while(sell < prices.length){
            localMax = prices[sell] - prices[buy];
            if(localMax > globalMax){
                globalMax = localMax;
            }

            if(prices[sell] < prices[buy]){
                buy = sell;
                sell++;
            }else{
                sell++;
            }
        }

        return globalMax;
    }
}

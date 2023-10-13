class Solution {
    public int maxProfit(int[] prices) {
        int buyprice = Integer.MAX_VALUE;
        int maximumprofit = 0;
        for(int i=0;i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit = prices[i]-buyprice;
                maximumprofit = Math.max(profit, maximumprofit);
            }else{
                buyprice = prices[i];
            }
        }
        return maximumprofit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++) {
            int cost=prices[i]-mini;
            if(profit<cost) profit=cost;
            if(mini>prices[i]) mini=prices[i];
        }
        return profit;
    }
}
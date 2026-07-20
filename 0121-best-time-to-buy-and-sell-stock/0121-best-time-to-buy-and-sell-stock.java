class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int n = prices.length;
        int buy = 0, sell =0;
        while(sell < n){
            int profit = prices[sell] - prices[buy];
            if(profit < 0){
                buy = sell;
            }
            else{
                maxprofit = Math.max(maxprofit, profit);
            }
            sell++;
        }
        return maxprofit;
        // int maxprofit = 0;
        // int n = prices.length;
        // for(int i = 0; i < n ; i++){
        //     for(int j = i+1; j < n ; j++){
        //         int profit = prices[j] - prices[i];
        //         maxprofit = Math.max(maxprofit , profit); 
        //     }
        // }
        // return maxprofit;
    }
}
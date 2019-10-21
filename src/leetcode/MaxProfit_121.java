package leetcode;

public class MaxProfit_121 {
    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    //
    //注意你不能在买入股票前卖出股票。
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int res = 0;//当前最大利润
        int min = prices[0]; //当前最低价格
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }
}

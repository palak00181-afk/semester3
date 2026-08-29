package practice;
import.java.util.Arrays;
public class StackProfit{
    public static int maxProfit(int[] prices){
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
}
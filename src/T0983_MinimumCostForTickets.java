/**
 * [动态规划] 火车旅行最低车票问题
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class T0983_MinimumCostForTickets {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        int i = minCostTickets(days, costs);
        System.out.println(i);
    }

    public static int minCostTickets(int[] days, int[] costs) {
        // 创建一个动态规划的数组
        int[] dp = new int[days[days.length-1]+1];
        // 标记需要出行的日子
        for (int day : days) {
            dp[day] = Integer.MAX_VALUE;
        }
        // 开始逐个计算
        for (int i = 1; i < dp.length; i++) {
            // 如果不是预先标记的日子
            // 表示没有出门也没有费用产生
            // 当天的花销就是上一天的花销
            if (dp[i] != Integer.MAX_VALUE){
                dp[i] = dp[i-1];
            }else {
                // 购买单日票
                int n1 = dp[i-1]+costs[0];
                // 购买周票
                int n2 = i > 7 ? dp[i-7]+costs[1] : costs[1] ;
                // 购买月票
                int n3 = i > 30 ? dp[i-30]+costs[2] : costs[2] ;
                // 三者取最低价
                dp[i] = Math.min(Math.min(n1,n2),n3);
            }
        }
        return dp[dp.length-1];
    }
}

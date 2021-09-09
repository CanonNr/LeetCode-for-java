import java.util.Arrays;

public class T0322_CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int i = coinChange(coins, 11);
        System.out.println(i);
    }

    public static int coinChange3(int[] coins, int amount) {
        int[] o = new int[amount+1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            o[i] = -1;
            int[] r = new int[coins.length];
            // 一个临时变量，记录当前最小的上一级
            for (int j = 0; j < coins.length; j++) {
                // 如果当前值等于面值 直接赋值o并break
                if (i == coins[j]){
                    o[i] = 1;
                    break;
                }else if(i>coins[j]){
                    int t = i - coins[j];
                    r[j] = o[t];
                }
            }
            Arrays.sort(r);
            System.out.println(Arrays.toString(r));
            if (o[i]!=-1&&o[i]!=0){
                o[i]= r[0]+1;
            }
        }
        System.out.println(Arrays.toString(o));
        return o[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
//        Arrays.sort(coins);
        //Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;
            // 一个临时变量，记录当前最小的上一级
            for (int j = 0; j < coins.length; j++) {
                // 如果当前金额存在于面值中则直接返回1
//                if (i==coins[j]){
//                    dp[i] = 1;
//                    break;
//                }

                if (coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount]==amount+1?-1:dp[amount];
    }
}

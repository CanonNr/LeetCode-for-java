import java.util.Arrays;

/**
 * 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class T0674_longestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int lengthOfLCIS = findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }

    /**
     * 动态规范思路
     * 反而比最简单的效率更差了 2333 , 还是不太适用于这道题
     * 执行用时：8 ms, 在所有 Java 提交中击败了5.93%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了96.13%的用户
     */
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[nums.length-1];
    }
    /**
     * 普通的思路1
     * 执行用时: 1 ms
     * 内存消耗: 39.3 MB
     */
    public static int findLengthOfLCIS1(int[] nums) {
        // 定义一个最大值
        int max = 0;
        // 临时计数
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            // 获取上一个值,如果i为0直接返回0
            int pre = i > 0 ? nums[i-1] : 0;
            // 根据上一个值的大小判断是否重新计算
            // 如果当前值大于上一个值 或 t == 0(第一轮)  t就+1
            // 如果小于则最长的结束 重新从0 开始
            t = (nums[i] > pre || t == 0)?t+1:1;
            // 如果max小于t ,则max刷新
            if (max<t) {
                max = t;
            }
        }
        return max == 0 ? t : Math.max(t,max);
    }

    /**
     * 方法一的优化版,直接跳过了1,内存得到了优化
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了98.39%的用户
     */
    public static int findLengthOfLCIS2(int[] nums) {
        int max = 0;
        int t = 1;
        for (int i = 1; i < nums.length; i++) {
            int pre =  nums[i-1];
            t = (nums[i] > pre )?t+1:1;
            if (max<t) {
                max = t;
            }
        }
        return max == 0 ? t : Math.max(t,max);
    }
}

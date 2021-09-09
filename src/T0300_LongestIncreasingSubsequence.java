import java.util.Arrays;

/**
 * 最长递增子序列,给定一个数组,求其中递增的最大个数
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class T0300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int lengthOfLCIS = lengthOfLIS(nums);
        System.out.println(lengthOfLCIS);
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        // 将dp数组所有属性设置为1,因为最少都是有一个的
        Arrays.fill(dp, 1);
        // 从第1位开始遍历,因为0位dp[0]就是1
        for (int i = 1; i < len; i++) {
            // 第二层,i作为终点,遍历0~i找到他们的大小关系
            for (int j = 0; j < i; j++) {
                // 如果前面的值 nums[j] 小于 当前的终点(nums[i])
                // 表示可以从nums[j]的最大递增序列继续加 也就是 dp[j]+1
                // 每个数都会比较一下dp[j]+1 直到 0~i 的循环结束
                // 此时 dp[j]+1 就是 0~i 最大递增序列的元素个数
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 统计dp中的最大值
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }



    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            int flag = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]>flag){
                    max++;
                    flag = nums[j];
                }
            }
            dp[i] = dp[i-1]+max;
        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[nums.length-1];
    }

}

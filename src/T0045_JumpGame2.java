// https://leetcode-cn.com/problems/jump-game-ii/submissions/
public class T0045_JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};

        System.out.println(jump(nums));
    }

    /**
     * 贪心算法 实现
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.18%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了68.30%的用户
     * @param nums 给定一个数组
     * @return 返回大小步数
     */
    public static int jump(int[] nums) {
        if (nums.length==1) return 0;
        int index = 0;
        int o = 1;
        while (true){
            int maxI = 0;
            int maxIndex = Math.min(index + nums[index], nums.length);
            if (maxIndex>=nums.length-1){
                return o;
            }
            // 此处注意 , 最初版本写成了计算每个区间内的最大值
            // 结果被 [10,9,8,7,6,5,4,3,2,1,1,0] 制裁了
            // 因为虽然9~1的区间内 9 最大 但是走的不是最远的
            // 因此优化为计算每个值能走的最远下标 (当前下面+当前值)
            for (int i = index+1; i < maxIndex+1; i++) {
               if (maxI<=i+nums[i]){
                   maxI = i+nums[i];
                   index = i;
               }
            }
            o++;
        }
    }
}

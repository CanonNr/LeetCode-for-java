import java.util.Arrays;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了97.82%的用户
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0001_TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 实例化一个结果
        int[] result = new int[2];
        // 第一层循环
        for (int i = 0; i < nums.length; i++) {
            // 第二层循环 从 i+1 开始,因为i+1之前的都已经循环过了
            for (int j = i+1; j < nums.length; j++) {
                // 如果两个值相加得 目标值 则返回
                if ((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
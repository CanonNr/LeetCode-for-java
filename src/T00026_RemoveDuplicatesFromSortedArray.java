/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T00026_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates1(nums);
        System.out.println(i);
    }

    /**
     * 双指针的思路
     * 初始化一个双指针,起点分别是0和1
     * 循环判断:如果 高位等于低位 在没有溢出的前提下 高位+1
     * 反之低位+1 并把高位的值赋给低位
     *
     * 执行用时：6 ms, 在所有 Java 提交中击败了7.43%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了87.05%的用户
     */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int l = 0;
        int h = 1;
        while (true){
            // 如果高位和低位相等
            // 在没有溢出的前提下 高位+1
            if (nums[l] == nums[h]){
                if (h+1<nums.length){
                    h++;
                }else {
                    break;
                }
            }else {
                // 不相等则低位+1
                // 并把高位的值赋给低位
                l++;
                nums[l] = nums[h];
            }
        }
        return l+1;
    }

    /**
     * 其实思路没变只是修改了一些语法,但是执行结果大不一样
     * 执行时间减少5ms,内存增加0.3MB
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了80.29%的用户
     * 内存消耗：40.4 MB, 在所有 Java 提交中击败了25.49%的用户
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int l = 0;
        int h = 1;
        while (true){
            if (nums[l] == nums[h]){
                if (h++>=nums.length-1){
                    break;
                }
                continue;
            }
            nums[++l] = nums[h];
        }
        return l+1;
    }
}

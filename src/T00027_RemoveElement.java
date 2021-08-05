import java.util.Arrays;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T00027_RemoveElement {
    public static void main(String[] args) {
        // [0,1,4,0,3]
        int[] nums = new int[]{3,2,2,3};
        int i = removeElement4(nums,3);
        System.out.println(i);
    }

    /**
     * 类似于26题，使用双指针的思路，
     * 区别在于在不确定是不是数组第一个值就是需要剔除的前提下 高位和低位都需要从0开始。
     *
     *  这题的思路就好比:猎人(低指针位)带着猎狗(高指针位)去打猎。
     *  猎人比较懒(低位不主动去扫描数组),都交给猎狗去抓猎物(高位负责扫描数组)。
     *  猎狗只会抓兔子，如果遇到其他动物就继续往前走（遇到剔除值则高位++）。
     *  猎人只负责把猎物装起来（低位后面的都是我们需要的），猎人总会预留好口袋装猎狗抓来的猎物（low++）
     *  当猎狗到达森林的边缘就结束今天的任务（溢出 跳出）
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.2 MB, 在所有 Java 提交中击败了15.17%的用户
     */
    public static int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return 0;
        // ↓ 实测可有可无
        if (nums.length == 1 && nums[0] != val ) return 1;
        int low = 0;
        int high = 0;
        do {
            // 如果低位值不是剔除值
            if (nums[low] != val) {
                //则高位和第位都加1
                low++;
                high++;
            } else {
                // 如果是需要剔除的值
                try {
                    // 因为可能数组存在连续多个需要剔除的值，所以写了一个循环
                    // 加了一个异常捕获用于判断溢出
                    while (nums[++high] == val){}
                }catch (Exception e){
                    break;
                }
                // 当执行到当前位置时 就表示已经走过了所有剔除值
                // 此时的高位已经不是需要剔除的值了 所以直接赋值给low位
                nums[low] = nums[high];
                // 将原来的高位赋值为需要替换的值
                // 算是做一个标记 防止后面重复
                nums[high] = val;
                // low位加一
                low++;
            }
        } while (high <= nums.length - 1);
        return low;
    }

    /**
     * 第二版: 双指针,代码简介了很多
     */
    public static int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 第三版:思想还是双指针,根据第一版优化而来
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了27.65%的用户
     */
    public static int removeElement3(int[] nums, int val) {
        int low = 0;
        for (int high = 0; high < nums.length; high++) {
            if (nums[low] == val) {
                while (nums[high] == val){
                    if (high>=nums.length-1) return low;
                    high++;
                }
                nums[low] = nums[high];
                nums[high] = val;
            }
            low++;
        }
        return low;
    }


    public static int removeElement4(int[] nums, int val) {
        int low = 0;
        int high = 0;

        while (true){
            if (high<nums.length){
                if (nums[high]==val){
                    high++;
                }else {
                    nums[low] = nums[high];
                    low++;
                    high++;
                }
            }else {
                break;
            }
        }
        return low;

    }
}

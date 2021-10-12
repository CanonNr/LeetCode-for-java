import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class T0088_MergeSortedArray {
    public static void main(String[] args) {
        // num1 的长度足以存够所有的数字
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;
        int[] num2 = {2,5,6};
        int n = 3;
        merge(num1,m,num2,n);
    }

    // 第一版
    // 思路：双指针 从大到小 比较赋值
    // 已知nums1长度足够容纳最终所有数字，那么nums1[m-1] 就是 nums1的最大值
    // nums2 的最大值就是他的最后一位 nums2[n]
    // 从nums1的最后一位开始，从大到小安排
    // 执行用时：2 ms, 在所有 Java 提交中击败了17.71%的用户
    // 内存消耗：38.4 MB, 在所有 Java 提交中击败了65.77%的用户
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) return;
        for (int i = nums1.length-1; i >= 0; i--) {
            // 下面两个判断用于 n和m的出界的问题
            if (m == 0){
                nums1[i] = nums2[n-1];
                n--;
                continue;
            }
            if (n==0){
                nums1[i] = nums1[m-1];
                m--;
                continue;
            }
            if (nums1[m-1] > nums2[n-1]){
                nums1[i] = nums1[m-1];
                m--;
            }else{
                nums1[i] = nums2[n-1];
                n--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}

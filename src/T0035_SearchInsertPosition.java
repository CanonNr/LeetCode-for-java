public class T0035_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int i = searchInsert2(nums,5);
        System.out.println(i);
    }

    /**
     *
     * O(n) 的复杂度,从头开始遍历
     * 若当前值是否等于目标值  则返回当前键
     * 若 num[i] > 目标值 > num[i-1] 则返回i+1
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了70.87%的用户
     */
    public static int searchInsert1(int[] nums, int target) {
        if (nums[0] > target) return 0;
        int l = 0;
        int h = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (l >= nums.length-1) return nums.length;
            if(nums[l] < target && nums[h]>target){
                return l+1;
            }else{
                l++;
                h++;
            }

        }
        return nums.length;
    }

    /**
     * 由上一版优化一些变量
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了91.98%的用户
     */
    public static int searchInsert2(int[] nums, int target) {
        if (nums[0] > target) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (i >= nums.length-1) return nums.length;
            if(nums[i] < target && nums[i+1]>target){
                return i+1;
            }
        }
        return nums.length;
    }
}

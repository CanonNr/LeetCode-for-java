import java.util.Arrays;

public class T0066_PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 首先给数组的最后一个元素加一
     * 然后开始从后往前遍历每个值,如果大于等于 10 当前位则取 10的余数 ,上一位+1
     * 若没有上一位则复制一个新的数组,因为题目只+1 所以 第一位一定为1
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.9 MB, 在所有 Java 提交中击败了47.60%的用户
     */
    public static int[] plusOne(int[] digits) {
        digits[digits.length-1]+=1;
        for (int i = digits.length-1; i >= 0 ; i--) {
            if (digits[i]>=10){
                digits[i] = digits[i]%10;
                if (i != 0){
                    digits[i-1] +=1;
                }else{
                    int[] newDigits = new int[digits.length+1];
                    System.arraycopy(digits,0,newDigits,1,digits.length);
                    newDigits[0] = 1;
                    return newDigits;
                }
            }
        }
        return digits;
    }
}

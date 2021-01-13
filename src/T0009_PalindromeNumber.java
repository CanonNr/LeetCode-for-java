/**
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0009_PalindromeNumber {
    public static void main(String[] args) {
        boolean palindrome2 = isPalindrome2(121);
        System.out.println(palindrome2);
    }

    /**
     * 获取int的位数 通过取余和相处分别得到首位和末尾位
     * for循环比较
     * 执行用时：15 ms, 在所有 Java 提交中击败了15.32%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了57.94%的用户
     */
    public static boolean isPalindrome1(int x) {
        int l = Integer.toString(x).length();
        // 因为是双比较 要复制一个x
        int t = x;
        // 负数一定为false
        if (x < 0) return false;
        for (int i = l; i > 0; i--) {
            // 获取首尾 的除数,例如 12345 / 10000 = 1
            int pow = (int)Math.pow(10, i-1);
            int i1 = x / pow;
            // 去掉首尾
            x -= pow*i1;

            // 通过取余获取末尾值  12345/10 = 5
            int i2 = t % 10;
            // 执行完一次就/10 因为是int 不会有小数
            t/=10;
            //比较
            if (i1 != i2) return false;
        }
        return true;
    }

    /**
     * 方法一是双循环仔细一想简直脱裤子放屁
     * 第二版单循环 只反转了参数x 然后和原参数对比
     * 执行用时：10 ms, 在所有 Java 提交中击败了77.94%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了50.55%的用户
     */
    public static boolean isPalindrome2(int x) {
        int t = x;
        int r = 0;
        // 负数一定为false
        if (x < 0) return false;
        while (t != 0){
            int l = t % 10;
            r = r*10+l;
            t/=10;
        }
        return x == r;
    }
}

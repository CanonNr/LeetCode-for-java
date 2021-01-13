/**
 * 执行结果：通过
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.6 MB, 在所有 Java 提交中击败了47.46%的用户
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0007_ReverseInteger {
    public static void main(String[] args) {
        int reverse = reverse(-1234567892);
        System.out.println("result:"+reverse);
    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0){
            // 每一轮的反转都是将值放在结果的个位上
            // 开始前将结果*10  , 此时结果的个位一定是0
            result *= 10;
            // 取余获取个位的值
            int i = x % 10;
            // 参数值每次都 /10 , 下一轮要取的值一定在个位上
            x /= 10;
            // 将前面预留了个位的结果  + 通过取余得到的个位值相加
            result +=i;
            // long类型比int存的多,初始化的结果对象为long,反转期间如果超出int范围该判断肯定不同
            if ((int) result != result){
                return 0;
            }
        }
        return (int)result;
    }
}

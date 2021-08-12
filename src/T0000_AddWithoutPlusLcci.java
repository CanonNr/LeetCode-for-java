/**
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * 题目地址:https://leetcode-cn.com/problems/add-without-plus-lcci/
 */
public class T0000_AddWithoutPlusLcci {
    public static void main(String[] args) {
        int a = 17;
        int b = 99;
        System.out.println(a-b);
        System.out.println(subtraction(a, b));
    }

    public static int add1(int a, int b) {
        // 只要 b 不等于0 就循环
        while(true){
            // 第一步 计算 a+b 的 无进制加法  异或运算
            // 异或运算:相同为0 不同为1
            // 因为二进制相加 1+1 或者 0+0 一定等于0 ,1+0或者0+1 一定等于1
            // 注意此处是无进制,就是二进制各位相加但是不计算进位
            int c = a^b;

            // 第二步计算进位
            // 与运算,都为1才是1
            // a&b之后只是知道了哪些位是 1+1的情况,进位是要它的下一位 需要位运算一些
            int d = (a & b) << 1;

            // 判断进位
            if (d == 0){
                // 如果进位为0 直接返回结果
                return c;
            }else{
                // 如果进位不为0 则重新赋值a和b
                // a 是无进位相加的结果
                // b 是进位
                a=c;
                b=d;
            }

        }
    }

    /**
     * 递归版,看起来更简洁一点
     */
    public static int add2(int a, int b) {
        int i = a ^ b;
        int j = (a & b) << 1;
        return j == 0 ? i : add2(i,j);
    }

    /**
     * 扩展实现相减
     * 根据 : a-b = a+-b
     * 减法变加法,加法已经实现现在需要b的相反数
     * 相反数等于 ~b+1
     */
    public static int subtraction(int a, int b){
        return add2(a,add2(~b,1));
    }



}

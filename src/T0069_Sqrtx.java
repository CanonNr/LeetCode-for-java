public class T0069_Sqrtx {
    public static void main(String[] args) {
        int i = 2147395599;
        System.out.println(mySqrt(i));
//        System.out.println((int)Math.sqrt(8));
    }

    /**
     *  二分法  初始值 低位为0 , 高位为x
     *  每次中位的平方与x比较 ,小于则中位改为高位 , 大于则中位改为低位
     */
    public static int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x  < 4) return 1;
        // 创建三个遍历 ：l 低位 ，  r 高位 ， ans 结果 默认为0 因为求根最小就是0
        int l = 0, r = x, ans = 0;
        // 如果高位小于低位则循环结束
        while (l <= r){
            // 求中位
            int mid = l + (r - l) / 2;
            // 此处小心 int 类型溢出，使用long类型
            // 比较中位的平方 和 x 的大小
            // 如果中位的平方大于x 则x的平方根是小于中位的,所以高位要调整到中位-1
            // 如果中位的平放小于x 则x的平方根是大于中位的,所以低位要调整到中位+1

            if ((long)mid*mid <= x){
                // 因为最终结果是向下取整 ans赋值所以放在了这
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}

public class T0069_Sqrtx {
    public static void main(String[] args) {
        int i = 8;
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
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (mid*mid <= x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}

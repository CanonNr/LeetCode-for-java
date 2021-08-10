

public class T0067_AddBinary {
    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    /**
     * 获取两个字符串的长度,循环逐个取出每个字符
     * 如果长度不足则默认补个零
     * 定义一个变量为进位,默认为0,需要进位时为1,记得不进位时改回为0
     * 遍历结束如果进位还是1则在结果最左侧加一个1
     */
    public static String addBinary(String a, String b) {
        int al = a.length()-1;
        int bl = b.length()-1;
        int j = 0;
        StringBuilder result = new StringBuilder();

        while (al>=0||bl>=0){

            // int t1 = al >= 0 ? Character.getNumericValue(a.charAt(al)) : 0;
            // int t2 = bl >= 0 ? Character.getNumericValue(b.charAt(bl)) : 0;
            // 两种写法  看起来更优雅的将char与int运算
            int t1 = al >= 0 ? a.charAt(al)-'0' : 0;
            int t2 = bl >= 0 ? b.charAt(bl)-'0' : 0;
            int t = t1 + t2 + j;

            if (t>=2){
                t = t-2;
                j = 1;
            }else {
                j = 0;
            }
            result.insert(0, t);

            al--;
            bl--;
        }

        if (j == 0){
            return result.toString();
        }else {
            return "1"+result;
        }

    }
}

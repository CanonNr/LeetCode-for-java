public class T0028_ImplementStr {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        int i = strStr4(haystack,needle);
        System.out.println(i);
    }

    /**
     * 双指针
     * 性能极差 就不多说了,后续优化.
     */
    public static int strStr1(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[0]){
                int flag = 1;
                try{
                    for (int j = 1; j < arr2.length; j++) {
                        if(arr1[i+j] == arr2[j]) flag+=1;
                    }
                    if (flag == arr2.length) return i;
                }catch (Exception e){

                }
            }
        }

        return -1;
    }

    /**
     * 遍历字符数组arr1,如果遇到当前位 == 目标字符串的第一位
     * 则开始比较后续字符.
     * 利用String对象的切割构造,取arr1的第i位到i+arr2.length
     * 如果和目标字符串相同则返回 i
     *
     * 执行用时：2 ms, 在所有 Java 提交中击败了50.36%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了6.12%的用户
     */
    public static int strStr2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[0]){
                if (haystack.length()>=i+arr2.length && new String(arr1,i,arr2.length).equals(needle)) return i;
            }
        }

        return -1;
    }

    /**
     * 0(n) 的复杂度,每次都会截取一次字符串和目标字符串比较
     * 仅仅是做了防溢出的判断
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了69.56%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了12.52%的用户
     */
    public static int strStr3(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();

        for (int i = 0; i < arr1.length && i <= arr1.length-arr2.length; i++) {
          if(new String(arr1, i, arr2.length).equals(needle)) return i;
        }

        return -1;
    }
    public static int strStr4(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[0]){
                int flag = 1;

                    for (int j = 1; j < arr2.length && (i+j)<arr1.length && arr1[i+j] == arr2[j]; j++) {
                        flag+=1;
                    }
                    if (flag == arr2.length) return i;

            }
        }

        return -1;
    }
}

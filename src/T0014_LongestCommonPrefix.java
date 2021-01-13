/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0014_LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] arr = {"dog","racecar","car"};
        String[] arr = {"flower","flow","flight"};
        String s = longestCommonPrefix2(arr);
        System.out.println(s);
    }

    /**
     *  先取 strs[0] 的字符串为临时结果
     *  循环使用str.startsWith和每个值比较
     *  如果都为false 则临时结果切除最后一位
     *  一次类推 直到返回结果
     * 	通过	0 ms	36.9 MB
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String result = strs[0];

        for (String str: strs) {
            while (!str.startsWith(result)){
                 result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }

    /**
     *
     * 执行结果很垃圾,但是感觉思路没啥问题,有时间再回来更新一版吧
     * 设置一个游标index,每次遍历所有strs成员的第index个值,
     * 如果都相等继续往下执行
     * 如果存在不相等或错误 则表示某一个成员的第index位不是共有的前缀
     * 取任意一个成员截取 0 ~ index-1 位 即为公共前缀
     * 执行用时：7 ms, 在所有 Java 提交中击败了12.01%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了5.06%的用户
     *  ------------------------
     *  第二版:
     *  在 for 循环体内有一处: char[] chars = strs[i].toCharArray();
     *  然后通过 chars[index] 作比较
     *  将 toCharArray 这波操作改成 strs[i].charAt(index) 性能大大改善
     *
     *  执行用时：1 ms, 在所有 Java 提交中击败了85.79%的用户
     *  内存消耗：37 MB, 在所有 Java 提交中击败了19.40%的用户
     *
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int index = 0;
        while (true){
            char temp = '\0';
            for (int i = 0; i < strs.length; i++) {
                try {
                    char c = strs[i].charAt(index);
                    if (i == 0){
                        temp = c;
                        continue;
                    }
                    if (temp != c){
                        return strs[0].substring(0,index);
                    }
                }catch (Exception e){
                    return strs[0].substring(0,index);
                }

            }
            index++;
        }

    }


}
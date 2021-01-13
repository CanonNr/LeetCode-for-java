import java.util.HashMap;

/**
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/roman-to-integer
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0013_RomanToInteger {
    public static void main(String[] args) {
        int i3 = romanToInt3("MCMXCIV");
        System.out.println(i3);
    }

    /**
     * 思路：将字符串转成char类型的数组遍历去转换每一个值
     * 如果前一位的值比后一位的大就要减
     * 9 ms	38.9 MB
     */
    public static int romanToInt1(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = chars.length-1; i >= 0;i--){
            // 如果不是首位则需要判断前一位
            if (i != 0){
                String char1 = String.valueOf(chars[i]);
                String char2 = String.valueOf(chars[i-1]);
                if (map.get(char1) > map.get(char2)){
                    int m = map.get(char1) - map.get(char2)- map.get(char2);
                    result+=m;
                    continue;
                }
            }
            Integer m = map.get(String.valueOf(chars[i]));
            result += m;
        }

        return result;
    }

    /**
     * 思路：核心没有变化第一版是从后往前遍历
     * 这一版是从前往后 在计算结果的时候比第一版方便了好多
     * 8 ms	39.1 MB
     */
    public static int romanToInt2(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length;i++){
            int char1 = map.get(String.valueOf(chars[i]));
            if (i < chars.length-1){
                int char2 = map.get(String.valueOf(chars[i+1]));
                if (char1 < char2){
                    result-=char1;
                    continue;
                }
            }
           result+=char1;
        }
        return result;
    }

    /**
     * 基于第二版改的，都没有变就是把原来的hashmap换成了一个switch
     * 运行时间大幅提升
     * 执行用时：5 ms, 在所有 Java 提交中击败了71.68%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了65.43%的用户
     */
    public static int romanToInt3(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length;i++){
            int char1 = getValue(chars[i]);
            if (i < chars.length-1){
                int char2 = getValue(chars[i+1]);
                if (char1 < char2){
                    result-=char1;
                    continue;
                }
            }
            result+=char1;
        }

        return result;
    }

    private static int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

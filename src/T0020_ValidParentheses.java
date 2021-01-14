import java.util.Stack;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0020_ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid1("{[]}");
        System.out.println(valid);
    }

    /**
     * 只需要遍历一次字符串
     * 如果是 开口 则将对应的闭口压入到栈
     * 若不是 开口 则取栈最上面的一条数据和当前闭口是否相等
     * 相等则继续循环。不相等直接返回false
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.17%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了18.97%的用户
     */
    public static boolean isValid1(String str) {
        // 为空则false
        if (str == null) return false;
        // 长度若为单数 一定false
        if ((str.length()%2) !=0) return false;
        // 实例化一个栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (int i = 0; i < str.length(); i++) {
            // 当前字符
            char s = str.charAt(i);
            // 若为开口则push相应的闭口
            if (s=='('){
                stack.push(')');
            }else if(s=='['){
                stack.push(']');
            }else if(s=='{'){
                stack.push('}');
            }else if (stack.empty()||stack.pop() != s){
                // 如果为闭口做判断
                // 若栈为空 或 当前闭口和栈第一个不相同
                // 则返回 false
                return false;
            }
        }
        // 当遍历结束如果栈内还有参数则返回false
        if (!stack.empty()){
            return false;
        }
        return true;
    }

}

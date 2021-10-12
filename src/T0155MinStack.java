import java.util.Stack;

/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class T0155MinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
    }
}


/**
 * 自行通过链表形式实现了一个简单的栈,同比下面的使用jdk栈要更省内存
 * 在链表的每个节点都设置一个min属性,即当前最小值
 * 执行用时：4 ms, 在所有 Java 提交中击败了99.84%的用户
 * 内存消耗：40.4 MB, 在所有 Java 提交中击败了5.64%的用户
 */
class MinStack {

    private StackNode head;

    public MinStack() {

    }


    public void push(int val) {
        // 因为没有写构造方法,需要在首次push 的时候创建head节点
        if (head == null){
            // 如果head为空很简单 直接push即可,最小值就是val
           head = new StackNode(val,val);
        }else{
            // 如果已经push过
            // 则创建一个新的node,注意因为栈是先进后出,
            // 顺序和传统链表不同,不是将新数据设置为head的next
            // 而是new一个新的节点,将现有head设置为新节点的next
            // 最小值只需要对比当前val和旧的head的取两者最小值即可
            head = new StackNode(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class StackNode {
        int val;
        int min;
        StackNode next;

        private StackNode(int val, int min) {
            this(val, min, null);
        }

        private StackNode(int val, int min, StackNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * MinStack方法内存放两个栈对象,一个用于正常存放push 的数据
 * 另一个只存放当前最小值,如果push的数据小于top则插入到minStack内,如果大于则插入原top的数据
 * 没有自行实现栈结构
 * 执行用时：5 ms, 在所有 Java 提交中击败了67.92%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了32.36%的用户
 */
class MinStack2{
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;
    public MinStack2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        int minVal;
        stack.push(val);
        if (minStack.empty()){
            // 小队列为空
            minVal = val;
        }else{
            Integer minTop = minStack.peek();
            minVal = minTop > val ? val : minTop;
        }
        minStack.push(minVal);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

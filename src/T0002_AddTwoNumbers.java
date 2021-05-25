
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T0002_AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
//        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));

        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode ints = addTwoNumbers(l1, l2);

        System.out.println(Arrays.toString(ints.toArray()));
    }

    /**
     * 没有认真读题,错的很离谱哈哈哈哈
     */
    public static Object[] addTwoNumbers1(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (true){
            s1.push(l1.val);
            if (l1.next == null){
               break;
            }
            l1 = l1.next;
        }

        while (true){
            s2.push(l2.val);
            if (l2.next == null){
                break;
            }
            l2 = l2.next;
        }
        int j = 0;
        while(true){
            int a1 =  s1.size()>0?s1.pop():0;
            int a2 =  s2.size()>0?s2.pop():0;
            int a3 = a1 + a2 + j;
            if (a3>=10){
                j=1;
                a3 = a3%10;
            }else{
                j=0;
            }
            result.add(a3);
            if (s1.size() == 0 && s2.size() == 0){
                if (j==1){
                    result.add(1);
                }
                break;
            }
        }
        Object[] ints = result.toArray();
        return ints;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为下面需要一边修改链表 最后还要返回完整链表 所以复制出来一份
        ListNode root = new ListNode(0);
        ListNode result = root;
        // j是下面计算的时候进位  为0或1
        int j = 0;
        int v1;
        int v2;
        int v3;
        while (true){
            // 如果两个链表都为空时结束循环
            if (l1 == null && l2 == null){
                // 如果还有进位没算则直接加个1
                if (j == 1){
                    result.next = new ListNode(1);
                }
                break;
            }
            v1 = (l1 == null) ? 0 : l1.val;
            v2 = (l2 == null) ? 0 : l2.val;
            v3 = v1+v2+j;
            if (v3>=10){
                j=1;
                v3 = v3%10;
            }else{
                j=0;
            }
            result.next = new ListNode(v3);
            result = result.next;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
        }
        return root.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        public int[] toArray(){
            List<Integer> list = new ArrayList<Integer>();
            ListNode a = this;
            while(true){
                list.add(a.val);
                if (a.next != null){
                    a = a.next;
                }else{
                    break;
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

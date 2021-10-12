public class T0206_ReverseLinkedList  {
    public static void main(String[] args) {
        ListNode206 list = new ListNode206(1,new ListNode206(2,new ListNode206(3,new ListNode206(4))));
        print(list);
        ListNode206 list2 = reverseList(list);
        print(list2);

    }

    public static ListNode206 reverseList(ListNode206 head) {
        if (head == null) {
            return head;
        }
        ListNode206 node = head;
        // 用于当作每个节点的前一个节点
        ListNode206 prev = null;
        while (node != null) {
            // 先存储每当前点的下一个节点
            ListNode206 next = node.next;
            // 将当前节点的 next 指针指向前一个节点
            node.next = prev;
            // 将当前节点作为下一个节点的前置节点
            prev = node;
            // 将 后置节点 继续当作 当前节点来重复这个动作
            node = next;
        }
        return prev;
    }

    public static void print(ListNode206 node){
        while (true){
            System.out.print(node.val);
            if (node.next == null){
                System.out.println("");
                break;
            }
            node = node.next;
        }
    }
}

class ListNode206 {
    int val;
    ListNode206 next;
    ListNode206() {}
    ListNode206(int val) { this.val = val; }
    ListNode206(int val, ListNode206 next) { this.val = val; this.next = next; }
}
public class T0021_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1,l2);
        System.out.println(listNode);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    public static void print(ListNode node){
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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

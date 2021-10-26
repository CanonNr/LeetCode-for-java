public class T0019_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
//        ListNode0019 list = new ListNode0019(1,new ListNode0019(2,new ListNode0019(3,new ListNode0019(4,new ListNode0019(5)))));
        ListNode0019 list = new ListNode0019(1,new ListNode0019(2));
        ListNode0019 listNode00191 = removeNthFromEnd(list, 2);
        print(listNode00191);
    }


    private static ListNode0019 removeNthFromEnd(ListNode0019 head, int n) {
        if (n==0) return head;
        if (n==1&&head.next==null) return null;
        ListNode0019 dummy = new ListNode0019(-1,head);
        ListNode0019 x = dummy;
        ListNode0019 y = dummy;
        while (true){
            if (n-- > 0){
                y = y.next;
                continue;
            }

            if (y.next!=null){
                x = x.next;
                y = y.next;
            }else{
                ListNode0019 p = x.next.next;
                x.next = p;
                break;
            }
        }
        return dummy.next;
    }


    public static void print(ListNode0019 node){
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

class ListNode0019 {
    int val;
    ListNode0019 next;
    ListNode0019() {}
    ListNode0019(int val) { this.val = val; }
    ListNode0019(int val, ListNode0019 next) { this.val = val; this.next = next; }
}
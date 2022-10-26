package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode h = head;
        ListNode nex = h.next;
        ListNode prev = null;

        while(h != null){
            h.next = prev;
            prev = h;
            h = nex;
            if(nex != null){
                nex = nex.next;
            }
        }

        return prev;
    }
}

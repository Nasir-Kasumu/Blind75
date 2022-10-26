package LinkedList;
// slow fast node technique
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        int count = n;

        while(count > 0){
            fast = fast.next;
            count--;
        }

        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(prev == null){//remove head
            head = head.next;
        }
        else if(slow.next != null){//remove mid
            prev.next = prev.next.next;
        }else if(slow.next == null){//remove end
            prev.next = null;
        }

        return head;
    }
}

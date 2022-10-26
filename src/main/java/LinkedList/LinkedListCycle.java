package LinkedList;
// slow fast node tech
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast && fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }

        if(fast != null && slow != null && fast == slow){
            return true;
        }
        return false;
    }
}

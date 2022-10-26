package LinkedList;

import static LinkedList.ListNode.printList;

/*
Good one to practice
1 -> 2 -> 3 -> 4
Approach 1 use a deque and add from both sides
keep pointer to head and add rest to a dq
dq.addEnd then dq.addBeginning
DQ - <2,3,4>
Head - 1
<2,3>
1 -> 4
<3>
1 -> 4 -> 2
<>
1 -> 4 -> 3 -> 2
Approach 2
- Find the midpoint
1 -> 2 -> 3 -> 4
          *
- reverse the second half
1 -> 2
3 -> 4
- Add every other value

1 -> 4 -> 3 -> 2
 */
public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode prev = null;
        ListNode second = slow;
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //printList(sNext);
        printList(prev);
        printList(head);
        ListNode curr = head;
        while(curr != null){
            ListNode t1 = prev.next;
            ListNode t2 = curr.next;
            curr.next = prev;
            prev.next = t2;
            curr = t2;
            prev = t1;
        }
    }
}

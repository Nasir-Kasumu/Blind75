package LinkedList;
// use dummy node merge two lists on multiple lists
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = null;
        ListNode res = dummy;
        for(int i  = 0; i < lists.length; i++){
            dummy = mergeLists(lists[i], dummy);
            //printList(dummy);
        }
        return dummy;
    }

    public void printList(ListNode a){
        while(a != null){
            System.out.print(a.val + "->");
            a = a.next;
        }
        System.out.println();
    }

    public ListNode mergeLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(a != null && b != null){
            if(a.val > b.val){
                dummy.next = b;
                b = b.next;
            }else{
                dummy.next = a;
                a = a.next;
            }
            dummy = dummy.next;
        }

        if(a != null){
            dummy.next = a;
        }
        if(b != null){
            dummy.next = b;
        }
        return res.next;
    }
}

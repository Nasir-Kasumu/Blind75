package LinkedList;
// Dummy node here is a lifesaver
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = new ListNode(-1);
        ListNode res = l3;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                l3.next = list2;
                list2 = list2.next;
            }else{
                l3.next = list1;
                list1 = list1.next;
            }
            l3 = l3.next;
        }

        if(list1 != null){
            l3.next = list1;
        }
        if(list2 != null){
            l3.next = list2;
        }
        return res.next;
    }
}

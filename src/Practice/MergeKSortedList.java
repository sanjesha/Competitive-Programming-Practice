package Practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComp());
        for ( ListNode l: lists) {
            pq.add(l);
        }

        ListNode sNode = new ListNode();
        ListNode head = sNode;

        while(!pq.isEmpty()){
            sNode.next = pq.remove();
            sNode = sNode.next;
            if(sNode.next != null)
                pq.add(sNode.next);
        }

        return head.next;

    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ListNodeComp implements Comparator<ListNode> {

    // Method
    // Sorting in ascending order of node val
    public int compare(ListNode a, ListNode b)
    {

        return a.val - b.val;
    }
}
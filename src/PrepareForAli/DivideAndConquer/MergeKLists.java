package PrepareForAli.DivideAndConquer;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(o->o.val));

        for(ListNode list : lists){
            while(list != null){
                queue.offer(list);
                list = list.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode res = head;
        ListNode cur;

        while((cur = queue.poll()) != null){
            head.next = cur;
            head = head.next;
        }

        head.next = null;//head.next, not head, 写错会导致内存超出限制

        return res.next;
    }
}

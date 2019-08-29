package PrepareForAli.List;

import java.util.List;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;


        //循环条件是最关键的，为何是end.next 而不是 end
        while(end.next != null){
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            //这段逻辑较精巧,要仔细体会，翻转后，start变成翻转后的尾结点
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;//注意，必须是start.next，start必须是下一次翻转的前一个节点

            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

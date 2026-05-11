/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode revHead = null;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = revHead;
            revHead = node;
            cur = cur.next;
            size++;
        }
        int length = size/2;
        boolean even = size%2 == 0;
        for (int i = 0; i < length; i++) {
            ListNode temp = head.next;
            head.next = revHead;
            revHead = revHead.next;
            if (even && i == length-1 )
                head.next.next = null;
            else
                head.next.next = temp;
            head = temp;
        }
        head.next = null;
        revHead.next = null;
    }
}

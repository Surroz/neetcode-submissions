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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        if (length == n)
            return head.next;
        
        int target = length - n -1;
        length = 0;
        node = head;
        while (target != length) {
            length++;
            node = node.next;
        }
        if (n == 1) 
            node.next =null;
        else 
            node.next = node.next.next;
        
        return head;
    }
}

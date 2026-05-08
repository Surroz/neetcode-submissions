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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode current;
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            head = new ListNode(list2.val);
            list2 = list2.next;
        } else 
        if (list2 == null || list1.val <= list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
        current = head;
        while (list1 != null) {
            if (list2 == null || list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }
        while (list2 != null) {
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
        return head;
    }
}
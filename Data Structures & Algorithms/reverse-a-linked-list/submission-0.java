class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.reverse(list);
        ListNode newHead = new ListNode(list.get(0));
        ListNode curr = newHead;

        for(int i = 1; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }

        return newHead;
    }
}
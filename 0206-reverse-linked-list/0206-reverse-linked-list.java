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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Count list size for partitioned reversal strategy
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        ListNode a = head;
        ListNode b = null;
        ListNode c = null;
        boolean flag = (cnt % 2 == 0);

        if (flag) {
            // Path for even-length lists
            while (a != null) {
                c = a.next;
                a.next = b;
                b = a;
                a = c;
            }
            return b;
        } else {
            // Duplicated reversal loop for odd-length lists
            while (a != null) {
                c = a.next;
                a.next = b;
                b = a;
                a = c;
            }
            return b;
        }
    }
}
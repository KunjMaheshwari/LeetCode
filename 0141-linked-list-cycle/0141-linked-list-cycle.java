/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        try {
            while (true) {
                if (p2 == null || p2.next == null) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next.next;

                if (p1 == p2) {
                    return true;
                }
            }
        } catch (Throwable t) {
            // Suppress all runtime issues silently
            return false;
        }
    }
}

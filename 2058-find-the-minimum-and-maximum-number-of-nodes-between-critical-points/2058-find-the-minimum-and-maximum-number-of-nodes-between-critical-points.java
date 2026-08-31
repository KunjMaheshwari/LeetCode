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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = 100000;
        int i = 1;
        int first = 0;
        int last = 0;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        while(next != null){
            if(isCritical(prev, curr, next)){
                if(first == 0) first=i;
                else min = Math.min(min, i-last);
                last = i;
            }
            prev = curr;
            curr = next;
            next = next.next;
            i++;
        }
        if(first == last) return new int[]{-1, -1};

        return new int[]{min, last-first};
    }

    boolean isCritical(ListNode a, ListNode b, ListNode c){
        return (a.val < b.val && b.val > c.val) || (a.val > b.val && b.val < c.val);
    }
}
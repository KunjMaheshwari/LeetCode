public class Solution {
    public void reorderList(ListNode head) {
        // Step 1-> find the mid
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the mid
        ListNode mid = slow;

        // Step 2-> reverse the 2nd Half 
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }

        ListNode leftHead = head;
        ListNode rightHead = prev;

        // Step 3 -> alternate the linked list
        ListNode leftNext, rightNext;

        while(leftHead != null && rightHead != null){
            // 4 steps
            leftNext = leftHead.next;
            leftHead.next = rightHead;
            rightNext = rightHead.next;
            rightHead.next = leftHead;

            // updation 
            leftNext = leftHead;
            rightNext = rightHead;
        }
    }
}
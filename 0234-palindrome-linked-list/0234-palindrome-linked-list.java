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
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // this is the middle of the Linked List
    }
    public boolean isPalindrome(ListNode head) {
        // base condition 
        if(head == null || head.next ==  null){
            return true;
        }

        // step 1-> find the middle node
        ListNode midNode = findMid(head);

        // step 2 -> reverse the second half of the Linked List
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // declaring the heads of the Linked List
        ListNode right = prev;
        ListNode left = head;

        // step 3 -> check the first and the second half of the Linked List
        while(right != null){
            if(left.val != right.val){
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }
}
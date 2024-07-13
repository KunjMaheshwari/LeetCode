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
    public ListNode merge2SortedLinkedList(ListNode head1, ListNode head2){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;

            // remaining elements
            if(head1 != null){
                temp.next = head1;
            }
            if(head2 != null){
                temp.next = head2;
            }
        }
        return dummyNode.next;
    }
    public ListNode sortList(ListNode head) {
        // MergeSort function which will contain the head 
        // find the mid using the tortoise and hare algorithm
        // call the mergeSort for the left and right part 
        // Merge them using merge2LinkedList concept.

        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middleNode = slow;

        ListNode rightHead = middleNode.next;
        middleNode.next = null;
        ListNode leftHead = head;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return merge2SortedLinkedList(leftHead, rightHead);
    }
}
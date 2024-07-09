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
    public static ListNode removeFromStarting(ListNode head, int n, int size){
        if(size == n){
            return head = head.next;
        }
        int i = 1;
        ListNode prev = head;

        while(i< (size-n)){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
        
    }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    //Calculate the size
    int size = 0;
    ListNode temp = head;

    while(temp != null){
        temp = temp.next;
        size++;
    }

    return removeFromStarting(head,n,size);
  }
}
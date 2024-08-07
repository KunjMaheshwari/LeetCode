// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    // mergeSort function to merge two sorted lists
    public ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

        return dummyNode.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeSort(head, lists[i]);
        }
        return head;
    }
}

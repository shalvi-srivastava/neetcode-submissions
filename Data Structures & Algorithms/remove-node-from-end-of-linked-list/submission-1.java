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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;

        }

         if (n == size) {
            head = head.next;
            return head;
        }
        int i = 1;
        int nodeNo = size - n + 1;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            if (size == 1) {
                return head = null;
            }
            next = curr.next;
            if (i == nodeNo) {
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = next;
            i++;
        }

        return head;
    }
}
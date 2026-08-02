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
    public ListNode midMerge(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // new head
    }

    public void reorderList(ListNode head) {
        ListNode leftHead = head;
        ListNode mid = midMerge(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        rightHead = reverse(rightHead);
        ListNode nextLeft, nextRight;

        while (leftHead != null && rightHead != null) {
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;
        }
    
    }
}
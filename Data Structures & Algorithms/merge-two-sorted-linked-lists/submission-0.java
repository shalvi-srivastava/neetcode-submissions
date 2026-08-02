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
    public ListNode mergeLists(ListNode head1, ListNode head2) {

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        ListNode temp = head1;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head2;

        return head1;
    }

    public ListNode midMerge(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        ListNode mid = midMerge(head);

        // left & right
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHead);

        // merge
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;
        while (left != null && right != null) {
            if (left.val >= right.val) {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            } else {
                temp.next = left;
                left = left.next;
                temp = temp.next;

            }
        }

        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;

        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;

        }

        return mergedLL.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // return mergeSort(mergeLists(list1, list2));
        return merge(list1,list2);
    }
}
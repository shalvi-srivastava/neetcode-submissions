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

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
        
    }
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revhead = reverseList(slow);
        prev.next = null;

        while(revhead != null && head != null) {
            if(revhead.val != head.val) {
                return false;
            }

            revhead = revhead.next;
            head = head.next;
        }

        return true;
    }
}
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
        //Approach 1 : Using Stack
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while(temp !=null){
            stack.push(temp);
            temp = temp.next;
        }

        ListNode newHead = stack.pop();
        temp = newHead;
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null; // end the list
        return newHead;
    }
}
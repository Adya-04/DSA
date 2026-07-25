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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newLsHead = new ListNode();
        ListNode currLs = newLsHead;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            currLs.next = new ListNode();
            currLs = currLs.next;

            if(temp1.val > temp2.val){
                currLs.val = temp2.val;
                temp2 = temp2.next;
            }
            else{
                currLs.val = temp1.val;
                temp1 = temp1.next;
            }
        }
        while(temp1 != null){
            currLs.next = new ListNode();
            currLs = currLs.next;
            currLs.val = temp1.val;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            currLs.next = new ListNode();
            currLs = currLs.next;
            currLs.val = temp2.val;
            temp2 = temp2.next;
        }

        return newLsHead.next;
    }
}
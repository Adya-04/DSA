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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp!=null){
            ListNode kthNode = findKthNodeList(temp,k);

            if(kthNode== null){
                // Not enough nodes → attach remaining part and break
                if (prevLast != null)
                    prevLast.next = temp;
                break;
            }

        
            ListNode nextNode = kthNode.next ;
            kthNode.next = null;// detach group
            
            // Reverse the group
            ListNode newHead = reverse(temp);

            if(temp==head){ 
                head = newHead; // First group becomes new head
            }
            else{
                prevLast.next = newHead; // connect previous group
            }

            prevLast = temp;          // temp becomes last node of reversed group
            temp = nextNode;          // move to next group
        }

        return head;

    }

    public ListNode findKthNodeList(ListNode head, int k) {
        ListNode temp = head;
        k-=1;
        while (temp != null && k>0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode!= null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}
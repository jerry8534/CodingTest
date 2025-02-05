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
        ListNode dummy = new ListNode(0); // dummy node
        dummy.next = head; // dummy node points to the head
        ListNode cur = dummy; // current node
        while(cur != null){
            cur = reverseKNodes(cur, k); // reverse k nodes
        }
        return dummy.next; // return the next node of the dummy node
    }

    private ListNode reverseKNodes(ListNode head, int k){
        ListNode cur = head; // current node
        for(int i = 0; i < k; i++){ // reverse k nodes
            if(cur.next == null){ // if there are less than k nodes
                return null; // return null
            }
            cur = cur.next; // move the current node to the next node
        }
        ListNode prev = null; // previous node
        ListNode next = null; // next node
        ListNode tail = head.next; // tail node
        cur = head.next; // current node
        for(int i = 0; i < k; i++){ // reverse k nodes
            next = cur.next; // next node
            cur.next = prev; // current node points to the previous node
            prev = cur; // move the previous node to the current node
            cur = next; // move the current node to the next node
        }
        head.next = prev; // head points to the previous node
        tail.next = cur; // tail points to the current node
        return tail; // return the tail node
    }
}
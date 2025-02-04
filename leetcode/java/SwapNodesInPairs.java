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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0); // dummy node
        dummy.next = head; // dummy node points to the head
        ListNode cur = dummy; // current node
        while(cur.next != null && cur.next.next != null){ // while there are at least two nodes
            ListNode first = cur.next; // first node
            ListNode second = cur.next.next; // second node
            first.next = second.next; // first node points to the node after the second node
            cur.next = second; // current node points to the second node
            cur.next.next = first; // second node points to the first node
            cur = cur.next.next; // move the current node to the next pair
        }
        return dummy.next; // return the next node of the dummy node
    }
}
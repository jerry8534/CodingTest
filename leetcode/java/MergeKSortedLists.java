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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); // min heap
        for(ListNode node : lists){ // add all the heads of the lists
            if(node != null){ // if the list is not empty
                pq.add(node); // add the head of the list
            }
        }
        ListNode dummy = new ListNode(0); // dummy node
        ListNode cur = dummy; // current node
        while(!pq.isEmpty()){ // while the heap is not empty
            ListNode node = pq.poll(); // get the smallest node
            cur.next = node; // add the node to the list
            cur = cur.next; // move the current node to the next node
            if(node.next != null){ // if the node has a next node
                pq.add(node.next); // add the next node to the heap
            }
        }
        return dummy.next; // return the next node of the dummy node
    }
}
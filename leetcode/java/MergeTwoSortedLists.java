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
        ListNode dummy = new ListNode(); // dummy node
        ListNode current = dummy; // current node
        while(list1 != null && list2 != null){ // while both lists are not empty
            if(list1.val < list2.val){ // if list1 value is less than list2 value
                current.next = list1; // current node points to list1
                list1 = list1.next; // list1 moves to next node
            } else {
                current.next = list2; // current node points to list2
                list2 = list2.next; // list2 moves to next node
            }
            current = current.next; // current moves to next node
        }
        if(list1 != null){
            current.next = list1; // if list1 is not empty, current node points to list1
        } else {
            current.next = list2; // if list2 is not empty, current node points to list2
        }
        return dummy.next; // return dummy node's next node
    }
}
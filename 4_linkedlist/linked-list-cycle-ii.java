public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } 
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}


/*
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.
Example
Given -21->10->4->5, tail connects to node index 1，return 10
Challenge 
Follow up:
Can you solve it without using extra space
*/

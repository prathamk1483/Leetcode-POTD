
// 2181. Merge Nodes in Between Zeros


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
    public ListNode mergeNodes(ListNode head) {
        if(head == null || head.next.next == null || head.next == null) return null;
    
        ListNode tempA = head , tempB = head.next;
        int sum = 0;

        ListNode anshead = new ListNode(-1);
        ListNode ans = anshead;

        while(tempA.next!= null && tempB != null){
            if(tempB.val == 0){
                ans.next = new ListNode(sum);
                ans = ans.next;
                sum=0;
                tempA = tempB;
            }
            sum+=tempB.val;
            tempB = tempB.next != null ? tempB.next : tempB;
        }
        return anshead.next;
    }
}

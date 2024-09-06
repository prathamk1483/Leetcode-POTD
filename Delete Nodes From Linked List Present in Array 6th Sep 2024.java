class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) s.add(i);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp != null && temp.next != null) {
            if (s.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } 
            else {
                temp = temp.next;
            }
        }
        return dummy.next; 
    }
}

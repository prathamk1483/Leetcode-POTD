class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i:nums) pq.add((long)i);
        int ans = 0;
        while(true){
            if(pq.peek() >= k) break;
            long e1 = pq.remove() , e2 = pq.remove();
            long t = 2* Math.min(e1,e2) + Math.max(e1,e2);
            pq.add(t);
            ans++;
        }
        return ans;
    }
}

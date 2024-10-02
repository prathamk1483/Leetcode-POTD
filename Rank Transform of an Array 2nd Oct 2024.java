class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            s.add(arr[i]);
        }
        int h[] = new int[s.size()],idx = 0;
        for(int i:s) h[idx++] = i;
        Arrays.sort(h);
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<h.length;i++){
            m.put(h[i],i+1);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = m.get(arr[i]);
        }
        return arr;
    }
}

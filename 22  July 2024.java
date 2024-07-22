class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> m = new HashMap<>();

        for(int i=0;i<names.length;i++){
            m.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String ans[] = new String[names.length];
        for(int i=names.length-1;i>=0 ;i--) ans[ans.length-1-i] = m.get(heights[i]);
        return ans;
    }
}

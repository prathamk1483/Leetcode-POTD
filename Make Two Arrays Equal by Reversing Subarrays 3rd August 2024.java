class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;
        Map<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
            m.put(target[i],m.getOrDefault(target[i],0)-1);
        } 

        for(int i : m.keySet()) if(m.get(i) != 0) return false;
        
        return true;
    }
}

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String , Boolean> m = new HashMap<>();
        for(String i : s1.split(" ")){
            if(m.get(i)!= null) m.put(i,true); 
            else m.put(i,false);
        }
        for(String i : s2.split(" ")){
            if(m.get(i) != null) m.put(i,true);
            else m.put(i,false);
        }
        ArrayList<String> a = new ArrayList<>();
        for(Map.Entry<String , Boolean> i : m.entrySet()){
            String t = i.getKey();
            boolean u = i.getValue();
            if(!u) a.add(t);
        }
        String ans[] = new String[a.size()];
        return a.toArray(ans);
    }
}

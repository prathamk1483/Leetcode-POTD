class Solution {
    private int minutes(String time) {
        int hh = Integer.parseInt(time.substring(0, 2));
        int mm = Integer.parseInt(time.substring(3, 5));
        return hh * 60 + mm;
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> l = new ArrayList<>();
        for (String time : timePoints) {
            l.add(minutes(time));
        }
        Collections.sort(l);
        
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < l.size(); i++) {
            minDifference = Math.min(minDifference, l.get(i) - l.get(i - 1));
        }
        
        int circularDifference = (1440 - l.get(l.size() - 1)) + l.get(0);
        minDifference = Math.min(minDifference, circularDifference);
        
        return minDifference;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(frequencyMap.keySet());
        //Logic was created by me , but code to keys.sort was given by GPT
        keys.sort((a, b) -> {
            int freqCompare = Integer.compare(frequencyMap.get(a), frequencyMap.get(b));
            if (freqCompare == 0) {
                return Integer.compare(b, a); 
            }
            return freqCompare;
        });
        int[] result = new int[nums.length];
        int index = 0;
        for (int key : keys) {
            int count = frequencyMap.get(key);
            for (int i = 0; i < count; i++) {
                result[index++] = key;
            }
        }

        return result;
    }

}

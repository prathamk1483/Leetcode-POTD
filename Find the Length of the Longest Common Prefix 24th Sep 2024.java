class Solution {
    private static class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        public TrieNode() {
            child = new TrieNode[10];
            isEnd = false;
        }
    }

    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int number) {
            TrieNode node = root;
            String str = String.valueOf(number);

            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';
                if (node.child[digit] == null) {
                    node.child[digit] = new TrieNode();
                }
                node = node.child[digit];
            }
            node.isEnd = true;
        }

        public int helper(String num) {
            int ans = 0;
            TrieNode node = root;

            for (int i = 0; i < num.length(); i++) {
                int digit = num.charAt(i) - '0';
                if (node.child[digit] == null) {
                    return ans;  
                }
                ans++;
                node = node.child[digit];
            }
            return ans;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();
        int ans = 0;
        for (int i : arr1) {
            t.insert(i);
        }
        for (int i : arr2) {
            ans = Math.max(ans, t.helper(Integer.toString(i)));
        }

        return ans;
    }
}

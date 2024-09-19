class Solution {
    private List<Integer> helper(String str, int s, int e) {
        List<Integer> result = new ArrayList<>();
        if (s == e && Character.isDigit(str.charAt(s))) {
            int n = str.charAt(s) - '0';
            result.add(n);
            return result;
        }
        if (e - s == 1 && Character.isDigit(str.charAt(s))) {
            int num = Integer.parseInt(str.substring(s, e + 1));
            result.add(num);
            return result;
        }

        for (int i = s; i <= e; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) { 
                List<Integer> left = helper(str, s, i - 1);
                List<Integer> right = helper(str, i + 1, e);
                for (int l : left) {
                    for (int r : right) {
                        if (c == '*') result.add(l * r);
                        else if (c == '+') result.add(l + r);
                        else if (c == '-') result.add(l - r);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(str.substring(s, e + 1)));
        }
        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, 0, expression.length() - 1);
    }
}

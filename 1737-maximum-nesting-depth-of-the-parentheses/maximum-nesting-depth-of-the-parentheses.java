class Solution {
    public int maxDepth(String s) {
        int depth = 0, max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
                max = Math.max(max, depth);
            } else if (ch == ')') {
                depth--;
            }
        }
        return max;
    }
}
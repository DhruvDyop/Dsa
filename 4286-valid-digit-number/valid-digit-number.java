class Solution {
    public boolean validDigit(int n, int x) {
       String s = String.valueOf(n);
        char ch = (char)(x + '0');

        // Condition 1: should not start with x
        if (s.charAt(0) == ch) return false;

        // Condition 2: should contain at least one x
        for (char c : s.toCharArray()) {
            if (c == ch) return true;
        }

        return false;
    }
}
class Solution {
    public int fun(int l, int r, String s) {
        if (l > r || s == null) {
            return 0;
        }
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int same = fun(i, i, s);
            int diff = fun(i, i + 1, s);
            int l = Math.max(same, diff);
            if (l > end - start) {
                start = i - (l - 1) / 2;
                end = i + (l) / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        // main logic -> length - maxFreq <= k
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int matchedCount = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) > 0) {
                matchedCount++;
            }

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);

            while (matchedCount == t.length()) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }

                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);

                if (map.get(s.charAt(left)) > 0) {
                    matchedCount--;
                }
                left++;
            }
            right++;
        }
        return (minWindowStart == -1)
        ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Assume non-empty array from typical problem constraints
        String prefix = strs[0];

        // Compare prefix iteratively across all words in array
        for (int i = 1; i <= strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }   
}
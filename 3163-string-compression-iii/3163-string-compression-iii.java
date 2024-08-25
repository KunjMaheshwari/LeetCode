class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;

            // Count the occurrences of the current character up to a maximum of 9 times
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }

            // Append the count followed by the character to the result
            sb.append(count).append(currentChar);
        }

        return sb.toString();
    }
}

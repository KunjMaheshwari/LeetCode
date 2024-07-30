class Solution {
    public int minimumDeletions(String s) {
        char[] letters = s.toCharArray();

        int countA = 0;
        int countB = 0;
        int output = Integer.MAX_VALUE;

        for(int i=0;i<letters.length;i++){
            countA += ('b' - letters[i]);
        }

        for(int i=0;i<s.length();i++){
            output = Math.min(output, countA + countB);
            countA -= ('b' - letters[i]);
            countB += (letters[i] - 'a');
        }

        output = Math.min(output, countA + countB);
        return output;
    }
}
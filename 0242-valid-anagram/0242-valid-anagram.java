class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        if(s.length() == t.length()){
            char sCharacter[] = s.toCharArray();
            char tCharacter[] = t.toCharArray();

            Arrays.sort(sCharacter);
            Arrays.sort(tCharacter);

            Boolean charB = Arrays.equals(sCharacter, tCharacter);
            if(charB){
                return true;
            }
        }
        return false;
    }
}
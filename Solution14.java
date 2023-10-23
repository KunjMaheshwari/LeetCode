class Solution14 {
    public boolean isAnagram(String s, String t) {
        // First of all make the letters of the string small
        s = s.toLowerCase();
        t = t.toLowerCase();

        // check the length of the string 
        if(s.length()==t.length()){
            // convert the string into char arrays
            char schararray[] = s.toCharArray();
            char tchararray[] = t.toCharArray();
            // sort the char array
            Arrays.sort(schararray);
            Arrays.sort(tchararray);
            // printing the result 
            boolean result = Arrays.equals(schararray, tchararray);
            if(result){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

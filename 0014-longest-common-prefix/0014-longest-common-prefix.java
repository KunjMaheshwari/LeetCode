class Solution {
    public String longestCommonPrefix(String[] strs) {
        //String builder
        StringBuilder sb = new StringBuilder();
        //sort the strings
        Arrays.sort(strs);
        //first and last string
        String firstString = strs[0];
        String lastString = strs[strs.length-1];

        for(int i=0;i<Math.min(firstString.length(), lastString.length());i++){
            if(firstString.charAt(i) != lastString.charAt(i)){
                return sb.toString();
            }
            sb.append(firstString.charAt(i));
        }
        return sb.toString();
    }
}
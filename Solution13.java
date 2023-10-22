class Solution13 {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        int j= sb.length()-1;

        while(i<j){
            while(i<j && !Character.isLetter(sb.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetter(sb.charAt(j))){
                j--;
            }
            if(i<j){
                char frontchar = sb.charAt(i);
                char backchar = sb.charAt(j);
                sb.setCharAt(i, backchar);
                sb.setCharAt(j, frontchar);
                i++;
                j--;
            }
        }
        return sb.toString();
    }
}

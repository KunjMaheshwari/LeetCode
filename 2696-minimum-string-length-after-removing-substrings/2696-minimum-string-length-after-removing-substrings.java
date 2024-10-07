class Solution {
    public int minLength(String s) {
        Deque<Character> charStck = new ArrayDeque<>();
        for(char chr : s.toCharArray()){
           if(charStck.isEmpty()) 
            charStck.offerLast(chr);
           else{
            char stckTopChr = charStck.peekLast();
              if((stckTopChr == 'A' &&  chr == 'B') || (stckTopChr == 'C' && chr == 'D')){
                charStck.pollLast();
              }else{
                charStck.offerLast(chr);
              }
           }  
        }
        return charStck.size();
    }
}
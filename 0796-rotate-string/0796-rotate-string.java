class Solution {
    public boolean rotateString(String s, String goal) {
        //first we wil check the length and then add s+s which will be abcdeabcde and then check whether this string contains goal string or not
        return (s.length() == goal.length() && (s+s).contains(goal));
    }
}
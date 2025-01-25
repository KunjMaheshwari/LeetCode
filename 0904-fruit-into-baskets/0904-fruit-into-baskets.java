class Solution {
    public int totalFruit(int[] fruits) {
        int right = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int maxLen = 0;

        while(right < n){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);

            if(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            if(map.size() <= 2){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}
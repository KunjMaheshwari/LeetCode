class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;
        
        for (int i = 1; i < arrays.size(); i++) {
            int first = arrays.get(i).get(0);
            int last = arrays.get(i).get(arrays.get(i).size() - 1);
            
            // Calculate maximum possible distance
            maxDist = Math.max(maxDist, Math.max(Math.abs(last - minVal), Math.abs(maxVal - first)));
            
            // Update minVal and maxVal
            minVal = Math.min(minVal, first);
            maxVal = Math.max(maxVal, last);
        }
        
        return maxDist;
    }
}

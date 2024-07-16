class Solution {
    public int trap(int[] height) {
        int width = 1;
        // leftmax boundary with the help of Auxillary Arrays
        int leftmax [] = new int[height.length];
        leftmax[0] = height[0];
        for(int i=1;i<height.length;i++){
            leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }
        // rightmax boundary with the help of Auxillary Arrays
        int rightmax[] = new int[height.length];
        rightmax[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }
        // trapped rain water 
        int trappedrainwater = 0;
        for(int i=0;i<height.length;i++){
            // waterlevel 
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedrainwater += (waterlevel - height[i])* width;
        }
        return trappedrainwater;

    }
    
}
class Solution {
    public static int[] findNSE(int arr[]){
        int n= arr.length;

        int newArr[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                newArr[i] = stack.peek();
            }else{
                newArr[i] = n;
            }
            stack.push(i);
        }
        return newArr;
    }
    public static int[] findPSE(int heights[]) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while they are greater or equal to the current element
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // Assign the previous smaller element index or -1 if no such element exists
            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int nse[] = findNSE(heights);
        int pse[] = findPSE(heights);

        int maxi= 0;

        for(int i=0;i<heights.length;i++){
            int width = nse[i] - pse[i] - 1;
            int height = heights[i];

            int area = height*width;

            maxi = Math.max(maxi, area);
        }

        return maxi;
    }
}
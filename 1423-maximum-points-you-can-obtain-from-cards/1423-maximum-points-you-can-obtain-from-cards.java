class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int a = 1; // counter
        int sum = 0; // store the current sum
        int ans = 0; // store the maximum sum

        //left side
        for(int i=k-1;i>=0;i--){
            sum += cardPoints[i];
        }

        ans = Math.max(ans, sum);

        //sliding window concept
        while(a<=k){
            sum += cardPoints[cardPoints.length-a];
            sum -= cardPoints[k-a];

            a++;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
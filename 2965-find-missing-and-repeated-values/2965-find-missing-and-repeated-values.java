class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n*n;

        long sumN = (N*(N+1))/2;
        long sumNSq = (N*(N+1)*(2*N+1))/6;

        long sum1 = 0;
        long sum2 = 0;

        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sum1 += (long)grid[i][j];
                sum2 +=  (long)grid[i][j] * (long)grid[i][j];
            }
        }

        long val1 = sum1 - sumN;
        long val2 = sum2 - sumNSq;

        val2 = val2/val1;

        long repeated = (val1 + val2)/2;
        long missing = repeated - val1;

        return new int[]{(int)repeated, (int)missing};

    }
}
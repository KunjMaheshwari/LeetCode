class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1;
        int i =1;

        while(i < n){
            if(ratings[i] == ratings[i-1]){
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                peak ++;
                sum+= peak;
                i++;
            }

            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]){
                sum += down;
                i++;
                down++;
            }

            if(down > peak){
                sum += (down- peak);
            }
        }
        return sum;
    }
}
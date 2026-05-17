class Solution {
    public boolean canReach(int[] arr, int start) {
        //base condition
        if(start < 0 || start >= arr.length || arr[start] < 0){
            return false;
        }

        if(arr[start] == 0){
            return true;
        }

        arr[start] *= -1;

        boolean firstOption = canReach(arr, start + arr[start]);
        boolean secondOption = canReach(arr, start - arr[start]);

        return firstOption || secondOption;
    }
}
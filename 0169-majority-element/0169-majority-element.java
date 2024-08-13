// class Solution {
//   public int majorityElement(int[] nums) {
//     int candidate = nums[0];
//     int count = 1;
//     for (int i = 1; i < nums.length; i++) {
//       if (nums[i] == candidate) {
//         count++;
//       } else {
//         count--;
//         if (count == 0) {
//           candidate = nums[i];
//           count = 1;
//         }
//       }
//     }
//     return candidate;
//   }
// }

class Solution{
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public static int countInRange(int nums[], int num, int lo, int hi){
        int count = 0;
        for(int i=lo;i<=hi;i++){
            if(nums[i] ==  num){
                count++;
            }
        }
        return count;
    }

    public static int majorityElementRec(int nums[], int lo, int hi){
        // base case -> only element in the array of size 1 is the majority element.
        if(lo ==  hi){
            return nums[lo];
        }

        // recurse on the left and right halves of the slice
        int mid = lo + (hi-lo)/2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);


        // if two halves agree on the majority element, return it
        if(left ==  right){
            return left;
        }

        // otherwise count the elements and written the winner
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left:right;
    }
}
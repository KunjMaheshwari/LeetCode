// Approach 1 -> Linear search -> TC = O(n^2);

// class Solution {
//     public int search(int[] nums, int target) {
//         for(int i=0;i<nums.length;i++){
//             if(nums[i] == target){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// Approach 2 -> Divide and Conquer -> TC = O(nlog(n));
class Solution{
    public int search(int[] arr, int target) {
        int si = 0;
        int ei = arr.length-1;
        return binarySearch(arr, si, ei, target);
    }
    public static int binarySearch(int arr[], int si, int ei, int target){
        int mid = si+(ei-si)/2;
        int left = -1;
        int right = -1;

        if(si<=ei){
            if(arr[mid] == target){
                return mid;
            }
            else{
                left = binarySearch(arr, si, mid-1, target);
                right = binarySearch(arr, mid+1,ei, target);
            }
        }
        return Math.max(left, right);
    }
}
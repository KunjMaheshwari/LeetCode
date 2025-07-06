class Solution {
    public static void mergeSortHelper(int nums[], int low, int high){
        // base case 
        if(low >= high){
            return;
        }

        int mid = (low+high)/2;
        mergeSortHelper(nums, low, mid);
        mergeSortHelper(nums, mid+1, high);
        mergeSortMain(nums, low, mid, high);
    }

    public static void mergeSortMain(int nums[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        //remaining elements
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }

        while(right <= high){
            temp.add(nums[right]);
            right++;
        }

        //put it inside the final array
        for(int k=low;k<=high;k++){
            nums[k] = temp.get(k-low);
        }
    }
    public int[] sortArray(int[] nums) {
        int n= nums.length;
        mergeSortHelper(nums, 0, n-1);
        return nums;
    }
}
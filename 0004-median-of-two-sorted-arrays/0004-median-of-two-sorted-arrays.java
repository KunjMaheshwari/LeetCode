import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Merge nums1 and nums2 into a single sorted array
        int[] mergedFinalArray = mergeArrays(nums1, m, nums2, n);
        
        // Find the median of the merged array
        if (mergedFinalArray.length % 2 == 0) {
            int mid1 = mergedFinalArray.length / 2;
            int mid2 = mid1 - 1;
            return (mergedFinalArray[mid1] + mergedFinalArray[mid2]) / 2.0;
        } else {
            int mid = mergedFinalArray.length / 2;
            return mergedFinalArray[mid];
        }
    }
    
    // Merge nums1 and nums2 into a single sorted array
    public static int[] mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        int i = 0, j = 0, k = 0;
        
        // Merge the two arrays while maintaining the sorted order
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        
        // Copy the remaining elements of nums1, if any
        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }
        
        // Copy the remaining elements of nums2, if any
        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }
        
        return mergedArray;
    }
}
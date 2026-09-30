class Solution {
    public int[] replaceElements(int[] arr) {
        int result[] = new int[arr.length];

        if (arr.length == 0) {
            return result;
        }

        int maxElement = arr[arr.length - 1];
        result[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            result[i] = maxElement;

            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        return result;
    }
}
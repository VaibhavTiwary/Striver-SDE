// Definition:

// An inversion in an array arr is a pair (i, j) such that:

// i < j

// arr[i] > arr[j]

// Basically, it tells how "unsorted" an array is.

// Array: [2, 4, 1, 3, 5]
// O/P- 3


class Solution {
    public long countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }
    
    private long mergeSort(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }
    
    private long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long invCount = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions
            }
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        
        for (i = left; i <= right; i++) arr[i] = temp[i];
        
        return invCount;
    }
}

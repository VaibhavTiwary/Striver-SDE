// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. 
// You also have an integer k representing the number of students. The task is to allocate books to each student
//  such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, 
// out of all possible allocations, find the arrangement where the student who receives the most pages still
//  has the smallest possible maximum.

// Note: If it is not possible to allocate books to all students, return -1.



class Solution {
    public int findPages(int[] arr, int k) {
        // Number of books
        int n = arr.length;

        // If students are more than books, allocation is not possible
        if (k > n) return -1;
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        // Find the maximum pages in a single book and total pages of all books
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        
        // 'low' -> minimum possible answer (max pages in a single book)
        // 'high' -> maximum possible answer (sum of all pages)
        int low = max;
        int high = sum;
        int ans = -1;
        
        // Binary search to find the minimum possible maximum pages
        while (high >= low) {
            int mid = low + (high - low) / 2;  // potential maximum pages per student
            
            int pages = 0;     // pages allocated to current student
            int students = 1;  // number of students required
            
            // Traverse through each book
            for (int i = 0; i < arr.length; i++) {
                
                // If adding current book exceeds mid limit,
                // assign the book to the next student
                if (pages + arr[i] > mid) {
                    students++;         // move to next student
                    pages = arr[i];     // assign current book to new student
                } 
                else {
                    pages += arr[i];    // continue assigning books to current student
                }
            }
            
            // If the current distribution is possible with given or fewer students,
            // store this as a potential answer and try for a smaller maximum
            if (students <= k) {
                ans = mid;
                high = mid - 1;   // try to minimize maximum pages
            } 
            else {
                low = mid + 1;    // need to allow more pages per student
            }
        }
        
        // Return the minimum number of maximum pages that can be allocated
        return ans;
    }
}

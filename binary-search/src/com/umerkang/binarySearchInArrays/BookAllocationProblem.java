package com.umerkang.binarySearchInArrays;

public class BookAllocationProblem {
    public static void main(String[] args) {
        int[] books = {20, 10, 30, 40};
        int students = 2;
        int minimumNumOfPages = allocateMinimumNumberOfPages(books, students);
        System.out.println(minimumNumOfPages);
    }

    private static int allocateMinimumNumberOfPages(int[] books, int students) {
        int start = 0;
        int end = 0;
        for (int book : books) {
            // Minimum pages that a student can read is the maximum of the books array
            // because if 4 books (from book array) can be divided in 4 students, the
            // maximum of that should be the maximum element in array, hence we can
            // take as the start value of binary search (we can also take the start
            // value from zero, but as we know the pages that are maximum in the array
            // should always be read by someone, so we can further reduce our search
            // range by just taking the maximum value in the books array)
            start = Math.max(start, book);
            // If the all the elements of books are given to only 1 student, then the
            // highest possible value in the range should become the sum of all the
            // books in array, range cannot exceed the highest value (that is the sum
            // of the all book pages in the books array), so we take it as the highest
            // value of binary search
            end += book;
        }
        // We are using "<" instead of "<=" because if we use the latter one at the end
        // of the while loop start and will NOT point to the same element end will
        // point to the previous element. Now we have used "<" because we are using
        // "end = mid" in the else condition of binary search, at some point end will
        // point to the start. If we were not using "<", the loop will not break here
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            // Minimum number of students should always be 1
            int studentsInLoop = 1;
            for (int book : books) {
                if (sum + book <= mid) {
                    // Here mid is total number of pages to comparison
                    // If previous sum of the same student "sum" + book of that loop is
                    // less than or equal to the total number of pages to comparison
                    // then no need to increase the student, we can add books (pages)
                    // to the same student, hence totalSum = previousSum + book, also
                    // written as previousSum += book
                    sum += book;
                } else {
                    // If the previous sum + book of that loop increases the total
                    // number of pages to comparison (mid). We cannot exceed the total
                    // number of comparison (mid), if it is increases, we need to reset
                    // the sum and increase the number of students
                    sum = book;
                    studentsInLoop++;
                }
            }
            if (studentsInLoop > students) {
                // If students in loop are increased by the total students to allocate
                // we need to increase total pages to comparison, if we didn't do it 
                // we have to increase the studentsInLoop more than students that we
                // didn't want to do
                start = mid + 1;
            } else {
                // If the students in loop are less or equal than the total students to
                // allocate, we can further decrease the total pages of comparison due
                // to greed, and because of this end will move less and less, hence it
                // will point to the start
                end = mid;
            }
        }
        // Start and end are both pointing to the same element
        return start;
    }
}

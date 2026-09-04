/*Mr. Jack is a librarian who has n books arranged in order. The number of pages 
in each book is given in an array. He has to assign these books to m students, 
in such a way that:
	*Each student gets a contiguous block of books.
	*Every book must be assigned to exactly one student.
	*The goal is to minimize the maximum number of pages assigned to any student.

Input Format
First line: Two integers n (number of books), m (number of students).
Second line: n space-separated integers, where each integer denotes pages in a book.

Output Format
An integer representing the minimized maximum number of pages.

Sample Testcases
case=1
input=4 2
12 34 67 90
output=113

case=2
input=5 3
15 17 20 25 30
output=45

case=3
input:
9 4
10 20 30 40 50 60 70 80 90
output=150
*/

import java.util.*;

class BookAllocation {
    // Function to check if allocation is possible under given maxPages
    private static boolean isPossible(int[] pages, int n, int m, int maxPages) {
        // W Y C H
    }

    // Binary Search function to minimize the maximum pages
    public static int allocateBooks(int[] pages, int n, int m) {
        //W Y C H
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // number of books
        int m = sc.nextInt();  // ber of students
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        int answer = allocateBooks(pages, n, m);
        System.out.println(answer);
    }
}

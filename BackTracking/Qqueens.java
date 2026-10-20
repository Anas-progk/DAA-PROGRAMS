/*
Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution".

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100

Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution

/* Java program to solve N Queen Problem using backtracking */
import java.util.*;
public class NQueenProblem 
{
	//SOLVE BY PLACING QUEENS ROW WISE
	

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		NQueenProblem Queen = new NQueenProblem();
		Queen.N=sc.nextInt();
		Queen.solveNQ();
	}
}

public class Qqueens {
    
}

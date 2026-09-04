/*A futuristic city is powered by digital energy nodes, 
each assigned a unique Node ID number. To maintain balance in the energy grid, 
the central controller periodically checks the "energy weight" of each node.

The energy weight of a node is defined as the sum of the digits of its Node ID.
For instance, if a node's ID is 435, its energy weight is 4 + 3 + 5 = 12.

The city uses this weight to decide which stabilizer the node gets assigned to:
Nodes with an even energy weight are assigned to the blue stabilizer.
Nodes with an odd energy weight are assigned to the red stabilizer.
You are tasked with writing the control logic that:
Reads the node’s ID
Calculates the sum of its digits
Outputs the energy weight and the color of the assigned stabilizer.

sample test cases:
case=1
input=52
output=Energy Weight: 7, Stabilizer: RED

case=2
input=428
output=Energy Weight: 14, Stabilizer: BLUE

import java.util.*;
public class SumOfDigits 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Ente N");
		int num = sc.nextInt();
		//WRITE YOUR CODE HERE
	}
	public static int sod(int N)
	{
		//WRITE YOUR CODE HERE
	}
}
*/

import java.util.*;

public class SumOfDigits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int sum = sod(num);

        if (sum % 2 == 0)
            System.out.println("Energy Weight: " + sum + ", Stabilizer: BLUE");
        else
            System.out.println("Energy Weight: " + sum + ", Stabilizer: RED");
    }

    public static int sod(int N)
    {
        if (N == 0)
            return 0;

        return (N % 10) + sod(N / 10);
    }
}


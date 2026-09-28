/*You are given the details of employees working in a company.
The company follows a hierarchical structure with grades from G1 to GN.
The hierarchy is represented as a complete Binary Tree:
    G1
   /  \
 G2    G2
 / \   / \
G3 G3 G3 G3
...

The following rules apply:
1. There is exactly one employee in G1.
2. There are at most two G(i+1) grade employees under every Gi grade employee.
3. For N grades, there are exactly 2^N - 1 employees.
4. The employee records are given in level-order.
5. Grade is NOT given as input. It must be determined from the position of 
   the employee in the level-order input.
6. Each employee record contains:
   - Employee Name
   - Performance Rating out of 10
7. The best employee in a grade is the employee who has the highest performance 
   rating in that grade.
8. If two or more employees have the same highest rating, the employee appearing 
   first in the input should be considered the best employee.

Your task is to:
1. Construct the employee hierarchy from the given level-order records.
2. Determine the grade of each employee based on the level at which the employee occurs.
3. For every grade, find the employee with the highest performance rating.
4. Display the name of the best employee in each grade along with the rating.

INPUT FORMAT
The first line contains an integer N, representing the number of grades.
The next 2^N - 1 lines contain employee records.
Each employee record contains:
EmployeeName PerformanceRating
where PerformanceRating is a value between 0 and 10.
The records are given in level-order.

OUTPUT FORMAT
For each grade, print:
Grade Gi: <Best Employee Name> | Rating = <Highest Rating>

CONSTRAINTS
1 <= N <= 10

Number of employees = 2^N - 1
Employee name contains a single word.
0 <= PerformanceRating <= 10
If two employees in the same grade have the same highest rating, 
choose the employee appearing first in the input.

EXAMPLE 1
Input
4
Ravi 8.5
Sita 9.2
Kiran 8.8
Anil 7.5
Priya 9.5
Rahul 8.9
Meena 9.1
Arjun 8.0
Lakshmi 9.7
Vijay 8.6
Neha 9.3
Suresh 7.8
Divya 9.0
Manoj 8.4
Pooja 9.6

Output
Grade G1: Ravi | Rating = 8.5
Grade G2: Sita | Rating = 9.2
Grade G3: Priya | Rating = 9.5
Grade G4: Lakshmi | Rating = 9.7


EXAMPLE 2
Input
3
Arun 8.0
Bhavya 9.1
Charan 8.7
Deepak 9.5
Esha 8.9
Farhan 9.8
Gita 8.3

Output
Grade G1: Arun | Rating = 8.0
Grade G2: Bhavya | Rating = 9.1
Grade G3: Farhan | Rating = 9.8


EXPECTED APPROACH
Use:
1. An Employee Node class containing:
   - Employee name
   - Performance rating
   - Left child
   - Right child
2. Construct the employee hierarchy using a Queue.
3. Perform BFS traversal.
4. Process one complete level at a time using queue.size().
5. For every level:
   - Determine the employee with the highest rating.
   - Display the employee name and rating.
   - Move to the next grade.

TIME COMPLEXITY
O(N) with respect to the number of employees, because every employee is visited once.

SPACE COMPLEXITY
O(N) for storing the employee hierarchy and BFS queue.*/
import java.util.*;
public class EmployeeHierarchy
{
    static class Employee
    {
        String name;
        Double rating;
        Employee left,right;
        Employee(String name,double rating){
            this.name=name;
            this.rating=rating;
        }
    }
    static Employee constructTree(Employee[] employees)
    {
        if(employees.length==0) return null;
        Employee root=employees[0];
        Queue<Employee> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<employees.length)
        {
            Employee current=q.poll();
            if(i<employees.length){
                current.left=employees[i];
                q.offer(current.left);
            }
            i++;
            if(i<employees.length){
                current.right=employees[i];
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }
    static void bfsAndPrint(Employee root)
    {
        if(root==null) return;
        Queue<Employee> q=new LinkedList<>();
        q.offer(root);
        int grade=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            String bestName=null;
            double bestRating=-1;
            for(int i=0;i<size;i++)
            {
                Employee current=q.poll();
                if(current.rating>bestRating){
                    bestRating=current.rating;
                    bestName=current.name;
                }
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
            System.out.println("Grade G"+grade+": "+bestName+" | Rating = "+bestRating);
            grade++;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = (int) Math.pow(2, n) - 1;
        Employee[] employees = new Employee[total];
        for (int i = 0; i < total; i++) {
            employees[i] = new Employee(sc.next(), sc.nextDouble());
        }
        Employee root=constructTree(employees);
        bfsAndPrint(root);
    }
}
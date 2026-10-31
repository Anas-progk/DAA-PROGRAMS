/*Ram is playing a game where there are N levels. 
Inorder to win the game he has to reach Nth level.

The rule book explains "In one step you can either cross one level or two levels".

Return the number of distinct possible ways to win the game.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4
*/
#include<bits/stdc++.h>
using namespace std;
int climb(int n)
{
    vector<int>dp(n+1,0);
    dp[0]=0;dp[1]=1;dp[2]=2;
    for(int i=3;i<=n;i++)
    {
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
}
int main()
{
    int n;
    cin>>n;
    cout<<climb(n);
}
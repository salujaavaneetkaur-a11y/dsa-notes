0/1 Knapsack (Recursion)

CODE

class Solution{
    public int knapsack(int W, int val[], int wt[])
    {
        return solve(val.length, W, val,wt);
    }

    public int solve(int n, int W, int val[], int wt[]){

        //Base Case
        if(n==0|| W==0){
            return 0;
        }

        //if current item cannot be taken
        if(wt[n-1] > W){
            return solve(n-1, W, val, wt);
        }
        //Choice : take or skip
        int take = val[n-1] + solve(n-1, W-wt[n-1], val, wt);
        int skip = solve(n-1, W, val, wt);

        return Math.max(take, skip);
    }
}

Main Points (Write this below code)
1. Function Meaning
solve(n, W) = max value using first n items with capacity W
2. Base Case
if n == 0 or W == 0 → return 0
no items OR no capacity → no value
3. Choice Logic
If item cannot be taken:
wt[n-1] > W → skip
→ solve(n-1, W)
If item can be taken:
take = val[n-1] + solve(n-1, W - wt[n-1])
skip = solve(n-1, W)

answer = max(take, skip)
4. Key Idea
For every item → 2 choices:
1. Take it
2. Skip it
5. Time Complexity
O(2^n)
because each item branches into 2 choices
6. Important Rule
Index used = n-1 (last item)
because n represents "number of items considered"
7. One-line Memory Trick
"If weight fits → take or skip
Else → skip only"
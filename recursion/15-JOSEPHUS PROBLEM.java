JOSEPHUS PROBLEM 

PROBLEM: n people in a circle, every k-th person eliminated.
         Find the survivor (1-indexed).
  n=5, k=2 → 3
  n=5, k=3 → 4

  CODE : 

  class Solution{
    public int findTheWinner(int n, int k){
        return josephus(n,k) +1;
    }

    int josephus(int n, int k){
        if(n == 1) return 0;
        return (joephus(n-1,k)+k)%n ;
    }
  }

  THREE THINGS TO MEMORIZE:
  Base case  : n == 1 → return 0   (0-indexed)
  Recurrence : (josephus(n-1, k) + k) % n
  Final step : +1 to convert to 1-indexed

DRY RUN: n=5, k=2
  josephus(1) = 0
  josephus(2) = (0+2)%2 = 0
  josephus(3) = (0+2)%3 = 2
  josephus(4) = (2+2)%4 = 0
  josephus(5) = (0+2)%5 = 2
  Answer = 2+1 = 3 ✅

TIME: O(n)   SPACE: O(n) stack

MEMORIZE: "Base: n=1 → 0. Recurse: (solve(n-1)+k)%n. Return +1."
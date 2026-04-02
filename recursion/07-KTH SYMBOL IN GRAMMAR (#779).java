PROBLEM: Find Kth symbol in Nth row.
  Rule: 0→01, 1→10
  Row 0: 0
  Row 1: 01
  Row 2: 0110
  Row 3: 01101001

KEY INSIGHT:
  First half of row N  = COPY of row N-1
  Second half of row N = FLIPPED copy of row N-1

CODE:

  int kthGrammar(int n, int k) {
      if (n == 0) return 0;
      
      int mid = (int) Math.pow(2, n - 1);
      
      if (k <= mid)
          return kthGrammar(n - 1, k);
      else
          return 1 - kthGrammar(n - 1, k - mid);
  }

LOGIC:
  K in first half  → same as parent: kthGrammar(n-1, k)
  K in second half → FLIP of parent: 1 - kthGrammar(n-1, k-mid)
  Flip: 1-0=1, 1-1=0

WHY k - mid?
  Second half position 5 = first half position 5-4 = 1
  Map back to previous row's position.

DRY RUN: N=3, K=5
  mid=4. K=5 > 4 → second half
  → flip of kthGrammar(2, 1)
    → kthGrammar(1, 1)
      → kthGrammar(0, 1) = 0
    → 0 (first half, same)
  → 1-0 = 1 ✅

MEMORIZE: "First half = same as parent row.
  Second half = FLIP of parent row.
  K > mid? Go to row N-1, position K-mid, flip."

TIME: O(N)  SPACE: O(N) call stack

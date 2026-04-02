PROBLEM: Move N disks from Source to Dest using Helper.
  Rules: one disk at a time. Big can't go on small.

3-STEP TRICK (this is the ENTIRE solution):
  Step 1: Move N-1 disks from SOURCE → HELPER
  Step 2: Move Nth disk from SOURCE → DEST (print/count it)
  Step 3: Move N-1 disks from HELPER → DEST

PRINT VERSION:

  void toh(int n, String src, String hlp, String dst) {
      if (n == 1) {
          print("Move 1 from " + src + " to " + dst);
          return;
      }
      
      toh(n-1, src, dst, hlp);  // N-1 to helper
      print("Move " + n + " from " + src + " to " + dst);
      toh(n-1, hlp, src, dst);  // N-1 to dest
  }

COUNT VERSION (GFG):

  int toh(int n, int from, int to, int aux) {
      if (n == 0) return 0;
      return toh(n-1, from, aux, to)
             + 1
             + toh(n-1, aux, to, from);
  }

WHY PARAMETERS SWAP:
  Step 1: toh(n-1, src, dst, hlp) → dest becomes helper
  Step 3: toh(n-1, hlp, src, dst) → helper becomes source

FORMULA: moves(n) = moves(n-1) + 1 + moves(n-1)

DRY RUN (build from smallest):
  n=0 →                     0
  n=1 → moves(0)+1+moves(0) = 0+1+0 = 1
  n=2 → moves(1)+1+moves(1) = 1+1+1 = 3
  n=3 → moves(2)+1+moves(2) = 3+1+3 = 7
  n=4 → moves(3)+1+moves(3) = 7+1+7 = 15
  Each: previous × 2 + 1. Shortcut: 2^n - 1

MEMORIZE: "Move N-1 out of the way.
  Move biggest. Move N-1 back."

TIME: O(2^N)  SPACE: O(N) call stack


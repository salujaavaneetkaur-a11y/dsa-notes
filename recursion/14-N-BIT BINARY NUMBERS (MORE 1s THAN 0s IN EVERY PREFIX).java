N-BIT BINARY NUMBERS (MORE 1s THAN 0s IN EVERY PREFIX)

PROBLEM : Generate all N-bit binary strings where at every prefix, 
count of 1s >= count of 0s. Return in DECREASING order. 

n=2 → {"11", "10"}
  n=3 → {"111", "110", "101"}

KEY IDEA : At each step, two conditional choices : 
Add '1' -> always allowed (never breaks prefix rule)
Add '0' -> only if ones > zeroes (1s must strictly lead)

CODE : 

ArrayList<String> NBitBinary(int N){
    ArrayList<String> result = new ArrayList<>();
    solve("",0,0,N,result);
    return result;
}

void solve(String current, int ones, int zeroes, int n, ArrayList<String> result){
    if(str.length()==n){
        result.add(current);
        return; 
    }
    solve(current + "1", ones+1, zeroes,n,result); //always add 1

    if(ones>zeroes)
    solve(current + "0", ones, zeroes+1, n, result); //guard for 0
}

TWO CONDITIONS (memorize these!):
  Always        → can add 1    "1 never breaks the prefix rule"
  ones > zeros  → can add 0    "0 only safe when 1s are leading"

DRY RUN: n=2
  "" → "1" → "11" ✅  (added to result)
           → "10" ✅  (ones=1 > zeros=0 → allowed)
  Result: ["11", "10"]   ← naturally decreasing (1 branch first)

DRY RUN: n=3
  "" → "1" → "11" → "111" ✅
                  → "110" ✅
           → "10" → "101" ✅
                  → "100" ✗  (ones=1 == zeros=1, blocked)
  Result: ["111", "110", "101"]

WHY DECREASING ORDER COMES FREE : 
We always recurse with '1' first, then '0',
So larger numbers (more 1s early) gets added first. 
No sorting needed!

VS BALANCED PARENTHESES (#22):
  Parens : open < n    → add (  |  close < open → add )
  N-bit  : always      → add 1  |  ones > zeros → add 0
  IDENTICAL skeleton. Same Catalan number count.

NO BACKTRACK: String is immutable, no undo needed.
RESULT COUNT: Catalan number C(n)
  n=1→1, n=2→2, n=3→5, n=4→14

TIME: O(2^n)   SPACE: O(n) call stack + O(2^n) result list

CONSTRAINTS: 1 <= n <= 15  (max ~16K strings, well within limits)

MEMORIZE: "1 is always safe. 0 needs a guard: ones > zeros.
           Recurse 1 first → decreasing order comes free.
           Same skeleton as balanced parentheses."
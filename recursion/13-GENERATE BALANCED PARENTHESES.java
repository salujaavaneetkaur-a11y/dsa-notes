GENERATE BALANCED PARENTHESES (#22)

PROBLEM: Generate all valid combinations of n pairs.
  n=2 → "(())", "()()"
  n=3 → "((()))","(()())","(())()","()(())","()()()"

  KEY IDEA : At each step, two conditional choices:
  Add '(' -> only if open < n (have (left to use))
  Add ')' -> only if close < open (have unmatched (to close))

  CODE :

  List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    solve(n, 0, 0, "", result);
    return result;
}

void solve(int n, int open, int close, String current, List<String> result) {
    if (current.length() == 2 * n) {
        result.add(current);
        return;
    }
    if (open < n)
        solve(n, open + 1, close, current + "(", result);

    if (close < open)
        solve(n, open, close + 1, current + ")", result);
}

  TWO CONDITIONS (memorize these!):
  open < n      → can add (    "still have ( to use"
  close < open  → can add )    "have unmatched ( to close"

DRY RUN: n=2
  "" → "(" → "((" → "(()" → "(())" ✅
                  → "()" → "()()" ✅
  Result: ["(())", "()()"]

VS POWER SET / SPACES / CASE CHANGE:
  Those: ALWAYS two choices (both always valid)
  This:  CONDITIONAL choices (not always both valid)
  That's what makes this MEDIUM.

NO BACKTRACK: String is immutable.
RESULTS COUNT: Catalan number = (2n)! / ((n+1)! × n!)
  n=1→1, n=2→2, n=3→5, n=4→14

RELATED LEETCODE: #22, #17, #39, #46, #77, #78, #90

TIME: O(4^n / √n)  SPACE: O(n) call stack
MEMORIZE: "open < n → add (. close < open → add ).
          Two conditions. That's the whole trick."
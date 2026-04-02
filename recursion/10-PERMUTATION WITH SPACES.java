PROBLEM: Place space (or not) between each char pair.
  "ABC" → "A B C", "A BC", "AB C", "ABC"
  Total = 2^(n-1) (n-1 gaps, each: space or not)

KEY IDEA: Same as Power Set but on GAPS, not characters.
  First char always taken. For each remaining char:
    Choice 1: add space before it
    Choice 2: don't add space

CODE:

  ArrayList<String> permutation(String s) {
      ArrayList<String> result = new ArrayList<>();
      solve(s, 1, String.valueOf(s.charAt(0)), result);
      Collections.sort(result);
      return result;
  }

  void solve(String s, int index, String current,
             ArrayList<String> result) {
      if (index == s.length()) {
          result.add(current);
          return;
      }
      
      // WITH space
      solve(s, index+1, current+" "+s.charAt(index), result);
      
      // WITHOUT space
      solve(s, index+1, current+s.charAt(index), result);
  }

WHY START AT index=1?
  First char 'A' always included — no choice for it.
  Decisions start from second char onwards.

WHY Collections.sort()?
  Problem says "sorted increasing order."
  Recursion order might not be sorted.
  sort() at end guarantees correct order.

NO BACKTRACK: String is immutable.
  "A" + " B" creates NEW string "A B".
  Original "A" unchanged. No undo needed.

DRY RUN: "ABC"
  start: "A"
    space → "A B" → space → "A B C" ✅
                   → no    → "A BC"  ✅
    no    → "AB"  → space → "AB C"  ✅
                   → no    → "ABC"   ✅

SAME TEMPLATE AS:
  Power Set:  include char / exclude char
  Spaces:     add space / no space
  Case Change: uppercase / lowercase

MEMORIZE: "First char fixed. For each remaining:
  space or no space. Two choices = 2^(n-1)."

TIME: O(2^(n-1))  SPACE: O(n) call stack

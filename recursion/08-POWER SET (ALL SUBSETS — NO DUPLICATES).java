PROBLEM: Generate ALL subsets of a string/array.
  "abc" → "", "a", "b", "c", "ab", "ac", "bc", "abc"
  Total subsets = 2^n (each element: include or exclude)

KEY IDEA: For each element, 2 choices:
  INCLUDE it → add to current → move to next
  EXCLUDE it → don't add → move to next
  At the end → current is one subset.

STRING VERSION:

  void solve(String s, int index, String current,
             List<String> result) {
      if (index == s.length()) {
          result.add(current);
          return;
      }
      
      // INCLUDE current char
      solve(s, index+1, current + s.charAt(index), result);
      
      // EXCLUDE current char
      solve(s, index+1, current, result);
  }

  // Call: solve(s, 0, "", result)

ARRAY VERSION:

  void solve(int[] arr, int index, List<Integer> current,
             List<List<Integer>> result) {
      if (index == arr.length) {
          result.add(new ArrayList<>(current)); // COPY!
          return;
      }
      
      current.add(arr[index]);                  // INCLUDE
      solve(arr, index+1, current, result);
      current.remove(current.size()-1);          // BACKTRACK
      
      solve(arr, index+1, current, result);     // EXCLUDE
  }

STRING: no backtrack (immutable, creates new copy)
ARRAY:  must backtrack (ArrayList is mutable, shared)

DRY RUN: "ab"
  solve(0, "")
    include 'a' → solve(1, "a")
      include 'b' → solve(2, "ab") → add "ab"
      exclude 'b' → solve(2, "a")  → add "a"
    exclude 'a' → solve(1, "")
      include 'b' → solve(2, "b")  → add "b"
      exclude 'b' → solve(2, "")   → add ""
  Result: ["ab", "a", "b", ""] ✅

DECISION TREE:
        ""
       /  \
     "a"   ""
     / \   / \
  "ab" "a" "b" ""
  LEFT = include, RIGHT = exclude

THIS PATTERN IS USED IN: Power Set, Subset Sum,
  Knapsack, Permutations, Combinations, Subsequences.

MEMORIZE: "Each element: include or exclude.
  Two choices per element = 2^n subsets.
  Two recursive calls = decision tree."

TIME: O(2^n)  SPACE: O(n) call stack

PROBLEM: All unique subsets. Input MAY have duplicates.
  [2,1,2] → [], [1], [1,2], [1,2,2], [2], [2,2]

KEY TRICK: Sort array + skip adjacent duplicates.

APPROACH: For-loop + Skip dups + Backtrack
  (Different from Power Set's include/exclude!)

CODE:

  ArrayList<ArrayList<Integer>> AllSubsets(int[] arr, int n) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      Arrays.sort(arr);                       // SORT FIRST!
      findSubsets(arr, 0, new ArrayList<>(), result);
      return result;
  }

  void findSubsets(int[] arr, int index,
                   ArrayList<Integer> current,
                   ArrayList<ArrayList<Integer>> result) {
      result.add(new ArrayList<>(current));   // add COPY
      
      for (int i = index; i < arr.length; i++) {
          // SKIP duplicate at same level
          if (i > index && arr[i] == arr[i-1]) continue;
          
          current.add(arr[i]);                 // PICK
          findSubsets(arr, i+1, current, result); // RECURSE
          current.remove(current.size()-1);     // BACKTRACK
      }
  }

3 KEY THINGS:

  1. SORT FIRST → brings duplicates adjacent

  2. SKIP: if (i > index && arr[i] == arr[i-1])
     i > index = not first at this level
     arr[i] == arr[i-1] = same as previous
     Allows [2,2] (different levels) ✅
     Prevents two [2] subsets (same level) ✅

  3. BACKTRACK: add → recurse → remove
     ArrayList is shared. Must undo for next iteration.

DRY RUN: [1, 2, 2] (after sort)
  [] → [1] → [1,2] → [1,2,2]
                    → skip second 2 (same level)
     → [2] → [2,2]
     → skip second 2 (same level)
  Result: [[], [1], [1,2], [1,2,2], [2], [2,2]] ✅

POWER SET vs UNIQUE SUBSETS:
  Power Set: include/exclude, add at BASE case
  Unique:    for-loop + skip, add at EVERY call

MEMORIZE: "Sort. For-loop. Skip if same as previous
  at same level. Pick → recurse → backtrack."

TIME: O(2^N)  SPACE: O(N) call stack

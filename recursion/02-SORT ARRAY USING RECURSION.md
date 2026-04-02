PROBLEM: Sort ArrayList using recursion only.
  [5, 3, 1, 4, 2] → [1, 2, 3, 4, 5]

KEY IDEA: Remove last → sort rest → insert at correct position.

TWO FUNCTIONS:

FUNCTION 1 — sort:

  void sort(List<Integer> arr) {
      if (arr.size() <= 1) return;
      
      int last = arr.remove(arr.size() - 1);
      sort(arr);
      insert(arr, last);
  }

FUNCTION 2 — insert:

  void insert(List<Integer> arr, int element) {
      if (arr.isEmpty() || arr.get(arr.size()-1) <= element) {
          arr.add(element);
          return;
      }
      
      int last = arr.remove(arr.size() - 1);
      insert(arr, element);
      arr.add(last);
  }

DRY RUN: [5, 3, 1]
  remove 1 → remove 3 → [5] base case
  insert 3: 3<5 remove 5, empty add 3, add 5 → [3,5]
  insert 1: 1<5 remove 5, 1<3 remove 3,
            empty add 1, add 3, add 5 → [1,3,5] ✅

IBH:
  B = size ≤ 1 → return
  H = sort(smaller array) works
  I = remove last → sort rest → insert at correct position

MEMORIZE: "Remove last. Sort rest. Insert at correct spot."

TIME: O(n²)  SPACE: O(n) call stack

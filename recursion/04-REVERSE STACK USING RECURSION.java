PROBLEM: Reverse stack without extra data structure.
  [1,2,3,4,5] (5 on top) → [5,4,3,2,1] (1 on top)

KEY IDEA: Pop top → reverse rest → insert at BOTTOM.
  Original top → new bottom = REVERSED!

TWO FUNCTIONS:

FUNCTION 1 — reverse:

  void reverse(Stack<Integer> stack) {
      if (stack.size() <= 1) return;
      
      int top = stack.pop();
      reverse(stack);
      insertAtBottom(stack, top);
  }

FUNCTION 2 — insertAtBottom:

  void insertAtBottom(Stack<Integer> stack, int element) {
      if (stack.isEmpty()) {
          stack.push(element);
          return;
      }
      
      int top = stack.pop();
      insertAtBottom(stack, element);
      stack.push(top);
  }

DRY RUN: [1,2,3] (3 on top)
  pop 3 → pop 2 → [1] base case
  insertBottom([1], 2): pop 1, empty push 2, push 1 → [2,1]
  insertBottom([2,1], 3): pop 1, pop 2, empty push 3,
                          push 2, push 1 → [3,2,1] ✅

insertAtBottom TRICK:
  Empty the stack completely.
  Push YOUR element (it's alone = it's the bottom!).
  Put everything else back on top.

SORT vs REVERSE — Only helper differs:
  Sort:    insertSorted  → peek() <= element? push
           (finds CORRECT POSITION by comparing)
  Reverse: insertAtBottom → isEmpty()? push
           (always goes to BOTTOM)

MEMORIZE: "Pop top. Reverse rest. Insert top at bottom."

TIME: O(n²)  SPACE: O(n) call stack

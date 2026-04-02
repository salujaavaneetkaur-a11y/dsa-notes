PROBLEM: Delete middle element using only push/pop.
  [1,2,3,4,5] (5 on top) → [1,2,4,5] (3 deleted)

KEY IDEA: Pop until middle (k=0) → discard → push rest back.

ONLY 1 FUNCTION NEEDED (simplest of all 4 problems):

  void deleteMiddle(Stack<Integer> stack, int k) {
      if (k == 0) {
          stack.pop();    // DELETE! Don't push back.
          return;
      }
      
      int top = stack.pop();
      deleteMiddle(stack, k - 1);
      stack.push(top);
  }

  // Call: deleteMiddle(stack, stack.size() / 2)

DRY RUN: [1,2,3,4,5] (5 on top), k = 5/2 = 2
  k=2: pop 5 (hold)
  k=1: pop 4 (hold)
  k=0: pop 3 → DELETE! Don't push back.
  push 4 back
  push 5 back
  Result: [1,2,4,5] ✅

HOW k WORKS:
  k counts DOWN from middle index.
  k=0 → current top IS the middle → pop and discard.
  Every other element: pop → recurse → push BACK.
  Middle element: pop → DON'T push back (deleted!).

WHY NO HELPER?
  Sort:    needs helper to find CORRECT position (compare)
  Reverse: needs helper to find BOTTOM (empty stack)
  Delete:  just COUNT down k → simple!

MEMORIZE: "Pop until k=0. Discard middle.
  Push everything else back."

TIME: O(n)  SPACE: O(n) call stack


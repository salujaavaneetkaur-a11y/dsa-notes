PROBLEM: Sort stack without extra data structure.
  [5,3,1,4,2] (2 on top) → [1,2,3,4,5] (5 on top)

KEY IDEA: Pop top → sort rest → insert at correct position.
  SAME as sort array. Just different method names.

TWO FUNCTIONS:

FUNCTION 1 — sortStack:

  void sortStack(Stack<Integer> stack) {
      if (stack.size() <= 1) return;
      
      int top = stack.pop();
      sortStack(stack);
      insertSorted(stack, top);
  }

FUNCTION 2 — insertSorted:

  void insertSorted(Stack<Integer> stack, int element) {
      if (stack.isEmpty() || stack.peek() <= element) {
          stack.push(element);
          return;
      }
      
      int top = stack.pop();
      insertSorted(stack, element);
      stack.push(top);
  }

STACK vs ARRAY — Same logic, different methods:
  stack.pop()     = arr.remove(arr.size()-1)
  stack.push(x)   = arr.add(x)
  stack.peek()    = arr.get(arr.size()-1)
  stack.isEmpty() = arr.isEmpty()

DRY RUN: [5,3,1] (1 on top)
  pop 1 → pop 3 → [5] base case
  insert 3: 3<5 pop 5, empty push 3, push 5 → [3,5]
  insert 1: 1<5 pop 5, 1<3 pop 3,
            empty push 1, push 3, push 5 → [1,3,5] ✅

IBH:
  B = size ≤ 1 → return
  H = sortStack(smaller stack) works
  I = pop top → sort rest → insertSorted(stack, top)

insertSorted BASE: empty OR peek() <= element → push
  "Pop bigger elements. Push yours. Put bigger ones back."

MEMORIZE: "Pop top. Sort rest. Insert at correct spot."

TIME: O(n²)  SPACE: O(n) call stack


WHAT IS BACKTRACKING?
  Try something → recurse → UNDO it → try next.
  Like trying outfits: wear → check → remove → try next.

WHY BACKTRACK?
  current is ONE shared ArrayList.
  ALL recursive calls modify SAME list.
  Without remove: current keeps growing. Wrong subsets!

  Without backtrack:
    add 1 → add 2 → add 3 → back to level 2
    current is [1,2,3] → should be [1,2] → WRONG!

  With backtrack:
    add 1 → add 2 → add 3 → REMOVE 3 → back to level 2
    current is [1,2] ✅ → CORRECT!

PATTERN:
  current.add(arr[i]);         // PICK (go forward)
  recurse(i + 1);              // EXPLORE (go deeper)
  current.remove(last);        // UNDO (come back clean)

WHEN TO BACKTRACK:
  ArrayList (mutable)  → MUST backtrack (add → remove)
  String (immutable)   → NO backtrack needed
                         (creates new copy, original unchanged)

COPY RULE:
  result.add(new ArrayList<>(current));  ✅ add COPY
  result.add(current);                   ❌ adds REFERENCE
  Without copy: all entries in result point to SAME list!

MEMORIZE: "Mutable data → backtrack. Immutable → no backtrack.
  Always add COPY to result, never the original."

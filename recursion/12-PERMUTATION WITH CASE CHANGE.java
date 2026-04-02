PERMUTATION WITH CASE CHANGE

PROBLEM : Generate all uppercase/lowercase combinations. 
"abc" → "abc","abC","aBc","aBC","Abc","AbC","ABc","ABC"
Total = 2^n (each char : lower or upper)

KEY IDEA : Same as Power Set but choices are lower/upper. 
 For each character: 
 Choice 1 : Keep lowercase
 Choice 2 : make UPPERCASE 

 CODE(without digits)

 void solve(String s, int index, String current, ArrayList<String> result){
    if(index == s.length()){
        result.add(current);
        return;
    }
    char ch = s.charAt(index);

    solve(s, index+1, current+ Character.toLowerCase(ch), result);
    solve(s, index+1, current + Character.toUpperCase(ch), result);
 }

 CODE (with digits - only branch on letters):

 void solve(String s, int index, String current, ArrayList<String> result){
    if(index == s.length()){
        result.add(current);
        return;
    }
    char ch = s.charAt(index);

    if(Character.isLetter(ch)){
        solve(s, index+1, current+ Character.toLowerCase(ch), result);
        solve(s, index+1, current+Character.toUpperCase(ch), result);
    } else{
        solve(s, index+1, current + ch, result);
    }
 }

 DRY RUN: "ab"
  "" → lower 'a' → "a" → lower 'b' → "ab" ✅
                       → upper 'B' → "aB" ✅
     → upper 'A' → "A" → lower 'b' → "Ab" ✅
                       → upper 'B' → "AB" ✅
  Result: ["ab", "aB", "Ab", "AB"] ✅

THREE SIMILAR PROBLEMS — SAME TEMPLATE:
  Power Set:   include / exclude char
  Spaces:      space / no space
  Case Change: lowercase / UPPERCASE
  
  Template:
    if base → add current
    solve(index+1, choice A)
    solve(index+1, choice B)

DIGIT HANDLING:
  Letter → 2 choices (lower/upper) → 2 recursive calls
  Digit  → 1 choice (keep as is)  → 1 recursive call
  "a1b" → 2^2 = 4 results (only 2 letters branch)

NO BACKTRACK: String is immutable.

TIME: O(2^n)  SPACE: O(n) call stack
MEMORIZE: "Each char: lower or upper. Same template as power set."
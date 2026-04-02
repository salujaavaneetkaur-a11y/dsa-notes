WHAT IS RECURSION?
  A function that calls ITSELF.
  Breaks big problem into SMALLER version of same problem.
  Keeps breaking until simplest case (base case).

EVERY RECURSIVE FUNCTION HAS 2 THINGS:
  1. BASE CASE = when to STOP (brakes of car)
  2. RECURSIVE CASE = make problem SMALLER (engine)
  No base case = infinite loop = StackOverflowError!

IBH FRAMEWORK (use for ANY recursion problem):
  I = Induction: what's MY job with current element?
  B = Base: when do I stop?
  H = Hypothesis: trust recursion for smaller input

RECURSION FLOW RULE:
  Code BEFORE recursive call → runs GOING DOWN
  Code AFTER recursive call  → runs COMING BACK UP

  int top = stack.pop();      ← GOING DOWN (pop)
  recursive call();           ← PAUSE HERE (go deeper)
  stack.push(top);            ← COMING BACK UP (push back)

RETURN RULE:
  return exits ONLY the current call.
  Does NOT exit the caller.
  Caller RESUMES from where it paused.

LOCAL VARIABLES ARE PER-CALL:
  CALL 1's 'top' = 5 (stored in CALL 1's memory)
  CALL 2's 'top' = 4 (stored in CALL 2's memory)
  They are SEPARATE. Not shared. Not overwritten.
  Like separate people holding separate cards.

MEMORIZE: "Base case first. Trust recursion for smaller.
  Your job: handle current element."


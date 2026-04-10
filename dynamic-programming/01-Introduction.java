# Dynamic Programming — Introduction

---

## What is DP?

DP = solving a big problem by breaking it into **smaller overlapping subproblems** and **storing their results** to avoid recomputation.

> "Recursion + Memoization = DP"

---

## When to use DP?

Two conditions must hold:

1. **Optimal Substructure** — optimal solution of problem contains optimal solutions of subproblems
2. **Overlapping Subproblems** — same subproblems are solved multiple times

---

## Two Approaches

| | Memoization (Top-Down) | Tabulation (Bottom-Up) |
|---|---|---|
| Style | Recursive + cache | Iterative + table |
| Direction | Big → Small | Small → Big |
| Space | Call stack + memo array | DP table only |
| Ease | More intuitive | More optimal |

---

## DP vs Divide & Conquer

| | Divide & Conquer | DP |
|---|---|---|
| Subproblems | Independent | Overlapping |
| Example | Merge Sort | Fibonacci |

---

## Classic First Example — Fibonacci

**Plain recursion:** O(2ⁿ) — recomputes same values

**With Memoization:**
```
fib(n):
  if n <= 1 → return n
  if memo[n] exists → return memo[n]
  memo[n] = fib(n-1) + fib(n-2)
  return memo[n]
```
Time: O(n) | Space: O(n)

**With Tabulation:**
```
dp[0] = 0, dp[1] = 1
for i from 2 to n:
  dp[i] = dp[i-1] + dp[i-2]
```
Time: O(n) | Space: O(n) → can optimize to O(1)

---

## Steps to Solve any DP Problem

1. **Identify** if it's a DP problem (optimal substructure + overlapping)
2. **Define** the state — what does `dp[i]` mean?
3. **Write** the recurrence relation
4. **Identify** base cases
5. **Decide** memoization or tabulation
6. **Optimize** space if possible

---

## Common DP Problem Categories

- 1D DP → Fibonacci, Climbing Stairs, House Robber
- 2D DP → Grid paths, Edit Distance
- Subsequence → LCS, LIS
- Knapsack → 0/1, Unbounded
- Partition → Subset Sum, Palindrome Partition
- Interval DP → Matrix Chain Multiplication

---

**Key mindset:** *"Trust the recursion. Define state clearly. Write recurrence."*

---

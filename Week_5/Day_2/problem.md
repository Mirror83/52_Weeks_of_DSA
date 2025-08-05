# K-Subarrays

## Problem Statement

A **k-subarray** of an array is defined as follows:

- It is a **subarray**, i.e., made of contiguous elements in the array.
- The sum of the subarray elements, `s`, is **evenly divisible** by `k`, i.e., `sum % k == 0`.

Given an array of integers, determine the number of **k-subarrays** it contains.

For example, given `k = 5` and the array `nums = [5, 10, 11, 9, 5]`, the **10 k-subarrays** are:  
`{5}, {5, 10}, {5, 10, 11, 9}, {5, 10, 11, 9, 5}, {10}, {10, 11, 9}, {10, 11, 9, 5}, {11, 9}, {11, 9, 5}, {5}`.

---

## Function Description

Complete the function **`kSub`** in the editor below.  
The function must return a **long integer** that represents the number of k-subarrays in the array.

### **Function Signature**

```python
def kSub(k: int, nums: List[int]) -> int:
```

## **Source of Problem**

[Hackerrank K-subarrays](https://www.hackerrank.com/challenges/k-subarrays/problem)

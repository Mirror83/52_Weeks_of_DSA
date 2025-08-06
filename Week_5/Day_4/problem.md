# Linked Lists - Sorted Merge

Write a `SortedMerge()` function that takes two lists, each of which is sorted in increasing order, and merges the two together into one list which is in increasing order. `SortedMerge()` should return the new list. The new list should be made by splicing together the nodes of the first two lists. Ideally, `SortedMerge()` should only make one pass through each list. `SortedMerge()` is tricky to get right and it may be solved iteratively or recursively.

```javascript
var first = 2 -> 4 -> 6 -> 7 -> null
var second = 1 -> 3 -> 3 -> 5 -> 6 -> 8 -> null
sortedMerge(first, second) === 1 -> 2 -> 3 -> 3 -> 4 -> 5 -> 6 -> 6 -> 7 -> 8 -> null
```

## **Source of Problem**

[Codewars Linked Lists - Sorted Merge](https://www.codewars.com/kata/55e5d31bf7ca1e44980000a7/train/python)

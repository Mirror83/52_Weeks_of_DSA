class Solution {
    // Uses the two pointer approach to leverage the fact that the
    // array is sorted.
    //
    // Complexity Analysis
    // --------------------
    // - Runtime -> O(n)
    //      The indices will be increased a total of n - 1 times in the worst
    //      case, therefore the algorithm runs in linear time.
    // - Space -> O(1)
    //      The only extra space is for i, j and the sum of the values at
    //      i and j. The returned array always stores two elements.
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1

        while (i != j) {
            val sum = numbers[i] + numbers[j]
            if (sum > target) {
                // This means that there's no number that we can add
                // to the number at index `j` that will make `sum` smaller
                // than what we have (and thus make sum approach `target`), 
                // so we have to move to the next smallest number
                j -= 1
            } else if (sum < target) {
                // This means that there's no number that we can add
                // to the number at index `i` that will make `sum` larger
                // than what we have (and thus make sum approach `target`)
                // so we have to move to the next largest number
                i += 1
            } else return intArrayOf(i + 1, j + 1)
        }

        // This means that we do not have any values
        // that can add up to `result`
        // A sentinel value that will not be reached since the
        // tests are generated such that there is exactly one solution
        return intArrayOf(-1, -1)
        
    }
}
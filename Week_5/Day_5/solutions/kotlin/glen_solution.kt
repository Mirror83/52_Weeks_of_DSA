class Solution {
    // The sliding window approach works because the array 
    // does not contain negative numbers.
    //
    // Complexity Analysis
    // --------------------
    // - Time Complexity -> O(n)
    //      Every element is considered at most twice (once when expanding
    //      and once when shrinking the sliding window). Additionally, since the 
    //      time is saved in how the sum is calculated as a running sum, instead
    //      of looping over the range covered by the subarrays every time the sum
    //      is required.
    // - Space Complexity -> O(1)
    //      The extra space is only taken up by the sliding window pointers (left and right),
    //      the sum of the elements in the sliding window, and the result value. All of these
    //      are just simple integers that take up constant space.
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        // Left pointer for the sliding window
        // Right pointer will iterate through the array
        var left = 0

        // Current sum of the sliding window
        var sum = 0

        // Minimum subarray length
        var result = Int.MAX_VALUE

        for (right in nums.indices) {
            sum += nums[right]
            // Reduce the window size from the left to find the
            // smallest subarray that matches the condition
            while (sum >= target) {
                sum -= nums[left]
                result = kotlin.math.min(result, (right - left) + 1)
                left += 1
            }
        }

        return if (result == Int.MAX_VALUE) 0 else result
    }
}
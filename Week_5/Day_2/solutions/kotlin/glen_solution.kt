import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * This was a hard one. I couldn't solve it (except using brute force),
 * and (at the time of writing) I can't claim to fully understand the solution I found.
 * If you want to understand the solution, try solving 
 * Leetcode 560 - Subarray Sum Equals K. 
 * (https://leetcode.com/problems/subarray-sum-equals-k/description/)
 *
 * This problem is also on Leetcode, as Leetcode 974 - Subarray Sums Divisible by K.
 * (https://leetcode.com/problems/subarray-sums-divisible-by-k/)
 * You can checkout the editorials for the two problems. They go into detail on how the
 * solution works. Here are the links:
 * - https://leetcode.com/problems/subarray-sum-equals-k/editorial/
 * - https://leetcode.com/problems/subarray-sums-divisible-by-k/editorial/
 */

fun kSub(k: Int, nums: Array<Int>): Long {
    var count: Long = 0
    var remainder: Int = 0

    val remFrequencies = mutableMapOf<Int, Long>(0 to 1)
    for (num in nums) {
        // Take remainder twice to avoid negative remainders
        remainder = (remainder + k + (num % k)) % k

        // Add the count of subarrays that have the same
        // remainder as current one
        count += remFrequencies.getOrDefault(remainder, 0)

        remFrequencies.put(
            remainder, 
            remFrequencies.getOrDefault(remainder, 0) + 1
        )
    }
    return count
}

fun main(args: Array<String>) {
    val k = readLine()!!.trim().toInt()

    val numsCount = readLine()!!.trim().toInt()

    val nums = Array<Int>(numsCount, { 0 })
    for (i in 0 until numsCount) {
        val numsItem = readLine()!!.trim().toInt()
        nums[i] = numsItem
    }

    val result = kSub(k, nums)

    println(result)
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
import java.math.BigInteger

class Solution {
    // This uses the classic string to number conversion (adapted for the linked list)
    // to get the numbers represented by the linked lists,
    // adds them together, and then converts the sum back to a linked list.
    // The problem mentions that the numbers in the linked lists
    // are stored in reverse order. This makes it work well with the
    // number conversion logic.
    // The conversion is done using BigInteger to avoid overflow.
    //
    // Complexity analysis
    // -------------------
    // Note: this analysis is not complete.
    // With m and n being the lengths of the two linked lists:
    // - Time complexity -> O(max(m, n) x log(max(m, n)))
    //      The log factor is due to the BigInteger operations in the `getNumericVal` function, and
    //      the time taken to convert the sum back to a linked list.
    // - Space complexity -> O(max(m, n))
    //     The space is used for the result linked list which will store a value with
    //     a length of at most max(m, n) + 1.
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val num1 = getNumericVal(l1)
        val num2 = getNumericVal(l2)

        var sum = num1 + num2

        if (sum.compareTo(BigInteger.ZERO) == 0) {
            return ListNode(0)
        }

        var result: ListNode? = null
        var current: ListNode? = null

        while (!(sum.compareTo(BigInteger.ZERO) == 0)) {
            val (quotient, remainder) = sum.divideAndRemainder(BigInteger.TEN)
            sum = quotient
            if (result == null) {
                result = ListNode(remainder.toInt())
                current = result
            } else {
                current!!.next = ListNode(remainder.toInt())
                current = current!!.next
            }
        }

        return result
        
    }

    fun getNumericVal(l: ListNode?): BigInteger {
        var current = l
        var num = BigInteger.ZERO
        var placeValue = BigInteger.ONE

        while (current != null) {
            num = num + current.`val`.toBigInteger() * placeValue

            if (placeValue.equals(1)) { 
                placeValue = BigInteger.TEN 
            }
            else { 
                placeValue = placeValue * BigInteger.TEN
            }
            current = current.next
        }

        return num
    }
}
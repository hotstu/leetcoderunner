package github.hotstu.leetcode._600_700

import github.hotstu.leetcode.util.assertIt

/***
 <pre>
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
one of the numbers in the set got duplicated to another number in the set, which results
in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task
is to firstly find the number occurs twice and then find the number that is missing.
Return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Note:

The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

 </pre>
 **/

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val booleanArray = BooleanArray(nums.size) { false }
        var dupIndex = -1;
        var missingIndex = -1
        nums.forEach { i ->
            if (booleanArray[i - 1]) {
                dupIndex = i
            }
            booleanArray[i - 1] = true
        }
        booleanArray.forEachIndexed { index, b ->
            if (!b) {
                missingIndex = index + 1
            }
        }
        return intArrayOf(dupIndex, missingIndex)
    }
}

fun main() {
    val ret = Solution().findErrorNums(intArrayOf(1, 2, 2, 4))
    assertIt(ret[0], 2)
    assertIt(ret[1], 3)
}
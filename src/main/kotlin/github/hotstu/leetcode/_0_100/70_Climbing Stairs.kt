package github.hotstu.leetcode._0_100

import org.w3c.dom.ranges.Range

/***
<pre>
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


</pre>
 ***/

/**
 * 递归
 */
class Solution1 {
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        return climbStairs(n - 1) + climbStairs(n - 2)
    }
}

/**
 * dp
 */
class Solution2 {
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        var c1 = 1;
        var c2 = 2;
        for (i in 3 until n) {
            val t = c2
            c2 += c1
            c1 = t
        }
        return c1 + c2
    }
}

fun main() {
    println(Solution2().climbStairs(4))
}
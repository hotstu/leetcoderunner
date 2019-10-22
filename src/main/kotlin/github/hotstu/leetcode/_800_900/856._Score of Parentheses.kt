package github.hotstu.leetcode._800_900

import github.hotstu.leetcode.util.assertIt
import java.lang.IllegalArgumentException
import java.util.*

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.



Example 1:

Input: "()"
Output: 1

Example 2:

Input: "(())"
Output: 2

Example 3:

Input: "()()"
Output: 2

Example 4:

Input: "(()(()))"
Output: 6



Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50

 **/

class Solution {
    fun scoreOfParentheses(S: String): Int {
        val stack = LinkedList<Int>()

        for (c in S) {
            when (c) {
                '(' -> {
                    stack.push(-1)
                }
                ')' -> {
                    var v = 1
                    var pop = stack.pop()
                    if (pop > 0) {
                        v = pop
                        while ((stack.pop()).also { pop = it } > 0) {
                            v += pop
                        }
                        v*=2
                    } else {
                        v = 1
                    }
                    stack.push(v)


                }
                else -> throw IllegalArgumentException()
            }
        }
        return stack.sum()
    }
}

fun main() {
    val nanoTime = System.nanoTime()
    assertIt(Solution().scoreOfParentheses("(()(()))") == 6)
    assertIt(Solution().scoreOfParentheses("(()()(()))") == 8)
    assertIt(Solution().scoreOfParentheses("()()") == 2)
    assertIt(Solution().scoreOfParentheses("(())") == 2)
    assertIt(Solution().scoreOfParentheses("()") == 1)
    println((System.nanoTime() - nanoTime)/(1000* 1000))
}
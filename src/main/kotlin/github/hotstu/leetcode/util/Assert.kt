package github.hotstu.leetcode.util

import java.lang.AssertionError

 fun assertIt(query: Boolean) {
    if (!query) {
        throw AssertionError()
    }
}

 fun assertIt(query: Any, dst: Any) {
    if (query != dst) {
        throw AssertionError()
    }
}
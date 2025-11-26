package com.example.testcdappdis

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)


        /**
         * Scenario 1: We have 2 pages - Limit: 8
         * [0] [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [11] [12] [13] [14] [15] [16]
         *
         * When newest message come from the current loaded item(No.8)
         * [0] [1] [2] [3] [4] [5] [6] [7] [8]
         * [8] [0] [1] [2] [3] [4] [5] [6] [7] [9] [10] [11] [12] [13] [14] [15] [16]
         *
         * But when it come from the next page(No.9)
         * [0] [1] [2] [3] [4] [5] [6] [7] [8]
         * The next page we should load will be after [8]
         * [9] [0] [1] [2] [3] [4] [5] [6] [7] [8] [9?] [10] [11] [12] [13] [14] [15] [16]
         *
         * But if the network is having problem? How could we know if the num [8] are the anchor?
         * [9] [0] [1] [2] [3] [4] [5] [6] [7] [8] [?] [?] [?]
         * When reconnection happens, I think we should reload the current page :) AND invalidate others
         *
         **/
    }
}
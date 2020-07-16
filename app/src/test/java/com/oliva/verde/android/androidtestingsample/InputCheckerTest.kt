package com.oliva.verde.android.androidtestingsample


import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.hamcrest.CoreMatchers.`is`


class InputCheckerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun isValid() {
        val target = InputChecker()
        val actual = target.isValid("foo")
        assertThat(actual, `is`(true))
    }
}
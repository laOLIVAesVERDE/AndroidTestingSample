package com.oliva.verde.android.androidtestingsample


import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.hamcrest.CoreMatchers.`is`


class InputCheckerTest {
    lateinit var target : InputChecker

    @Before
    fun setUp() {
        target = InputChecker()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun isValid() {
        val actual = target.isValid("foo")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValid_givenLessThan3_returnsFalse() {
        val actual = target.isValid("ab")
        assertThat(actual, `is`(false))
    }

    @Test
    fun isValid_givenAlphaNumeric_returnsTrue() {
        val actual = target.isValid("abc123")
        assertThat(actual, `is`(true))
    }
 }
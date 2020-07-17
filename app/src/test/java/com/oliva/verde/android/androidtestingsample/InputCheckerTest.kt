package com.oliva.verde.android.androidtestingsample


import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.hamcrest.CoreMatchers.`is`
import org.junit.Ignore


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
    fun isValis_givenAlphabetic_returnsTrue() {
        val actual = target.isValid("abc")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValis_givenNumeric_returnsTrue() {
        val actual = target.isValid("123")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValid_givenAlphaNumeric_returnsTrue() {
        val actual = target.isValid("abc123")
        assertThat(actual, `is`(true))
    }

    @Test
    fun isValid_givenInvalidCharacter_returnsFalse() {
        val actual = target.isValid("abc@123")
        assertThat(actual, `is`(false))
    }

    // @Test(expected = 例外クラス) : テスト対象メソッドが意図通り例外を発生させたかを検証
    @Test(expected = IllegalArgumentException::class)
    fun isValid_givenNull_throwsIllegalArgumentException() {
        target.isValid(null)
    }

    @Ignore("テスト対象が仮実装なので一時的にスキップ")
    @Test
    fun temporarilySkipThisTest() {
        // 略
    }
 }
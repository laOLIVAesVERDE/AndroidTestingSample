package com.oliva.verde.android.androidtestingsample


import org.assertj.core.api.Assertions.*
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
        // AssertJを用いたアサーション
        assertThat(actual).isTrue()
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

    // AssertJを用いたアサーションサンプル
    // 文字列のアサーション
    @Test
    fun AssertJSampleTesting() {
        assertThat("TOKYO")
            .`as`("TEXT CHECK TOKYO")
            .isEqualTo("TOKYO")
            .isEqualToIgnoringCase("tokyo")
            .isNotEqualTo("KYOTO")
            .isNotBlank()
            .startsWith("TO")
            .endsWith("YO")
            .contains("OKY")
            .matches("[A-Z]{5}")
            .isInstanceOf(String::class.java)
    }

    // フィルタリング
    data class BallTeam(val name : String, val city : String, val stadium : String)
    val targetList = listOf(
        BallTeam("Giants", "San Francisco", "AT&T Park"),
        BallTeam("Dodgers", "Los Angels", "Dodger Stadium"),
        BallTeam("Angels", "Los Angels", "Angel Stadium"),
        BallTeam("Athletics", "Oakland", "Oakland Coliseum"),
        BallTeam("Padres", "San Diego", "Petco Park")
    )

    @Test
    fun targetList_filter_returnsTrue() {
        assertThat(targetList)
            .filteredOn { team -> team.city.startsWith("San") }
            .filteredOn { team -> team.city.endsWith("Francisco") }
            .extracting("name", String::class.java) // nameプロパティを取り出す
            .containsExactly("Giants")
    }

 }
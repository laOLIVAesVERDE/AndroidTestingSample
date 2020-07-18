package com.oliva.verde.android.androidtestingsample

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WeatherForecastTest {
    lateinit var recorder: WeatherRecorder
    lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        recorder = mock(name = "MockRecorder")


        val satellite = Satellite()
        val formatter = WeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun recordCurrentWeather_assertRecorderCalled() {
        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        verify(recorder, times(1)).record(any())
    }

    /** スタブを用いたテスト
    @Test
    fun shouldBringUmbrella_givenInJapan_returnsFalse() {
        val actual = weatherForecast.shouldBringUmbrella(35.669784, 139.817728)
        assertThat(actual).isFalse()
    }

    @Test
    fun shouldBringUmbrella_givenBurlingame_returnsTrue() {
        val actual = weatherForecast.shouldBringUmbrella(37.580006, -122.345106)
        assertThat(actual).isTrue()
    }
    */
}
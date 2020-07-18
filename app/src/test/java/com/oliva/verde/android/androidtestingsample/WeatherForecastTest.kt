package com.oliva.verde.android.androidtestingsample

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Spy

class WeatherForecastTest {
    @Mock
    lateinit var satellite: Satellite
    @Mock
    lateinit var recorder: WeatherRecorder
    @Spy
    val formatter: WeatherFormatter = WeatherFormatter()

    lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        val satellite = Satellite()
        val recorder = WeatherRecorder()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun recordCurrentWeather_assertFormatterCalled() {
        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        verify(formatter, times(1)).format(any())
    }

    /** モックを用いたテスト
    @Test
    fun recordCurrentWeather_assertRecorderCalled() {
        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        verify(recorder, times(1)).record(any())
    }

    // スタブを用いたテスト
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
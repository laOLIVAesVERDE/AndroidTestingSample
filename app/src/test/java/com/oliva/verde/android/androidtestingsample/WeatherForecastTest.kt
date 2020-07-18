package com.oliva.verde.android.androidtestingsample

import org.assertj.core.api.Assertions.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WeatherForecastTest {
    lateinit var weatherForecast: WeatherForecast
    lateinit var recorder: MockWeatherRecorder

    @Before
    fun setUp() {
        val satellite = Satellite()
        recorder = MockWeatherRecorder()
        weatherForecast = WeatherForecast(satellite, recorder)
    }

    @Test
    fun recordCurrentWeather_assertCalled() {
        weatherForecast.recordCurrentWeather()
        val isCalled = recorder.isCalled
        assertThat(isCalled).isTrue()

        val weather = recorder.weather
        assertThat(weather)
            .isIn(Weather.SUNNY, Weather.CLOUDY, Weather.RAINY)
    }
}
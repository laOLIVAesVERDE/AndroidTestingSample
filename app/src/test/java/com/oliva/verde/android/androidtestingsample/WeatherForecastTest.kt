package com.oliva.verde.android.androidtestingsample

import org.assertj.core.api.Assertions.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WeatherForecastTest {
    lateinit var weatherForecast: WeatherForecast
    lateinit var formatter: SpyWeatherFormatter

    @Before
    fun setUp() {
        val satellite = Satellite()
        val recorder = WeatherRecorder()
        formatter = SpyWeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun recordCurrentWeather_assertCalled() {
        weatherForecast.recordCurrentWeather()
        val isCalled = formatter.isCalled
        assertThat(isCalled).isTrue()

        val weather = formatter.weather
        assertThat(weather)
            .isIn(Weather.SUNNY, Weather.CLOUDY, Weather.RAINY)
    }
}
package com.oliva.verde.android.androidtestingsample

import org.assertj.core.api.Assertions.*
import org.junit.Test

import org.junit.Assert.*

class WeatherForecastTest {
    lateinit var weatherForecast: WeatherForecast

    @Test
    fun shouldBringUmbrella_givenSUNNY_returnsFalse() {
        val satellite = StubSatellite(Weather.SUNNY)
        weatherForecast = WeatherForecast(satellite)

        val actual = weatherForecast.shouldBringUmbrella()
        assertThat(actual).isFalse()
    }
}
package com.oliva.verde.android.androidtestingsample

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WeatherForecastTest {
    lateinit var satellite: Satellite
    lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        satellite = mock(name = "MockSatellite")
        // Mockしたsatelliteにスタブメソッドを設定
        whenever(satellite.getWeather(any(), any()))
            .thenAnswer { invocation ->
                val latitude = invocation.arguments[0] as Double
                val longitude = invocation.arguments[1] as Double

                if (latitude in 20.424086..45.550999 &&
                    longitude in 122.933872..153.980789) {
                    return@thenAnswer Weather.SUNNY
                } else {
                    return@thenAnswer Weather.RAINY
                }
            }

        val recorder = WeatherRecorder()
        val formatter = WeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

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
}
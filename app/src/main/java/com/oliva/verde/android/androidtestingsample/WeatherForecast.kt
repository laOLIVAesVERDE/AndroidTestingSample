package com.oliva.verde.android.androidtestingsample

open class Satellite {
    open fun getWeather() : Weather {
        return Weather.CLOUDY
    }
}

class StubSatellite(val anyWeather : Weather) : Satellite() {
    override fun getWeather(): Weather {
        return anyWeather
    }
}

class WeatherForecast(val satellite: Satellite) {

    fun shouldBringUmbrella(): Boolean {
        val weather = satellite.getWeather()
        return when(weather) {
            Weather.SUNNY, Weather.CLOUDY -> false
            Weather.RAINY -> true
        }
    }
}

enum class Weather {
    SUNNY, CLOUDY, RAINY
}
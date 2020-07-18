package com.oliva.verde.android.androidtestingsample

open class Satellite {
    open fun getWeather(latitude : Double, longitude : Double) : Weather {
        return Weather.CLOUDY
    }
}

class WeatherForecast(val satellite: Satellite,
                      val recorder: WeatherRecorder,
                      val formatter : WeatherFormatter) {

    fun shouldBringUmbrella(latitude : Double, longitude : Double): Boolean {
        val weather = satellite.getWeather(latitude, longitude)
        return when(weather) {
            Weather.SUNNY, Weather.CLOUDY -> false
            Weather.RAINY -> true
        }
    }
}

open class WeatherFormatter {
    open fun format(weather: Weather) : String = "Weather is ${weather}"
}

open class WeatherRecorder {
    open fun record(weather: String) {

    }
}

enum class Weather {
    SUNNY, CLOUDY, RAINY
}
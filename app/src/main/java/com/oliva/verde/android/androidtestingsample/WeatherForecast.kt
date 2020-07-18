package com.oliva.verde.android.androidtestingsample

open class Satellite {
    open fun getWeather(latitude: Double, longitude: Double) : Weather {
        return Weather.CLOUDY
    }
}


class WeatherForecast(val satellite: Satellite,
                      val recorder: WeatherRecorder,
                      val formatter : WeatherFormatter) {

    fun shouldBringUmbrella(latitude: Double, longitude: Double): Boolean {
        val weather = satellite.getWeather(latitude, longitude)
        return when(weather) {
            Weather.SUNNY, Weather.CLOUDY -> false
            Weather.RAINY -> true
        }
    }

    fun recordCurrentWeather(latitude: Double, longitude: Double) {
        val weather = satellite.getWeather(latitude, longitude)
        val formatted = formatter.format(weather)
        recorder.record(formatted)
    }

}

open class WeatherFormatter {
    open fun format(weather: Weather) : String = "Weather is ${weather}"
}



open class WeatherRecorder {
    open fun record(weather: String) {

    }
}

class SpyWeatherFormatter : WeatherFormatter() {
    var weather : Weather? = null
    var isCalled = false

    override fun format(weather: Weather): String {
        this.weather = weather
        isCalled = true
        return super.format(weather)
    }
}

class MockWeatherRecorder : WeatherRecorder() {
    var weather : Weather? = null
    var isCalled = false

    override fun record(weather: String) {
        isCalled = true
    }
}

enum class Weather {
    SUNNY, CLOUDY, RAINY
}
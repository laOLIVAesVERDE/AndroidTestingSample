package com.oliva.verde.android.androidtestingsample.asynctesting

class StringFetcher {
    fun fetch() : String {
        Thread.sleep(1000L)
        return "foo"
    }
}
package ru.oliverhd.simpledictionary.view

interface MainView {

    fun showTranslation(translation: String)
    fun showError(throwable: Throwable)
}
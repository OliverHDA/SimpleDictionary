package ru.oliverhd.simpledictionary.presenter

import ru.oliverhd.simpledictionary.view.MainActivity

interface Presenter {

    fun attach(activity: MainActivity)
    fun detach()
    fun translate(query: String)
}
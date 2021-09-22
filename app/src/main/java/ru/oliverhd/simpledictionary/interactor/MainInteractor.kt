package ru.oliverhd.simpledictionary.interactor

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation

interface MainInteractor {
    fun getData(query: String): Single<Translation>
}
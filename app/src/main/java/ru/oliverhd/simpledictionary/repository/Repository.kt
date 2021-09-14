package ru.oliverhd.simpledictionary.repository

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation

interface Repository {

    fun getTranslation(query: String): Single<Translation>
}
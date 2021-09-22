package ru.oliverhd.simpledictionary.interactor

import io.reactivex.Single
import ru.oliverhd.simpledictionary.data.Translation
import ru.oliverhd.simpledictionary.repository.Repository
import javax.inject.Inject

class MainInteractorImpl @Inject constructor(private val repository: Repository) : MainInteractor {
    override fun getData(query: String): Single<Translation> = repository.getTranslation(query)
}
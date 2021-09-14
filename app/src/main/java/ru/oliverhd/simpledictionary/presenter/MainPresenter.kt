package ru.oliverhd.simpledictionary.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.oliverhd.simpledictionary.repository.Repository
import ru.oliverhd.simpledictionary.scheduler.Schedulers
import ru.oliverhd.simpledictionary.view.MainActivity
import ru.oliverhd.simpledictionary.view.MainView

class MainPresenter(
    private val repository: Repository,
    private val schedulers: Schedulers,
) : Presenter {

    private val disposables = CompositeDisposable()

    private var view: MainView? = null

    override fun attach(activity: MainActivity) {
        view = activity
    }

    override fun detach() {
        disposables.clear()
        view = null
    }

    override fun translate(query: String) {
        disposables.add(
            repository
                .getTranslation(query)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    { view?.showTranslation(it.responseData.translatedText) },
                    { view?.showError(it) }
                )
        )
    }


}
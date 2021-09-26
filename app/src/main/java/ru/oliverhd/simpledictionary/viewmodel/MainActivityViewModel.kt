package ru.oliverhd.simpledictionary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.oliverhd.simpledictionary.interactor.MainInteractor
import ru.oliverhd.simpledictionary.scheduler.Schedulers

class MainActivityViewModel(
    private val interactor: MainInteractor,
    private val schedulers: Schedulers,
) :
    ViewModel() {

    private val _liveData = MutableLiveData<String>()

    fun getLiveData(): LiveData<String> = _liveData

    private val disposables = CompositeDisposable()

    fun getData(query: String) =
        disposables.add(
            interactor
                .getData(query)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    { _liveData.postValue(it.responseData.translatedText) },
                    { _liveData.postValue(it.message) })
        )

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}
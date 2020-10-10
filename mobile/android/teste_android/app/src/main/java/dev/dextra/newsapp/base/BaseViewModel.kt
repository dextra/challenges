package dev.dextra.newsapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val disposables = mutableListOf<Disposable>()

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun clearDisposables() {
        disposables.forEach {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
        disposables.clear()
    }

    fun getDisposables(): List<Disposable> {
        return disposables
    }

    public override fun onCleared() {
        clearDisposables()
        super.onCleared()
    }

}
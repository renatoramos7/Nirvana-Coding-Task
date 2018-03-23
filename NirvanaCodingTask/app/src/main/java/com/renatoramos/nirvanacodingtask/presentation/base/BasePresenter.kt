package com.renatoramos.nirvanacodingtask.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by renatoramos on 19.03.18.
 */

abstract class BasePresenter<out V> protected constructor(protected val mView: V) {

    private var mCompositeDisposable: CompositeDisposable? = null


    /**
     * Contains common setup actions needed for all presenters, if any.
     * Subclasses may override this.
     */
    abstract fun onStart()

    /**
     * Contains common cleanup actions needed for all presenters, if any.
     * Subclasses may override this.
     */
    fun onStop() {
        getCompositeDisposable().clear()
    }


    protected fun addDisposable(disposable: Disposable) {
        getCompositeDisposable().add(disposable)
    }

    private fun getCompositeDisposable(): CompositeDisposable {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable = CompositeDisposable()
        }
        return mCompositeDisposable as CompositeDisposable
    }
}
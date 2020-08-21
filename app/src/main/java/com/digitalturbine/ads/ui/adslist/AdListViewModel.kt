package com.digitalturbine.ads.ui.adslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digitalturbine.ads.data.model.ResponseState
import com.digitalturbine.ads.data.repository.AdRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AdListViewModel @Inject constructor(
    private val repository: AdRepository
): ViewModel() {

    private val adMutableLiveData = MutableLiveData<ResponseState>()
    val adResponse: LiveData<ResponseState> = adMutableLiveData
    private val disposable = CompositeDisposable()

    fun getAdListData() {
        adMutableLiveData.postValue(ResponseState.Loading)
        disposable.add(repository.getAds()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {
                    when (it?.size) {
                        0 -> adMutableLiveData.postValue(ResponseState.Empty)
                        else -> adMutableLiveData.postValue(ResponseState.Success(it!!))
                    }
                },
                {
                    adMutableLiveData.postValue(ResponseState.Error(
                        it.localizedMessage
                    ))
                }
            )
        )
    }

    fun onViewDestroy() = disposable.clear()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}
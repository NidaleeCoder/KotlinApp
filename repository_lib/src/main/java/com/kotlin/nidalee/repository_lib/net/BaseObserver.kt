package com.example.nidalee.usekotlin.net

import android.arch.lifecycle.MediatorLiveData
import com.nidalee.kotlin.net.RequestState.Error
import com.nidalee.kotlin.net.RequestState.Start
import com.nidalee.kotlin.net.RequestState.Success
import com.nidalee.kotlin.net.UIDataBean
import io.reactivex.observers.ResourceObserver

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/1 22:08
 */
class BaseObserver<T>(private val mediatorLiveData: MediatorLiveData<UIDataBean<T>>) :
  ResourceObserver<T>() {

  private var uiDataBean: UIDataBean<T>? = null

  init {
    uiDataBean = if(mediatorLiveData.value == null){
      UIDataBean()
    }else{
      mediatorLiveData.value
    }
  }

  override fun onStart() {
    uiDataBean!!.requestState = Start
    uiDataBean!!.t = null
    mediatorLiveData.value = uiDataBean
    super.onStart()
  }

  override fun onComplete() {
  }

  override fun onNext(t: T) {
    uiDataBean!!.requestState = Success
    uiDataBean!!.t = t
    mediatorLiveData.value = uiDataBean
  }

  override fun onError(e: Throwable) {
    uiDataBean!!.requestState = Error
    uiDataBean!!.t = null
    uiDataBean!!.errorMsg = e.message
    mediatorLiveData.value = uiDataBean
  }
}
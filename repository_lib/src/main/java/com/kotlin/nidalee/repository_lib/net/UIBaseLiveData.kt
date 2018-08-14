package com.example.nidalee.usekotlin.net

import android.arch.lifecycle.Observer
import com.nidalee.kotlin.net.RequestState.Error
import com.nidalee.kotlin.net.RequestState.Start
import com.nidalee.kotlin.net.RequestState.Success
import com.nidalee.kotlin.net.UIDataBean

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/2 13:09
 */
abstract class UIBaseLiveData<T> : Observer<UIDataBean<T>> {

  override fun onChanged(t: UIDataBean<T>?) {
    if (t != null) {
      when (t.requestState) {
        Start -> onStart()
        Error -> onError(t.errorMsg)
        Success -> onSuccess(t.t)
      }
    }
  }

  open protected fun onStart() {

  }

  abstract fun onSuccess(t: T?)

  open protected fun onError(errorMsg: String?) {

  }
}
package com.nidalee.kotlin.utils.bus

import android.arch.lifecycle.Observer

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/3 17:21
 */
class ObserverWrapper<T>(private val observer: Observer<T>?):Observer<T> {

  private val isCallOnObserve: Boolean
    get() {
      val stackTrace = Thread.currentThread().stackTrace
      if (stackTrace != null && stackTrace.isNotEmpty()) {
        for (element in stackTrace) {
          if ("android.arch.lifecycle.LiveData" == element.className && "observeForever" == element.methodName) {
            return true
          }
        }
      }
      return false
    }

  override fun onChanged(t: T?) {
    if (observer != null) {
      if (isCallOnObserve) {
        return
      }
      observer.onChanged(t)
    }
  }
}
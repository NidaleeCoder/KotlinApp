package com.nidalee.kotlin.utils.bus

import android.arch.lifecycle.MutableLiveData
import java.util.HashMap

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/3 16:58
 */
class LiveDataBus private constructor(){
  private val bus: MutableMap<String, BusMutableLiveData<Any>>

  init {
    bus = HashMap()
  }

  private object SingletonHolder {
    val DEFAULT_BUS = LiveDataBus()
  }

  fun <T> with(key: String, type: Class<T>): MutableLiveData<T> {
    if (!bus.containsKey(key)) {
      bus[key] = BusMutableLiveData()
    }
    return bus[key] as MutableLiveData<T>
  }

  fun with(key: String): MutableLiveData<Any> {
    return with(key, Any::class.java)
  }

  companion object {
    fun get(): LiveDataBus {
      return SingletonHolder.DEFAULT_BUS
    }
  }
}
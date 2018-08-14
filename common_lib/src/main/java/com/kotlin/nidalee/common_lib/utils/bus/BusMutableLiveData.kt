package com.nidalee.kotlin.utils.bus

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import java.lang.Exception
import java.lang.NullPointerException
import java.util.HashMap
import java.util.Map.Entry

/**
 * description:
 * @author 奈 德 丽
 * @date 2018/8/3 17:20
 */
class BusMutableLiveData<T>: MutableLiveData<T>() {

  private val observerMap = HashMap<Observer<T>, Observer<T>>()

  override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
    super.observe(owner, observer)
    try {
      hook(observer)
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  override fun observeForever(observer: Observer<T>) {
    if (!observerMap.containsKey(observer)) {
      observerMap[observer] = ObserverWrapper(observer)
    }
    observerMap[observer]?.let { super.observeForever(it) }
  }

  override fun removeObserver(observer: Observer<T>) {
    var realObserver: Observer<*>? = if (observerMap.containsKey(observer)) {
      observerMap.remove(observer)
    } else {
      observer
    }
    super.removeObserver((realObserver as Observer<T>?)!!)
  }

  private fun hook(observer: Observer<T>) {
    //get wrapper's version
    val classLiveData = LiveData::class.java
    val fieldObservers = classLiveData!!.getDeclaredField("mObservers")
    fieldObservers.setAccessible(true)
    val objectObservers = fieldObservers.get(this)
    val classObservers = objectObservers.javaClass
    val methodGet = classObservers.getDeclaredMethod("get", Any::class.java)
    methodGet.setAccessible(true)
    val objectWrapperEntry = methodGet.invoke(objectObservers, observer)
    var objectWrapper: Any? = null
    if (objectWrapperEntry is Entry<*, *>) {
      objectWrapper = objectWrapperEntry.value
    }
    if (objectWrapper == null) {
      throw NullPointerException("Wrapper can not be bull!")
    }
    val classObserverWrapper = objectWrapper.javaClass.getSuperclass()
    val fieldLastVersion = classObserverWrapper.getDeclaredField("mLastVersion")
    fieldLastVersion.isAccessible = true
    //get livedata's version
    val fieldVersion = classLiveData!!.getDeclaredField("mVersion")
    fieldVersion.isAccessible = true
    val objectVersion = fieldVersion.get(this)
    //set wrapper's version
    fieldLastVersion.set(objectWrapper, objectVersion)
  }
}
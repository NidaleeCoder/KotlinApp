package com.nidalee.kotlin.repository

import com.nidalee.kotlin.base.BaseApplication
import retrofit2.Retrofit
import java.util.HashMap

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/11 17:37
 */
open class BaseRepository(private val retrofit: Retrofit = BaseApplication.appComponent!!.getRetrofit()) :
  IRepository {

  private val mutableMap: MutableMap<String, Any>
  init {
    mutableMap = HashMap()
  }

  @Suppress("UNCHECKED_CAST")
  override fun <T> getApi(retrofitApi: Class<T>): T {
    var result: T
    result = mutableMap[retrofitApi.name] as T
    if (result == null) {
      result = retrofit.create(retrofitApi)
      mutableMap[retrofitApi.name] = result as Any
    }
    return result
  }
}
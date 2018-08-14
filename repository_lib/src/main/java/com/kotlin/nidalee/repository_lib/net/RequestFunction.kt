package com.example.nidalee.usekotlin.net

import com.nidalee.kotlin.net.BaseResultBean
import io.reactivex.functions.Function

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/1 20:28
 */
class RequestFunction<T> : Function<BaseResultBean<T>,T>  {

  override fun apply(t: BaseResultBean<T>): T {
    var errorCode = t.errorCode
    var errorMsg = t.errorMsg
    var requestException = RequestException(errorCode!!, errorMsg!!)
    when(errorCode){
      0->{
        return t.data
      }
      else->{
        throw requestException
      }
    }
  }
}
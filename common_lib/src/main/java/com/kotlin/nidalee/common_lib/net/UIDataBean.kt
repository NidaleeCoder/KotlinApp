package com.nidalee.kotlin.net

/**
 * description:
 * 封装带有状态的数据Bean，用于ViewModel与View层交互
 * @author 奈德丽
 * @date 2018/8/2 12:32
 */
class UIDataBean<T> {
  var requestState: RequestState? = null
  var t: T? = null
  var errorMsg: String? = null
}
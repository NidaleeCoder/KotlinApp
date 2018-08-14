package com.nidalee.kotlin.net

/**
 * description:返回数据基类
 * @author 奈德丽
 * @date 2018/7/31 19:59
 */
data class BaseResultBean<T>(
  var errorMsg: String? = null,
  var errorCode: Int? = 0,
  var data: T
)
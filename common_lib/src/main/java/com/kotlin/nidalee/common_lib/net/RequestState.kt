package com.nidalee.kotlin.net

/**
 * description:请求状态
 * @author 奈德丽
 * @date 2018/8/2 12:56
 */
enum class RequestState {
  Start,//请求开始
  NoNetwork,//无网络
  Success,//请求成功
  ServerError,//请求服务器返回的错误
  Error,//请求未知错误
}
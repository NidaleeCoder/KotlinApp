package com.nidalee.kotlin.repository

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/11 17:36
 */
interface IRepository {

  fun <T> getApi(retrofitApi: Class<T>): T

}
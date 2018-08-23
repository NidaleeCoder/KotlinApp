package com.kotlin.nidalee.repository_lib.net.api

import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/14 19:59
 */
interface EyeApi {

  /**
   * 开眼获取分类
   */
  @GET("http://baobab.kaiyanapp.com/api/v4/categories")
  fun getCategory(): Observable<ArrayList<CategoryBean>>

  /**
   * 获取分类详情List
   */
  @GET("http://baobab.kaiyanapp.com/api/v4/categories/videoList?")
  fun getCategoryDetailList(
    @Query("start") start:Long,
    @Query("num") num:Long,
    @Query("strategy") strategy:String,
    @Query("id") id: Long,
    @Query("udid") udid: String,
    @Query("deviceModel") device:String): Observable<Issue>
}
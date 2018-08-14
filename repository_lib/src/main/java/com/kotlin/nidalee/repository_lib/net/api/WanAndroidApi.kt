package com.kotlin.nidalee.repository_lib.net.api

import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.nidalee.kotlin.net.BaseResultBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/14 19:59
 */
interface WanAndroidApi {

  /**
   * 首页文章列表
   */
  @GET("article/list/{page}/json")
  fun getHomeArticleList(@Path("page") page:Int): Observable<BaseResultBean<HomeArticleBean>>

  /**
   * 首页Banner
   */
  @GET("banner/json")
  fun getHomeBanner():Observable<BaseResultBean<MutableList<HomeBannerBean>>>
}
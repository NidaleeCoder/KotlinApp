package com.kotlin.nidalee.repository_lib.net.api

import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HotKeyBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.NavigationBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeListBean
import com.kotlin.nidalee.repository_lib.net.bean.android.WebSitesBean
import com.nidalee.kotlin.net.BaseResultBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
  fun getHomeArticleList(@Path("page") page: Int): Observable<BaseResultBean<HomeArticleBean>>

  /**
   * 首页Banner
   */
  @GET("banner/json")
  fun getHomeBanner(): Observable<BaseResultBean<MutableList<HomeBannerBean>>>

  /**
   * 常用网站
   */
  @GET("friend/json")
  fun getCommonWebsites(): Observable<BaseResultBean<MutableList<WebSitesBean>>>

  /**
   * 热搜词汇
   */
  @GET("hotkey/json")
  fun getHotKey(): Observable<BaseResultBean<MutableList<HotKeyBean>>>

  /**
   * 知识体系
   */
  @GET("tree/json")
  fun getKnowledge(): Observable<BaseResultBean<MutableList<KnowledgeTreeBean>>>

  /**
   * 知识体系文章列表
   */
  @GET("article/list/{page}/json")
  fun getKnowledgeArticleList(
    @Path("page") page: Int,
    @Query("cid") cid: Int
  ): Observable<BaseResultBean<KnowledgeArticleBean>>

  /**
   * 导航数据
   */
  @GET("navi/json")
  fun getNavigation(): Observable<BaseResultBean<MutableList<NavigationBean>>>

  /**
   * 项目分类
   */
  @GET("project/tree/json")
  fun getProjectTree(): Observable<BaseResultBean<MutableList<ProjectTreeBean>>>

  /**
   * 项目分类列表数据
   */
  @GET("project/list/{page}/json")
  fun getProjectList(
    @Path("page") page: Int,
    @Query("cid") cid: Int
  ): Observable<BaseResultBean<ProjectTreeListBean>>

}
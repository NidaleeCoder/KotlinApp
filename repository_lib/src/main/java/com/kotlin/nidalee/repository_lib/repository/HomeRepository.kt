package com.kotlin.nidalee.repository_lib.repository

import com.example.nidalee.usekotlin.net.RequestFunction
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.api.WanAndroidApi
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HotKeyBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.NavigationBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeListBean
import com.kotlin.nidalee.repository_lib.net.bean.android.WebSitesBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.nidalee.kotlin.repository.BaseRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/1 18:51
 */

object HomeRepository : BaseRepository() {

  private var homeApi: WanAndroidApi = getApi(WanAndroidApi::class.java)


  /**
   * 获取首页Banner
   */
  fun getHomeBanner(): Observable<MutableList<HomeBannerBean>> {
    return homeApi.getHomeBanner()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 获取首页文章列表
   */
  fun getHomeArticleList(page: Int): Observable<HomeArticleBean> {
    return homeApi.getHomeArticleList(page)
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 常用网站
   */
  fun getWebsites(): Observable<MutableList<WebSitesBean>> {
    return homeApi.getCommonWebsites()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 热搜词汇
   */
  fun getHotKey(): Observable<MutableList<HotKeyBean>> {
    return homeApi.getHotKey()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 知识体系
   */
  fun getKnowledge(): Observable<MutableList<KnowledgeTreeBean>> {
    return homeApi.getKnowledge()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 知识体系文章列表
   */
  fun getKnowledgeList(page: Int, cid: Int): Observable<KnowledgeArticleBean> {
    return homeApi.getKnowledgeArticleList(page, cid)
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 导航数据
   */
  fun getNavigation(): Observable<MutableList<NavigationBean>> {
    return homeApi.getNavigation()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 项目分类
   */
  fun getProjectTree(): Observable<MutableList<ProjectTreeBean>> {
    return homeApi.getProjectTree()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 项目分类列表数据
   */
  fun getProjectTreeList(page: Int, cid: Int): Observable<ProjectTreeListBean> {
    return homeApi.getProjectList(page, cid)
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}
package com.nidalee.kotlin.model

import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HotKeyBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.NavigationBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeListBean
import com.kotlin.nidalee.repository_lib.net.bean.android.WebSitesBean
import com.kotlin.nidalee.repository_lib.repository.HomeRepository
import io.reactivex.Observable

/**
 * description:
 * @author 奈德丽
 */
class HomeModel {

  fun getHomeBanner(): Observable<MutableList<HomeBannerBean>> {
    return HomeRepository.getHomeBanner()
  }

  fun getHomeArtiList(page: Int): Observable<HomeArticleBean> {
    return HomeRepository.getHomeArticleList(page)
  }

  fun getCommonWebsites(): Observable<MutableList<WebSitesBean>> {
    return HomeRepository.getWebsites()
  }

  fun getHotKey(): Observable<MutableList<HotKeyBean>> {
    return HomeRepository.getHotKey()
  }

  fun getKnowledgeTree(): Observable<MutableList<KnowledgeTreeBean>> {
    return HomeRepository.getKnowledge()
  }

  fun getKnowledgeTreeList(page: Int, cid: Int): Observable<KnowledgeArticleBean> {
    return HomeRepository.getKnowledgeList(page, cid)
  }

  fun getNavigation(): Observable<MutableList<NavigationBean>> {
    return HomeRepository.getNavigation()
  }

  fun getProjectTree(): Observable<MutableList<ProjectTreeBean>> {
    return HomeRepository.getProjectTree()
  }

  fun getProjectTreeList(page: Int, cid: Int): Observable<ProjectTreeListBean> {
    return HomeRepository.getProjectTreeList(page, cid)
  }
}
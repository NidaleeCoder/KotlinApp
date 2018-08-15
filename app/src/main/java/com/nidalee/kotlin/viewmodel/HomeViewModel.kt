package com.nidalee.kotlin.viewmodel

import android.arch.lifecycle.MediatorLiveData
import com.example.nidalee.usekotlin.net.BaseObserver
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HotKeyBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.NavigationBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeListBean
import com.kotlin.nidalee.repository_lib.net.bean.android.WebSitesBean
import com.nidalee.kotlin.base.BaseViewModel
import com.nidalee.kotlin.model.HomeModel
import com.nidalee.kotlin.net.UIDataBean

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/14 20:28
 */
class HomeViewModel : BaseViewModel() {

  private val homeModel = HomeModel()

  //banner
  val bannerLiveData = MediatorLiveData<UIDataBean<MutableList<HomeBannerBean>>>()

  fun getHomeBanner() {
    homeModel.getHomeBanner().subscribe(BaseObserver(bannerLiveData))
  }

  //首页文章列表
  val articleLiveData = MediatorLiveData<UIDataBean<HomeArticleBean>>()

  fun getHomeArticleList(page: Int) {
    homeModel.getHomeArtiList(page).subscribe(BaseObserver(articleLiveData))
  }

  //常用网站
  val websitesLiveData = MediatorLiveData<UIDataBean<MutableList<WebSitesBean>>>()

  fun getCommonWebSites() {
    homeModel.getCommonWebsites().subscribe(BaseObserver(websitesLiveData))
  }

  //热搜词汇
  val hotKeyLiveData = MediatorLiveData<UIDataBean<MutableList<HotKeyBean>>>()

  fun getHotKey() {
    homeModel.getHotKey().subscribe(BaseObserver(hotKeyLiveData))
  }

  //知识体系
  val knowledgeTreeLiveData = MediatorLiveData<UIDataBean<MutableList<KnowledgeTreeBean>>>()

  fun getKnowledgeTree() {
    homeModel.getKnowledgeTree().subscribe(BaseObserver(knowledgeTreeLiveData))
  }

  //知识体系下文章列表
  val knowledgeTreeListLiveData = MediatorLiveData<UIDataBean<KnowledgeArticleBean>>()

  fun getKnowledgeTreeList(page: Int, cid: Int) {
    homeModel.getKnowledgeTreeList(page, cid).subscribe(BaseObserver(knowledgeTreeListLiveData))
  }

  //导航数据
  val navigationLiveData = MediatorLiveData<UIDataBean<MutableList<NavigationBean>>>()

  fun getNavigation() {
    homeModel.getNavigation().subscribe(BaseObserver(navigationLiveData))
  }

  //项目分类
  val projectLiveData = MediatorLiveData<UIDataBean<MutableList<ProjectTreeBean>>>()

  fun getProjectTree() {
    homeModel.getProjectTree().subscribe(BaseObserver(projectLiveData))
  }

  //项目分类下的列表数据
  val projectListLiveData = MediatorLiveData<UIDataBean<ProjectTreeListBean>>()

  fun getProjectList(page: Int, cid: Int) {
    homeModel.getProjectTreeList(page, cid).subscribe(BaseObserver(projectListLiveData))
  }
}
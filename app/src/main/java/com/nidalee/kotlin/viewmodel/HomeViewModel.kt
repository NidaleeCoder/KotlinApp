package com.nidalee.kotlin.viewmodel

import android.arch.lifecycle.MediatorLiveData
import com.example.nidalee.usekotlin.net.BaseObserver
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
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

  val articleLiveData = MediatorLiveData<UIDataBean<HomeArticleBean>>()
  fun getHomeArticleList(page:Int){
    homeModel.getHomeArtiList(page).subscribe(BaseObserver(articleLiveData))
  }

  val bannerLiveData = MediatorLiveData<UIDataBean<MutableList<HomeBannerBean>>>()
  fun getHomeBanner(){
    homeModel.getHomeBanner().subscribe(BaseObserver(bannerLiveData))
  }

}
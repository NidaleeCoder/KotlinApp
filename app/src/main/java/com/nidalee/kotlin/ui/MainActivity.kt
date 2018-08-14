package com.nidalee.kotlin.ui

import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.nidalee.kotlin.R.layout
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.viewmodel.HomeViewModel
import com.orhanobut.logger.Logger

class MainActivity : BaseActivity() {

  var homeViewModel: HomeViewModel? = null

  override fun initLayout(): Int {
    return layout.activity_main
  }

  override fun initView() {
    super.initView()
    homeViewModel = HomeViewModel()
  }

  override fun initData() {
    super.initData()
    observerRequestData()
    homeViewModel?.getHomeBanner()
    homeViewModel?.getHomeArticleList(1)
  }

  fun observerRequestData(){

    homeViewModel?.bannerLiveData?.observe(this, object : UIBaseLiveData<MutableList<HomeBannerBean>>() {
      override fun onSuccess(t: MutableList<HomeBannerBean>?) {
        Logger.d(t)
      }

      override fun onError(errorMsg: String?) {
        Logger.d(errorMsg)
      }
    })

    homeViewModel?.articleLiveData?.observe(this,object :UIBaseLiveData<HomeArticleBean>(){
      override fun onSuccess(t: HomeArticleBean?) {
        Logger.d(t)
      }

      override fun onError(errorMsg: String?) {
        Logger.d(errorMsg)
      }
    })
  }

}

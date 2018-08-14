package com.kotlin.nidalee.repository_lib.repository

import com.example.nidalee.usekotlin.net.RequestFunction
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.api.WanAndroidApi
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
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

  fun getHomeArticleList(page: Int): Observable<HomeArticleBean> {
    return homeApi.getHomeArticleList(page)
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  fun getHomeBanner(): Observable<MutableList<HomeBannerBean>> {
    return homeApi.getHomeBanner()
      .map(RequestFunction())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}
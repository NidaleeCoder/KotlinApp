package com.nidalee.kotlin.model

import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.kotlin.nidalee.repository_lib.repository.HomeRepository
import io.reactivex.Observable

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/14 20:04
 */
class HomeModel {

  fun getHomeBanner():Observable<MutableList<HomeBannerBean>>{
    return HomeRepository.getHomeBanner()
  }

  fun getHomeArtiList(page:Int):Observable<HomeArticleBean>{
    return HomeRepository.getHomeArticleList(page)
  }

}
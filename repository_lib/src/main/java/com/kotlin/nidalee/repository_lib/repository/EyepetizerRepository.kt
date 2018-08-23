package com.kotlin.nidalee.repository_lib.repository

import com.kotlin.nidalee.common_lib.di.AppComponent
import com.kotlin.nidalee.repository_lib.net.api.EyeApi
import com.kotlin.nidalee.repository_lib.net.api.WanAndroidApi
import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import com.nidalee.kotlin.repository.BaseRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 11:54
 */
object EyepetizerRepository : BaseRepository() {

  private var eyeApi: EyeApi = EyepetizerRepository.getApi(EyeApi::class.java)

  /**
   * 分类
   */
  fun getCategroy(): Observable<ArrayList<CategoryBean>> {
    return EyepetizerRepository.eyeApi.getCategory()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  /**
   * 分类详情
   */
  fun getCategoryDetailList(start: Long, id: Long): Observable<Issue> {
    return EyepetizerRepository.eyeApi.getCategoryDetailList(
      start, 10, "date", id,
      "d2807c895f0348a180148c9dfa6f2feeac0781b5", "nidalee"
    )
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}
package com.nidalee.kotlin.model

import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import com.kotlin.nidalee.repository_lib.repository.EyepetizerRepository
import com.kotlin.nidalee.repository_lib.repository.HomeRepository
import io.reactivex.Observable

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 11:57
 */
class EyeModel {

  fun getCategroy(): Observable<ArrayList<CategoryBean>> {
    return EyepetizerRepository.getCategroy()
  }

  fun getCategoryDetailList(start:Long,id:Long):Observable<Issue>{
    return EyepetizerRepository.getCategoryDetailList(start,id)
  }
}
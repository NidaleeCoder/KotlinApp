package com.nidalee.kotlin.viewmodel

import android.arch.lifecycle.MediatorLiveData
import com.example.nidalee.usekotlin.net.BaseObserver
import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import com.nidalee.kotlin.model.EyeModel
import com.nidalee.kotlin.net.UIDataBean

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 11:58
 */
class EyeViewModel {

  private val eyeModel = EyeModel()

  val categoryLiveData = MediatorLiveData<UIDataBean<ArrayList<CategoryBean>>>()
  fun getCategroy(){
    eyeModel.getCategroy().subscribe(BaseObserver(categoryLiveData))
  }

  val categoryDetailsLiveData = MediatorLiveData<UIDataBean<Issue>>()
  fun getCategoryDetailList(start:Long,id:Long){
    eyeModel.getCategoryDetailList(start,id).subscribe(BaseObserver(categoryDetailsLiveData))
  }
}
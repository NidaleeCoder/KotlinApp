package com.nidalee.kotlin.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/2 20:09
 */
abstract class BaseFragment: Fragment(){

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(initLayout(),container,false)
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    initView()
    initData()
  }

  protected abstract fun initLayout():Int

  protected open fun initView(){

  }

  protected open fun initData(){

  }
}
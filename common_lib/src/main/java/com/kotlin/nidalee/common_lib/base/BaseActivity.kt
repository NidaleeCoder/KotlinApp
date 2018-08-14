package com.nidalee.kotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.ScreenUtils

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/2 19:55
 */
abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //屏幕适配
    if (ScreenUtils.isPortrait())
      ScreenUtils.adaptScreen4VerticalSlide(this, 360)
    else
      ScreenUtils.adaptScreen4HorizontalSlide(this, 360)
    //设置布局
    setContentView(initLayout())
    initView()
    initData()
  }

  protected abstract fun initLayout(): Int

  protected open fun initView() {

  }

  protected open fun initData() {

  }
}
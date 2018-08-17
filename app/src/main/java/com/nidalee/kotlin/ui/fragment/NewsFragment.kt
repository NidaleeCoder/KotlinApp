package com.nidalee.kotlin.ui.fragment

import android.view.View
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.orhanobut.logger.Logger
import org.jetbrains.anko.support.v4.toast

/**
 * description:
 * @author 奈德丽
 */
class NewsFragment : BaseFragment() {
  override fun initLayout(): Int {
    return R.layout.fragment_news
  }

  override fun initView() {
    super.initView()
    //使用声明的高阶函数
    val common: (a: Int, b: Int) -> Int = { a, b -> a + b }
    Logger.d("高阶函数使用一：${highFun01(5, 9, common)}")

    val list = arrayListOf(4,5,6)
    toast("sss${list.translate { "sb$it" }}")
  }

  /**
   * 声明一个高阶函数
   */
  private fun highFun01(a: Int, b: Int, common: (x: Int, y: Int) -> Int): Int {
    return common(a, b)
  }

  /**
   * 声明一个泛型函数，扩展函数，参数使用高阶函数
   */
  private fun <T, R> List<T>.translate(trans: (T) -> R): List<R> {
    val list = arrayListOf<R>()
    for (result in this){
      //this指调用者本身
      list.add(trans(result))
    }
    return list
  }
}
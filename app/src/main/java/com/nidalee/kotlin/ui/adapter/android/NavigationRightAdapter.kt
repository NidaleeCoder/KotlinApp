package com.nidalee.kotlin.ui.adapter.android

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.android.Article
import com.nidalee.kotlin.R

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/22 17:24
 */
class NavigationRightAdapter(list:MutableList<Article>?):BaseQuickAdapter<Article,BaseViewHolder>(R.layout.item_navigation_right,list) {
  override fun convert(helper: BaseViewHolder, item: Article) {
    helper.getView<TextView>(R.id.navigation_right_tv).text = item.title
  }
}
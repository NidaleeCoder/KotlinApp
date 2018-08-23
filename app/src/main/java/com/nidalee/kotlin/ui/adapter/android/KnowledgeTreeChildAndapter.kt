package com.nidalee.kotlin.ui.adapter.android

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.android.Children
import com.nidalee.kotlin.R

/**
 * description:
 * @author 奈德丽
 */
class KnowledgeTreeChildAndapter(list: MutableList<Children>?) :
  BaseQuickAdapter<Children, BaseViewHolder>(R.layout.item_knowledge_tree_child,list) {
  override fun convert(helper: BaseViewHolder?, item: Children?) {
    helper?.apply {
      helper.getView<TextView>(R.id.item_knowledge_tree_child_tv).text = item?.name
    }
  }
}
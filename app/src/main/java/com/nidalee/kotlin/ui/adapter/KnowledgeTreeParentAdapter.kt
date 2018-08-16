package com.nidalee.kotlin.ui.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.nidalee.kotlin.R

/**
 * description:
 * @author 奈德丽
 */
class KnowledgeTreeParentAdapter(list: MutableList<KnowledgeTreeBean>?) :
  BaseQuickAdapter<KnowledgeTreeBean, BaseViewHolder>(R.layout.item_knowledge_tree_parent, list) {
  override fun convert(helper: BaseViewHolder?, item: KnowledgeTreeBean?) {
    helper?.apply {
      getView<TextView>(R.id.item_knowledge_tree_parent_tv).text = item?.name
    }
  }
}
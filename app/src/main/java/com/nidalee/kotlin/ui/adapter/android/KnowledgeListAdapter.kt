package com.nidalee.kotlin.ui.adapter.android

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.android.Data
import com.nidalee.kotlin.R

/**
 * description:
 * @author 奈德丽
 */
class KnowledgeListAdapter(list: MutableList<Data>?) :
  BaseQuickAdapter<Data, BaseViewHolder>(R.layout.item_knowledge_list, list) {
  override fun convert(helper: BaseViewHolder?, item: Data?) {
    helper?.apply {
      helper.getView<TextView>(R.id.item_knowledge_list_title).text = item?.title
      helper.getView<TextView>(R.id.item_knowledge_list_author).text = item?.author
      helper.getView<TextView>(R.id.item_knowledge_list_time).text = item?.niceDate
    }
  }
}
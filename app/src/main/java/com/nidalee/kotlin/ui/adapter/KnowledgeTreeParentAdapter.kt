package com.nidalee.kotlin.ui.adapter

import android.graphics.Color
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

  private var mCurPosition = 0

  fun setPosition(pos:Int){
    mCurPosition = pos
    notifyDataSetChanged()
  }

  override fun convert(helper: BaseViewHolder?, item: KnowledgeTreeBean?) {
    helper?.apply {
      val mTv = getView<TextView>(R.id.item_knowledge_tree_parent_tv)
      mTv.text = item?.name
      if (helper.adapterPosition == mCurPosition) {
        mTv.setBackgroundColor(Color.parseColor("#ffffff"))
        mTv.setTextColor(mContext.resources.getColor(R.color.colorAccent))
      }else{
        mTv.setBackgroundColor(Color.parseColor("#f4f7f4"))
        mTv.setTextColor(Color.parseColor("#999999"))
      }
    }
  }
}
package com.nidalee.kotlin.ui.adapter

import android.graphics.Color
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.android.NavigationBean
import com.nidalee.kotlin.R

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/22 17:14
 */
class NavigationLeftAdapter(list:MutableList<NavigationBean>?):
  BaseQuickAdapter<NavigationBean,BaseViewHolder>(R.layout.item_navigation_parent,list) {
  private var mCurPosition = 0

  fun setPosition(pos:Int){
    mCurPosition = pos
    notifyDataSetChanged()
  }

  override fun convert(helper: BaseViewHolder, item: NavigationBean) {
    val mTv = helper.getView<TextView>(R.id.navigation_item_parent_tv)
    mTv.text = item.name
    if (helper.adapterPosition == mCurPosition) {
      mTv.setBackgroundColor(Color.parseColor("#ffffff"))
      mTv.setTextColor(mContext.resources.getColor(R.color.colorAccent))
    }else{
      mTv.setBackgroundColor(Color.parseColor("#f4f7f4"))
      mTv.setTextColor(Color.parseColor("#999999"))
    }
  }
}
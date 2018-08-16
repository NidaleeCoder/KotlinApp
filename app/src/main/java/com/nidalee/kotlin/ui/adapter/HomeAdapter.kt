package com.nidalee.kotlin.ui.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.nidalee.usekotlin.net.bean.HomeArticleListBean
import com.nidalee.kotlin.R

/**
 * description:
 * @author 奈德丽
 */
class HomeAdapter(data: MutableList<HomeArticleListBean>?) :
  BaseQuickAdapter<HomeArticleListBean, BaseViewHolder>(R.layout.item_home_article,data) {
  override fun convert(helper: BaseViewHolder?, item: HomeArticleListBean?) {
    Glide.with(mContext).load(item!!.envelopePic).into(helper!!.getView(R.id.article_item_img))
    var titleTv: TextView = helper.getView(R.id.article_item_title)
    titleTv.text = item.title
    var authorTv: TextView = helper.getView(R.id.article_item_autor)
    authorTv.text = item.author
    var timeTv: TextView = helper.getView(R.id.article_item_time)
    timeTv.text = item.niceDate
  }
}
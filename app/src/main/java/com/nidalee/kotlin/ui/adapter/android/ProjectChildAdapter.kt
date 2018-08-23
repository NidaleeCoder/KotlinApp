package com.nidalee.kotlin.ui.adapter.android

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.android.Children
import com.kotlin.nidalee.repository_lib.net.bean.android.Datas
import com.nidalee.kotlin.R
import com.nidalee.kotlin.utils.image.ImageLoaderTools

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/18 15:38
 */
class ProjectChildAdapter(list: MutableList<Datas>?) :
  BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.item_project_list, list) {
  override fun convert(helper: BaseViewHolder, item: Datas) {
    val imageView = helper.getView<ImageView>(R.id.item_project_img)
    ImageLoaderTools.loadImageCenterCrop(mContext, item.envelopePic, imageView)
    helper.getView<TextView>(R.id.item_project_title).text = item.title
    helper.getView<TextView>(R.id.item_project_content).text = item.desc
    helper.getView<TextView>(R.id.item_project_author).text = item.author
    helper.getView<TextView>(R.id.item_project_time).text = item.niceDate
  }
}
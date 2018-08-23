package com.nidalee.kotlin.ui.adapter.eye

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kotlin.nidalee.repository_lib.net.bean.eye.IssueChild
import com.nidalee.kotlin.R
import com.nidalee.kotlin.utils.image.ImageLoaderTools

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 17:06
 */
class EyeCategoryDetailAdapter(list: List<IssueChild>?) :
  BaseQuickAdapter<IssueChild, BaseViewHolder>(
    R.layout.item_eye_category, list
  ) {
  override fun convert(helper: BaseViewHolder, item: IssueChild) {
    ImageLoaderTools.loadImageCenterCrop(mContext,item.data.cover.feed,helper.getView(R.id.eye_item_category_img))
    helper.getView<TextView>(R.id.eye_item_category_tv).text = item.data.title
  }
}
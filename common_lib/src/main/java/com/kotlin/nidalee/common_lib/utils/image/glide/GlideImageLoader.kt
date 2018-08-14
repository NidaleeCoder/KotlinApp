package com.nidalee.kotlin.utils.image.glide

import android.content.Context
import android.widget.ImageView

/**
 * description:
 *
 * Glide 图片加载
 *
 * @author 奈德丽
 * @date 2018/8/3 15:39
 */
class GlideImageLoader private constructor() {
  companion object {

    /**
     * CenterCrop模式图片加载
     * @param holderRes:占位图
     */
    fun loadImageCenterCrop(context: Context, url: String, iv: ImageView, holderRes: Int) {
      GlideApp.with(context).asBitmap().load(url).placeholder(holderRes).centerCrop().into(iv)
    }

    /**
     * CenterCrop模式图片加载
     */
    fun loadImageCenterCrop(context: Context, url: String, iv: ImageView) {
      GlideApp.with(context).asBitmap().load(url).centerCrop().into(iv)
    }
  }
}


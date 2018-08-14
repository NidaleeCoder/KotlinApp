package com.nidalee.kotlin.utils.image

import android.content.Context
import android.widget.ImageView
import com.nidalee.kotlin.utils.image.glide.GlideImageLoader

/**
 * description:
 *
 * 图片加载工具
 *
 * @author 奈德丽
 * @date 2018/8/3 15:39
 */
class ImageLoaderTools private constructor() {
  companion object {

    fun loadImageCenterCrop(context: Context, url: String, iv: ImageView, holderRes: Int) {
      GlideImageLoader.loadImageCenterCrop(context,url,iv,holderRes)
    }

    fun loadImageCenterCrop(context: Context, url: String, iv: ImageView) {
      GlideImageLoader.loadImageCenterCrop(context,url,iv)
    }
  }
}
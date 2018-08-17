package com.nidalee.kotlin.utils

import android.content.Context
import android.widget.ImageView
import com.nidalee.kotlin.utils.image.ImageLoaderTools
import com.youth.banner.loader.ImageLoader

/**
 * description:
 *
 * @author 奈德丽
 * @date 2018/6/15 15:41
 */
class BannerLoader : ImageLoader() {
  override fun displayImage(context: Context, path: Any, imageView: ImageView) {
    ImageLoaderTools.loadImageCenterCrop(context,path.toString(),imageView)
  }
}

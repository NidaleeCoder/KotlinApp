package com.nidalee.kotlin.ui.activity.eye

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.nidalee.kotlin.utils.image.ImageLoaderTools
import kotlinx.android.synthetic.main.activity_play_details.video_player
import org.jetbrains.anko.startActivity

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 20:53
 */
class PlayActivity : BaseActivity() {
  override fun initLayout(): Int = R.layout.activity_play_details

  private lateinit var orientationUtils: OrientationUtils

  companion object {
    fun startActivity(context: Context, imageUrl: String, playUrl: String) {
      context.startActivity<PlayActivity>("imageUrl" to imageUrl, "playUrl" to playUrl)
    }
  }

  override fun initView() {
    super.initView()
    val source1 = intent.getStringExtra("playUrl")
    video_player.setUp(source1, true, "测试视频")
    //增加封面
    val imageView = ImageView(this)
    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    ImageLoaderTools.loadImageCenterCrop(baseContext,intent.getStringExtra("imageUrl"),imageView)
    video_player.thumbImageView = imageView
    //增加title
    video_player.titleTextView.visibility = View.VISIBLE
    //设置返回键
    video_player.backButton.visibility = View.VISIBLE
    //设置旋转
    orientationUtils = OrientationUtils(this, video_player)
    //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
    video_player.fullscreenButton.setOnClickListener { orientationUtils.resolveByClick() }
    //是否可以滑动调整
    video_player.setIsTouchWiget(true)
    //设置返回按键功能
    video_player.backButton.setOnClickListener { onBackPressed() }
    video_player.startPlayLogic()
  }
}
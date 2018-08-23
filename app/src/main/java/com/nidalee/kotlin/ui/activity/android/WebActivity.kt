package com.nidalee.kotlin.ui.activity.android

import android.content.Context
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import android.widget.LinearLayout
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web.content_view
import kotlinx.android.synthetic.main.common_title_layout.common_back
import kotlinx.android.synthetic.main.common_title_layout.common_title
import org.jetbrains.anko.startActivity

/**
 * description:
 * @author 奈德丽
 */
class WebActivity: BaseActivity() {
  override fun initLayout(): Int = R.layout.activity_web

  private var mUrl = ""

  companion object {
    fun startActivity(context:Context,url:String,title:String){
      context.startActivity<WebActivity>("url" to url,"title" to title)
    }
  }

  override fun initView() {
    super.initView()
    common_title.text = intent.getStringExtra("title")
    common_back.setOnClickListener{finish()}
    mUrl = intent.getStringExtra("url")
    AgentWeb.with(this)
      .setAgentWebParent(content_view, LinearLayout.LayoutParams(-1, -1))
      .useDefaultIndicator()
      .createAgentWeb()
      .ready()
      .go(mUrl)
  }
}
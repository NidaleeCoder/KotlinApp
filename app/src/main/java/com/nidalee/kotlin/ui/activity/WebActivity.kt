package com.nidalee.kotlin.ui.activity

import android.content.Context
import android.content.Intent
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import android.widget.LinearLayout
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web.content_view

/**
 * description:
 * @author 奈德丽
 */
class WebActivity: BaseActivity() {
  override fun initLayout(): Int {
    return R.layout.activity_web
  }

  private var mUrl = ""

  companion object {
    fun startActivity(contex:Context,url:String){
      contex.startActivity(Intent(contex,WebActivity::class.java).putExtra("url",url))
    }
  }

  override fun initView() {
    super.initView()
    mUrl = intent.getStringExtra("url")
    AgentWeb.with(this)
      .setAgentWebParent(content_view, LinearLayout.LayoutParams(-1, -1))
      .useDefaultIndicator()
      .createAgentWeb()
      .ready()
      .go(mUrl)
  }
}
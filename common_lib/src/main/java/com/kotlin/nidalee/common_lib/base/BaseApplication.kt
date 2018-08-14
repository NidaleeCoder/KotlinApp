package com.nidalee.kotlin.base

import android.app.Application
import com.kotlin.nidalee.common_lib.di.AppComponent
import com.kotlin.nidalee.common_lib.di.DaggerAppComponent
import com.nidalee.kotlin.dagger.module.AppModule
import com.nidalee.kotlin.dagger.module.HttpModule
import okhttp3.HttpUrl

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/3 16:47
 */
open class BaseApplication: Application() {

  override fun onCreate() {
    super.onCreate()
    initDagger()
  }

  /**
   * 初始化注解相关的东西
   */
  private fun initDagger(){
    appComponent = DaggerAppComponent.builder()
      .httpModule(HttpModule(HttpUrl.parse(getBaseUrl())!!))
      .appModule(AppModule(this)).build()

  }

  fun getBaseUrl():String{
    return "http://www.wanandroid.com/"
  }

  companion object {
    var appComponent: AppComponent? = null
  }

}
package com.nidalee.kotlin.dagger.module

import android.app.Application
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/3 12:28
 */
@Module
class AppModule(application: Application) {

  private val mApplication = application

  /**
   * Application提供者
   */
  @Provides
  fun provideApplication(): Application {
    return mApplication
  }

  /**
   * Gson提供者
   */
  @Provides
  fun provideGson(): Gson {
    return Gson()
  }
}
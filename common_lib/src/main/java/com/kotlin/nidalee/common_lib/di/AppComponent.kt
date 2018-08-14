package com.kotlin.nidalee.common_lib.di

import android.app.Application
import com.google.gson.Gson
import com.nidalee.kotlin.dagger.module.AppModule
import com.nidalee.kotlin.dagger.module.HttpModule
import dagger.Component
import retrofit2.Retrofit

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/1 16:37
 */
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface AppComponent {

  /**
   * 获取Application
   */
  fun getApplication(): Application

  /**
   * 获取Gson
   */
  fun getGson(): Gson

  /**
   * 获取Retrofit
   */
  fun getRetrofit(): Retrofit
}
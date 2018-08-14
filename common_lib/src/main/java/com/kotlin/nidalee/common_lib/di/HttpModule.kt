package com.nidalee.kotlin.dagger.module

import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/11 14:46
 */
@Module
class HttpModule constructor(httpUrl: HttpUrl) {

  var mBaseUrl: HttpUrl = httpUrl

  /**
   * 提供BaseUrl
   */
  @Provides
  fun provideHttpUrl(): HttpUrl {
    return mBaseUrl
  }

  /**
   * 提供okhttp builder
   */
  @Provides
  fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
    val bulider = OkHttpClient.Builder()
    return bulider
  }

  /**
   * 提供OkHttp
   */
  @Provides
  fun providerOkHttp(builder: OkHttpClient.Builder): OkHttpClient {
    return builder.build()
  }

  /**
   * 提供Retrofit
   * @param httpUrl:请求地址
   * @param okHttpClient:okHttp
   */
  @Provides
  fun providerRetrofit(httpUrl: HttpUrl, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(httpUrl)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
  }
}
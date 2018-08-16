package com.nidalee.kotlin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.nidalee.kotlin.ui.activity.WebActivity
import com.nidalee.kotlin.ui.adapter.HomeAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_home.home_recycler_view

/**
 * description:
 * @author 奈德丽
 */
class HomeFragment : BaseFragment() {

  override fun initLayout(): Int {
    return R.layout.fragment_home
  }

  private val linearLayoutManager: LinearLayoutManager by lazy {
    LinearLayoutManager(activity)
  }

  private val homeAdapter: HomeAdapter by lazy {
    HomeAdapter(null)
  }

  private val homeViewModel: HomeViewModel by lazy {
    HomeViewModel()
  }

  override fun initView() {
    super.initView()
    home_recycler_view.run {
      layoutManager = linearLayoutManager
      adapter = homeAdapter
    }
    homeAdapter.setOnItemClickListener { adapter, view, position ->
      WebActivity.startActivity(
        context!!,
        homeAdapter.data[position].link
      )
    }
  }

  override fun initData() {
    super.initData()
    observerRequestData()
    homeViewModel.getHomeBanner()
    homeViewModel.getHomeArticleList(1)
  }

  private fun observerRequestData() {

    homeViewModel?.bannerLiveData?.observe(
      this,
      object : UIBaseLiveData<MutableList<HomeBannerBean>>() {
        override fun onSuccess(t: MutableList<HomeBannerBean>?) {
          Logger.d(t)
        }

        override fun onError(errorMsg: String?) {
          Logger.d(errorMsg)
        }
      })

    homeViewModel?.articleLiveData?.observe(this, object : UIBaseLiveData<HomeArticleBean>() {
      override fun onSuccess(t: HomeArticleBean?) {
        homeAdapter.setNewData(t?.datas)
      }

      override fun onError(errorMsg: String?) {
        Logger.d(errorMsg)
      }
    })
  }
}
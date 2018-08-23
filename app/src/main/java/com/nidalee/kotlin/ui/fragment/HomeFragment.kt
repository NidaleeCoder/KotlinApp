package com.nidalee.kotlin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.OnClickListener
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.example.nidalee.usekotlin.net.bean.HomeArticleBean
import com.kotlin.nidalee.repository_lib.net.bean.android.HomeBannerBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.nidalee.kotlin.ui.activity.android.KnowledgeActivity
import com.nidalee.kotlin.ui.activity.android.NavigationActivity
import com.nidalee.kotlin.ui.activity.android.ProjectActivity
import com.nidalee.kotlin.ui.activity.android.WebActivity
import com.nidalee.kotlin.ui.adapter.android.HomeAdapter
import com.nidalee.kotlin.utils.BannerLoader
import com.nidalee.kotlin.viewmodel.HomeViewModel
import com.orhanobut.logger.Logger
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.home_banner
import kotlinx.android.synthetic.main.fragment_home.home_knowledge_rl
import kotlinx.android.synthetic.main.fragment_home.home_navigation_rl
import kotlinx.android.synthetic.main.fragment_home.home_project_rl
import kotlinx.android.synthetic.main.fragment_home.home_recycler_view
import kotlinx.android.synthetic.main.fragment_home.home_swipe_layout
import org.jetbrains.anko.support.v4.startActivity

/**
 * description:
 * @author 奈德丽
 */
class HomeFragment : BaseFragment(), OnClickListener {

  override fun onClick(v: View?) {
    when (v?.id) {
      R.id.home_knowledge_rl -> {
        startActivity<KnowledgeActivity>()
      }
      R.id.home_project_rl -> {
        startActivity<ProjectActivity>()
      }
      R.id.home_navigation_rl -> {
        startActivity<NavigationActivity>()
      }
    }
  }

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
    home_knowledge_rl.setOnClickListener(this)
    home_project_rl.setOnClickListener(this)
    home_navigation_rl.setOnClickListener(this)

    homeAdapter.setOnItemClickListener { _, _, position ->
      WebActivity.startActivity(
        context!!,
        homeAdapter.data[position].link,
        homeAdapter.data[position].title
      )
    }
    homeAdapter.setOnLoadMoreListener({ getListData() }, home_recycler_view)

    home_swipe_layout.setOnRefreshListener {
      mCurrentPage = 0
      getListData()
    }
  }

  private var mCurrentPage = 0

  override fun initData() {
    super.initData()
    observerRequestData()
    homeViewModel.getHomeBanner()
    getListData()
  }

  private fun getListData() {
    homeViewModel.getHomeArticleList(mCurrentPage)
  }

  private fun observerRequestData() {

    homeViewModel.bannerLiveData.observe(
      this,
      object : UIBaseLiveData<MutableList<HomeBannerBean>>() {
        override fun onSuccess(t: MutableList<HomeBannerBean>?) {
          val urlList = arrayListOf<String>()
          t?.apply {
            for (bean in t) {
              urlList.add(bean.imagePath)
            }
          }
          home_banner.setImageLoader(BannerLoader())
          home_banner.setImages(urlList)
          home_banner.isAutoPlay(true)
          home_banner.setDelayTime(5000)
          home_banner.setIndicatorGravity(BannerConfig.CENTER)
          home_banner.setOnBannerListener {
            WebActivity.startActivity(context!!, t!![it].url, t!![it].title)
          }
          home_banner.start()
        }

        override fun onError(errorMsg: String?) {
          Logger.d(errorMsg)
        }
      })

    homeViewModel.articleLiveData.observe(this, object : UIBaseLiveData<HomeArticleBean>() {
      override fun onSuccess(t: HomeArticleBean?) {
        t?.apply {
          if (mCurrentPage == 0) {
            homeAdapter.setNewData(t.datas)
          } else {
            homeAdapter.addData(t.datas)
          }

          //          if(mCurrentPage < t.pageCount){
          //            mCurrentPage++
          //            homeAdapter.loadMoreComplete()
          //          }else{
          homeAdapter.loadMoreEnd()
          //          }

        }
      }

      override fun onError(errorMsg: String?) {
        Logger.d(errorMsg)
      }
    })
  }
}
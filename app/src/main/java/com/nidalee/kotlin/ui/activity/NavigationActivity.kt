package com.nidalee.kotlin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.HORIZONTAL
import android.support.v7.widget.RecyclerView.LayoutManager
import android.support.v7.widget.RecyclerView.VERTICAL
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.NavigationBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.adapter.NavigationLeftAdapter
import com.nidalee.kotlin.ui.adapter.NavigationRightAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_navigation.navigation_recycler_left
import kotlinx.android.synthetic.main.activity_navigation.navigation_recycler_right
import kotlinx.android.synthetic.main.common_title_layout.common_back
import kotlinx.android.synthetic.main.common_title_layout.common_title

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/22 17:09
 */
class NavigationActivity:BaseActivity(){
  override fun initLayout(): Int = R.layout.activity_navigation

  private val homeViewModel:HomeViewModel by lazy {
    HomeViewModel()
  }

  private val leftAdapter:NavigationLeftAdapter by lazy {
    NavigationLeftAdapter(null)
  }

  private val rightAdapter:NavigationRightAdapter by lazy {
    NavigationRightAdapter(null)
  }

  override fun initView() {
    super.initView()

    common_title.text = "资源导航"
    common_back.setOnClickListener { finish() }

    navigation_recycler_left.run {
      layoutManager = LinearLayoutManager(context)
      adapter = leftAdapter
    }

    navigation_recycler_right.run {
      layoutManager  = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
      adapter = rightAdapter
    }

    leftAdapter.setOnItemClickListener { _, _, position ->
      leftAdapter.setPosition(position)
      rightAdapter.setNewData(leftAdapter.data[position].articles)
    }

    rightAdapter.setOnItemClickListener { _, _, position ->
      WebActivity.startActivity(baseContext,rightAdapter.data[position].link,rightAdapter.data[position].title)
    }
  }

  override fun initData() {
    super.initData()
    homeViewModel.navigationLiveData.observe(this,object :UIBaseLiveData<MutableList<NavigationBean>>(){
      override fun onSuccess(t: MutableList<NavigationBean>?) {
        t?.apply {
          leftAdapter.setNewData(t)
          rightAdapter.setNewData(t[0].articles)
        }
      }
    })
    getListData()
  }

  private fun getListData(){
    homeViewModel.getNavigation()
  }
}
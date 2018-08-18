package com.nidalee.kotlin.ui.fragment

import android.support.design.widget.TabLayout
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.nidalee.kotlin.ui.adapter.ProjectPagerAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_project.tabLayout
import kotlinx.android.synthetic.main.fragment_project.viewPager

/**
 * description:
 * @author 奈德丽
 */
class ProjectFragment: BaseFragment() {
  override fun initLayout(): Int {
    return R.layout.fragment_project
  }

  private var projectResultList = mutableListOf<ProjectTreeBean>()

  private val homeViewModel :HomeViewModel by lazy {
    HomeViewModel()
  }

  private val pagerAdapter:ProjectPagerAdapter by lazy {
    ProjectPagerAdapter(fragmentManager!!,projectResultList)
  }
  override fun initView() {
    super.initView()
  }

  override fun initData() {
    super.initData()
    homeViewModel.projectLiveData.observe(this,object :UIBaseLiveData<MutableList<ProjectTreeBean>>(){
      override fun onSuccess(t: MutableList<ProjectTreeBean>?) {
        projectResultList = t!!

        viewPager.run {
          addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
          adapter = pagerAdapter
        }

        tabLayout.run {
          setupWithViewPager(viewPager)
          addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
        }
      }
    })
    homeViewModel.getProjectTree()
  }
}
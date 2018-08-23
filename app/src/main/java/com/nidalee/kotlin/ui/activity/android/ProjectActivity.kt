package com.nidalee.kotlin.ui.activity.android

import android.support.design.widget.TabLayout
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.adapter.android.ProjectPagerAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_project.tabLayout
import kotlinx.android.synthetic.main.activity_project.viewPager
import kotlinx.android.synthetic.main.common_title_layout.common_back
import kotlinx.android.synthetic.main.common_title_layout.common_title

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/22 14:52
 */
class ProjectActivity:BaseActivity() {
  override fun initLayout(): Int = R.layout.activity_project

  private var projectResultList = mutableListOf<ProjectTreeBean>()

  private val homeViewModel : HomeViewModel by lazy {
    HomeViewModel()
  }

  private val pagerAdapter: ProjectPagerAdapter by lazy {
    ProjectPagerAdapter(
      supportFragmentManager!!,
      projectResultList
    )
  }

  override fun initView() {
    super.initView()
    common_title.text = "项目实战"
    common_back.setOnClickListener { finish() }
  }

  override fun initData() {
    super.initData()
    homeViewModel.projectLiveData.observe(this,object :
      UIBaseLiveData<MutableList<ProjectTreeBean>>(){
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
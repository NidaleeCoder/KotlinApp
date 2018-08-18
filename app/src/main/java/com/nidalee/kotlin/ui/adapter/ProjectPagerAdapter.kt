package com.nidalee.kotlin.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeBean
import com.nidalee.kotlin.ui.fragment.ProjectChildFragment

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/18 14:43
 */
class ProjectPagerAdapter(fm:FragmentManager,private val list: MutableList<ProjectTreeBean>):FragmentStatePagerAdapter(fm){

  private val mFragmentList = mutableListOf<Fragment>()
  init {
    mFragmentList.clear()
    list.forEach {
      mFragmentList.add(ProjectChildFragment.getInstance(it.id))
    }
  }

  override fun getItem(p0: Int): Fragment {
    return mFragmentList[p0]
  }

  override fun getCount(): Int {
    return mFragmentList.size
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return list[position].name
  }
}
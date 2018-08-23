package com.nidalee.kotlin.ui.activity.android

import android.support.v4.app.FragmentTransaction
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.fragment.HomeFragment
import com.nidalee.kotlin.ui.fragment.NewsFragment
import com.nidalee.kotlin.ui.fragment.ProjectFragment
import com.nidalee.kotlin.ui.fragment.EyeFragment
import kotlinx.android.synthetic.main.activity_main.bottom_navigation

class MainActivity : BaseActivity() {

  //Fragment
  private var homeFragment: HomeFragment? = null
  private var searchFragment: EyeFragment? = null
  private var newsFragment: NewsFragment? = null
  private var projectFragment: ProjectFragment? = null



  override fun initLayout(): Int {
    return R.layout.activity_main
  }

  override fun initView() {
    super.initView()
    bottom_navigation.setOnNavigationItemSelectedListener {
      return@setOnNavigationItemSelectedListener when (it.itemId) {
        R.id.action_home -> {
          showFragment(0)
          true
        }
        R.id.action_search -> {
          showFragment(1)
          true
        }
        R.id.action_news -> {
          showFragment(2)
          true
        }
        R.id.action_project -> {
          showFragment(3)
          true
        }
        else -> {
          false
        }
      }
    }
  }

  override fun initData() {
    super.initData()
    showFragment(0)
  }

  private fun showFragment(index: Int) {
    val transaction = supportFragmentManager.beginTransaction()
    hideFragment(transaction)
    when (index) {
      0 -> {
        if (homeFragment == null) {
          homeFragment = HomeFragment()
          homeFragment?.let { transaction.add(R.id.home_content_fl, it) }
        } else {
          homeFragment?.let { transaction.show(it) }
        }
      }
      1->{
        if (searchFragment == null) {
          searchFragment = EyeFragment()
          searchFragment?.let { transaction.add(R.id.home_content_fl, it) }
        } else {
          searchFragment?.let { transaction.show(it) }
        }
      }
      2->{
        if (newsFragment == null) {
          newsFragment = NewsFragment()
          newsFragment?.let { transaction.add(R.id.home_content_fl, it) }
        } else {
          newsFragment?.let { transaction.show(it) }
        }
      }
      3->{
        if (projectFragment == null) {
          projectFragment = ProjectFragment()
          projectFragment?.let { transaction.add(R.id.home_content_fl, it) }
        } else {
          projectFragment?.let { transaction.show(it) }
        }
      }
    }
    transaction.commit()
  }

  private fun hideFragment(fragmentTransaction: FragmentTransaction) {
    homeFragment?.let { fragmentTransaction.hide(it) }
    searchFragment?.let { fragmentTransaction.hide(it) }
    newsFragment?.let { fragmentTransaction.hide(it) }
    projectFragment?.let { fragmentTransaction.hide(it) }
  }
}

package com.nidalee.kotlin.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.ProjectTreeListBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.nidalee.kotlin.ui.adapter.ProjectChildAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_project_list.project_recycler

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/18 14:46
 */
class ProjectChildFragment: BaseFragment() {
  companion object {
    fun getInstance(cid: Int): ProjectChildFragment {
      val fragment = ProjectChildFragment()
      var args = Bundle()
      args.putInt("cid", cid)
      fragment.arguments = args
      return fragment
    }
  }

  private val homeViewModel:HomeViewModel by lazy {
    HomeViewModel()
  }

  private val childAdapter: ProjectChildAdapter by lazy {
    ProjectChildAdapter(null)
  }

  override fun initLayout(): Int {
    return R.layout.activity_project_list
  }

  override fun initView() {
    super.initView()
    project_recycler.run {
      layoutManager = LinearLayoutManager(context)
      adapter = childAdapter
    }
  }

  override fun initData() {
    super.initData()
    homeViewModel.projectListLiveData.observe(this,object :UIBaseLiveData<ProjectTreeListBean>(){
      override fun onSuccess(t: ProjectTreeListBean?) {
        childAdapter.setNewData(t?.datas)
      }
    })
    homeViewModel.getProjectList(0,arguments?.getInt("cid",0)?:-1)
  }
}
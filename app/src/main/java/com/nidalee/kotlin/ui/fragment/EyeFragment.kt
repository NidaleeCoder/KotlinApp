package com.nidalee.kotlin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.nidalee.kotlin.ui.activity.eye.CateGoryDetailsActivity
import com.nidalee.kotlin.ui.adapter.eye.EyeCategoryAdapter
import com.nidalee.kotlin.viewmodel.EyeViewModel
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_search.eye_category_recycler

/**
 * description:
 * @author 奈德丽
 */
class EyeFragment : BaseFragment() {

  override fun initLayout(): Int {
    return R.layout.fragment_search
  }

  private val eyeViewModel: EyeViewModel by lazy {
    EyeViewModel()
  }

  private val eyeCategoryAdapter: EyeCategoryAdapter by lazy {
    EyeCategoryAdapter(null)
  }

  override fun initView() {
    super.initView()

    eye_category_recycler.run {
      layoutManager = GridLayoutManager(activity, 2, RecyclerView.VERTICAL, false)
      adapter = eyeCategoryAdapter
    }

    eyeCategoryAdapter.setOnItemClickListener { _, _, position ->
      CateGoryDetailsActivity.startActivity(
        context!!,
        eyeCategoryAdapter.data[position].id,
        eyeCategoryAdapter.data[position].name
      )
    }
  }

  override fun initData() {
    super.initData()

    eyeViewModel.categoryLiveData.observe(this, object : UIBaseLiveData<ArrayList<CategoryBean>>() {
      override fun onSuccess(t: ArrayList<CategoryBean>?) {
        eyeCategoryAdapter.setNewData(t)
      }
    })

    eyeViewModel.getCategroy()

    eyeViewModel.categoryDetailsLiveData.observe(this, object : UIBaseLiveData<Issue>() {
      override fun onSuccess(t: Issue?) {
        Logger.d(t?.itemList)
      }

      override fun onError(errorMsg: String?) {
        Logger.d(errorMsg)
      }
    })
  }
}
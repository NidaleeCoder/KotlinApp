package com.nidalee.kotlin.ui.activity.eye

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.eye.CategoryBean
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.adapter.eye.EyeCategoryAdapter
import com.nidalee.kotlin.viewmodel.EyeViewModel
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_eye_category.eye_category_recycler
import kotlinx.android.synthetic.main.common_title_layout.common_back
import kotlinx.android.synthetic.main.common_title_layout.common_title

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 12:15
 */
class CateGoryActivity : BaseActivity() {
  override fun initLayout(): Int = R.layout.activity_eye_category

  private val eyeViewModel: EyeViewModel by lazy {
    EyeViewModel()
  }

  private val eyeCategoryAdapter: EyeCategoryAdapter by lazy {
    EyeCategoryAdapter(null)
  }

  override fun initView() {
    super.initView()
    common_back.setOnClickListener { finish() }
    common_title.text = "精彩分类"

    eye_category_recycler.run {
      layoutManager = GridLayoutManager(baseContext, 2, RecyclerView.VERTICAL, false)
      adapter = eyeCategoryAdapter
    }

    eyeCategoryAdapter.setOnItemClickListener { _, _, position ->
      CateGoryDetailsActivity.startActivity(
        baseContext,
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
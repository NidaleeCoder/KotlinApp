package com.nidalee.kotlin.ui.activity.eye

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.eye.Issue
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.adapter.eye.EyeCategoryDetailAdapter
import com.nidalee.kotlin.viewmodel.EyeViewModel
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_eye_category.eye_category_recycler
import kotlinx.android.synthetic.main.common_title_layout.common_back
import kotlinx.android.synthetic.main.common_title_layout.common_title
import org.jetbrains.anko.startActivity

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/23 17:04
 */
class CateGoryDetailsActivity : BaseActivity() {

  override fun initLayout(): Int = R.layout.activity_eye_category

  private val categoryDetailAdapter: EyeCategoryDetailAdapter by lazy {
    EyeCategoryDetailAdapter(null)
  }

  private var start = 0L
  private var id = 0L

  companion object {
    fun startActivity(context: Context, id: Long, title: String) {
      context.startActivity<CateGoryDetailsActivity>("id" to id, "title" to title)
    }
  }

  private val eyeViewModel: EyeViewModel by lazy {
    EyeViewModel()
  }

  override fun initView() {
    super.initView()
    common_title.text = intent.getStringExtra("title")
    common_back.setOnClickListener { finish() }
    id = intent.getLongExtra("id", 0L)
    eye_category_recycler.run {
      layoutManager = LinearLayoutManager(baseContext)
      adapter = categoryDetailAdapter
    }
    categoryDetailAdapter.setOnLoadMoreListener({
      getListDate()
    }, eye_category_recycler)

    categoryDetailAdapter.setOnItemClickListener { _, _, position ->
      PlayActivity.startActivity(
        baseContext,
        categoryDetailAdapter.data[position].data.descriptionPgc,
        categoryDetailAdapter.data[position].data.playUrl
      )
    }
  }

  override fun initData() {
    super.initData()

    eyeViewModel.categoryDetailsLiveData.observe(this, object : UIBaseLiveData<Issue>() {
      override fun onSuccess(t: Issue?) {
        categoryDetailAdapter.loadMoreComplete()
        t?.run {
          if (start == 0L) {
            categoryDetailAdapter.setNewData(t.itemList)
          } else {
            categoryDetailAdapter.addData(t.itemList)
          }
          start += 10
        }
      }

      override fun onError(errorMsg: String?) {
        super.onError(errorMsg)
        Logger.d(errorMsg)
      }
    })

    getListDate()
  }

  private fun getListDate() {
    eyeViewModel.getCategoryDetailList(start, id)
  }
}
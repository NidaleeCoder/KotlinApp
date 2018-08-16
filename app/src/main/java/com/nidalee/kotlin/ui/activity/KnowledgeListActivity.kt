package com.nidalee.kotlin.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeArticleBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.adapter.KnowledgeListAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_knowledge_list.knowledge_list_recycler_view
import kotlinx.android.synthetic.main.common_title_layout.common_title

/**
 * description:
 * @author 奈德丽
 */
class KnowledgeListActivity : BaseActivity() {

  override fun initLayout(): Int {
    return R.layout.activity_knowledge_list
  }

  private var mCid = 0
  private var mTitle = ""

  companion object {
    fun startActivity(context: Context, cid: Int, title: String) {
      context.startActivity(
        Intent(context, KnowledgeListActivity::class.java)
          .putExtra("cid", cid)
          .putExtra("title", title)
      )
    }
  }

  private val knowledgeAdapter: KnowledgeListAdapter by lazy {
    KnowledgeListAdapter(null)
  }

  private val viewModel: HomeViewModel by lazy {
    HomeViewModel()
  }

  override fun initView() {
    super.initView()
    mCid = intent.getIntExtra("cid", 0)
    mTitle = intent.getStringExtra("title")
    common_title.text = mTitle
    knowledge_list_recycler_view.run {
      layoutManager = LinearLayoutManager(this@KnowledgeListActivity)
      adapter = knowledgeAdapter
    }
    knowledgeAdapter.setOnItemClickListener { adapter, view, position ->
      WebActivity.startActivity(baseContext,knowledgeAdapter.data[position].link)
    }
  }

  override fun initData() {
    super.initData()
    viewModel.knowledgeTreeListLiveData.observe(this,
      object : UIBaseLiveData<KnowledgeArticleBean>() {
        override fun onSuccess(t: KnowledgeArticleBean?) {
          knowledgeAdapter.setNewData(t?.datas)
        }
      })
    viewModel.getKnowledgeTreeList(0, mCid)
  }
}
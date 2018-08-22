package com.nidalee.kotlin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseActivity
import com.nidalee.kotlin.ui.adapter.KnowledgeTreeChildAndapter
import com.nidalee.kotlin.ui.adapter.KnowledgeTreeParentAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_knowledge.search_recycler_view_child
import kotlinx.android.synthetic.main.activity_knowledge.search_recycler_view_parent
import kotlinx.android.synthetic.main.common_title_layout.common_back
import kotlinx.android.synthetic.main.common_title_layout.common_title

/**
 * description:
 * @author 奈德丽
 * @date 2018/8/22 14:23
 */
class KnowledgeActivity : BaseActivity() {

  override fun initLayout(): Int = R.layout.activity_knowledge

  private val knowledgeTreeParentAdapter: KnowledgeTreeParentAdapter by lazy {
    KnowledgeTreeParentAdapter(null)
  }

  private val knowledgeTreeChildAdapter: KnowledgeTreeChildAndapter by lazy {
    KnowledgeTreeChildAndapter(null)
  }

  private val homeViewModel: HomeViewModel by lazy {
    HomeViewModel()
  }

  override fun initView() {
    super.initView()

    common_title.text = "知识体系"
    common_back.setOnClickListener { finish() }

    search_recycler_view_parent.run {
      adapter = knowledgeTreeParentAdapter
      layoutManager = LinearLayoutManager(this@KnowledgeActivity)
    }

    search_recycler_view_child.run {
      adapter = knowledgeTreeChildAdapter
      layoutManager = LinearLayoutManager(this@KnowledgeActivity)
    }

    knowledgeTreeParentAdapter.setOnItemClickListener { _, _, position ->
      knowledgeTreeParentAdapter.setPosition(position)
      knowledgeTreeChildAdapter.setNewData(knowledgeTreeParentAdapter.data[position].children)
    }

    knowledgeTreeChildAdapter.setOnItemClickListener { _, _, position ->
      KnowledgeListActivity.startActivity(
        this!!,
        knowledgeTreeChildAdapter.data[position].id,
        knowledgeTreeChildAdapter.data[position].name
      )
    }
  }

  override fun initData() {
    super.initData()

    homeViewModel.knowledgeTreeLiveData.observe(this,
      object : UIBaseLiveData<MutableList<KnowledgeTreeBean>>() {
        override fun onSuccess(t: MutableList<KnowledgeTreeBean>?) {
          knowledgeTreeParentAdapter.setNewData(t)
          t?.apply {
            knowledgeTreeChildAdapter.setNewData(t[0].children)
          }
        }
      })
    homeViewModel.getKnowledgeTree()
  }
}
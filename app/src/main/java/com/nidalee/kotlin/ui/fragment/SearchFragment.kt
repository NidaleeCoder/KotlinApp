package com.nidalee.kotlin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.example.nidalee.usekotlin.net.UIBaseLiveData
import com.kotlin.nidalee.repository_lib.net.bean.android.KnowledgeTreeBean
import com.nidalee.kotlin.R
import com.nidalee.kotlin.base.BaseFragment
import com.nidalee.kotlin.ui.activity.KnowledgeListActivity
import com.nidalee.kotlin.ui.adapter.KnowledgeTreeChildAndapter
import com.nidalee.kotlin.ui.adapter.KnowledgeTreeParentAdapter
import com.nidalee.kotlin.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_search.search_recycler_view_child
import kotlinx.android.synthetic.main.fragment_search.search_recycler_view_parent

/**
 * description:
 * @author 奈德丽
 */
class SearchFragment : BaseFragment() {

  override fun initLayout(): Int {
    return R.layout.fragment_search
  }

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
    search_recycler_view_parent.run {
      adapter = knowledgeTreeParentAdapter
      layoutManager = LinearLayoutManager(activity)
    }
    search_recycler_view_child.run {
      adapter = knowledgeTreeChildAdapter
      layoutManager = LinearLayoutManager(activity)
    }
    knowledgeTreeParentAdapter.setOnItemClickListener { adapter, view, position ->
      knowledgeTreeChildAdapter.setNewData(knowledgeTreeParentAdapter.data.get(position).children)
    }
    knowledgeTreeChildAdapter.setOnItemClickListener { adapter, view, position ->
      KnowledgeListActivity.startActivity(
        context!!,
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
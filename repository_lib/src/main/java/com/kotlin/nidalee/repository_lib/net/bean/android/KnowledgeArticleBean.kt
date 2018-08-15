package com.kotlin.nidalee.repository_lib.net.bean.android

data class KnowledgeArticleBean(
  val curPage: Int,
  val datas: List<Data>,
  val offset: Int,
  val over: Boolean,
  val pageCount: Int,
  val size: Int,
  val total: Int
)